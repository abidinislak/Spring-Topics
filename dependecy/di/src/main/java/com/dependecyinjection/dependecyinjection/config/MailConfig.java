package com.dependecyinjection.dependecyinjection.config;


import com.dependecyinjection.dependecyinjection.mailSender.MailSender;
import com.dependecyinjection.dependecyinjection.mailSender.MockMailSender;
import com.dependecyinjection.dependecyinjection.mailSender.SmtpMailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Configuration
//@Component
public class MailConfig {


    @Profile("dev")
    @Bean
    @ConditionalOnProperty(name = "spring.mail.host",
            havingValue = "foo", matchIfMissing = true)
    public MailSender mockMailSender() {

        return new MockMailSender();
    }

//    @Profile("!dev")
    @Bean
    @ConditionalOnProperty("spring.mail.host")
    public MailSender smtpMailSender(JavaMailSender javaMailSender) {

        return new SmtpMailSender(javaMailSender);
    }

}
