package com.dependecyinjection.dependecyinjection.mailSender;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class MockMailSender implements MailSender{

    private static Log log= LogFactory.getLog(MockMailSender.class);
    @Override
    public void send(String to, String subject, String body) {


        log.info("mock mail to"+to);
        log.info(" mock mail  subject"+subject);
        log.info(" mock mail with body"+body);

    }
}
