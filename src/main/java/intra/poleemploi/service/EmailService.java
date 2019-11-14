package intra.poleemploi.service;

import intra.poleemploi.entities.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public  EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Email email) throws MailException {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + email.getName()).append(System.lineSeparator());
        sb.append("\n Message: " + email.getTextMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("sandrine.rodriguez@hotmail.com");
        mail.setFrom(email.getEmail());
        mail.setSubject(email.getTextMessage());
        mail.setText(sb.toString());
        javaMailSender.send(mail);
    }
}
