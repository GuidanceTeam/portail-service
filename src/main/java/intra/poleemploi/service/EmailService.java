package intra.poleemploi.service;

import intra.poleemploi.entities.FeedbackEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    /*private JavaMailSender javaMailSender;

    @Autowired
    public  EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(FeedbackEmail feedbackEmail) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + feedbackEmail.getName()).append(System.lineSeparator());
        sb.append("\n Message: " + feedbackEmail.getTextMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("sandrine.rodriguez@hotmail.com");
        mail.setFrom(feedbackEmail.getEmail());
        mail.setSubject(feedbackEmail.getTextMessage());
        mail.setText(sb.toString());
        javaMailSender.send(mail);
    }*/
}
