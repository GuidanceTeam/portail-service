package intra.poleemploi.web;

import intra.poleemploi.entities.Email;
import intra.poleemploi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private EmailService emailService;

    /*@PostMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Email> envoyerEmail(@RequestBody Email email) {
        try {
            emailService.sendEmail(email);
            return new ResponseEntity<>(email, HttpStatus.OK);
        } catch(MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    @PostMapping(path = "/contact", consumes = MediaType.ALL_VALUE)
    public Email envoyerEmail(@RequestParam(required=false, name="subject") String subject,
                               @RequestParam(required=false, name="textMessage") String textMessage,
                               @RequestParam(required=false, name="email") String email,
                               @RequestParam(required=false, name="name") String name){
        Email emailUser = new Email();
        emailUser.setSubject(subject);
        emailUser.setTextMessage(textMessage);
        emailUser.setEmail("sandrine.rodriguez@hotmail.com");
        emailUser.setName(name);

        try {
           emailService.sendEmail(emailUser);

        } catch(MailException e) {

        }
//        return "redirect:/contact";
        return emailUser;
    }
}
