package com.dependecyinjection.dependecyinjection.controller;

import com.dependecyinjection.dependecyinjection.mailSender.MailSender;
import com.dependecyinjection.dependecyinjection.mailSender.MockMailSender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {


//    private MailSender mailSender=new MockMailSender();

//@Autowired
//MailSender mailSender;

//@Autowired
//public void  setyMailsender(MailSender mailSender){
//    this.mailSender=mailSender;
//}


    //only one componet
//    public MailController(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
    private final MailSender mailSender;


    //multiple component
//    public MailController(MailSender smtpMailSender) {
//        this.mailSender = smtpMailSender;
//    }


// multiple component with tag
//    public MailController(MailSender smtp) {
//        this.mailSender = smtp;
//    }

// with prinary order
//    public MailController(MailSender test) {
//        this.mailSender = test;
//    }



// Quaileifedr  order
//public MailController( @Qualifier("smtpMail") MailSender test) {
//    this.mailSender = test;
//}

//with configuraiton class
    public MailController( MailSender mailSender) {
        this.mailSender = mailSender;
    }





    @GetMapping("/mail")
    public String mailsender() {


        try {
            mailSender.send("abidinislak@gmail.com", "A test mail", "Body of the test mail");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "mail send";
    }
}
