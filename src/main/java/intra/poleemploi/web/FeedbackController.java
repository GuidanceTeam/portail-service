package intra.poleemploi.web;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import intra.poleemploi.entities.EmailConfig;
import intra.poleemploi.entities.FeedbackEmail;
import intra.poleemploi.service.EmailService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

    private EmailConfig emailConfig;

    public FeedbackController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @PostMapping
    public void sendFeedBackEmail(@RequestBody FeedbackEmail feedbackEmail, BindingResult bindingResult) throws MailjetSocketTimeoutException, MailjetException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("FeedbackEmail is not valid");
        }

        // mailjet api
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("2f8d2544d5f6b743c90f4fdccb561208", "eb4d7b4fd8d906f1cdecd55a5ff858b0", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", feedbackEmail.getEmail())
                                        .put("Name", "Me"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "sandrine.rodriguez@hotmail.com")
                                                .put("Name", "You")))
                                .put(Emailv31.Message.SUBJECT, "My first Mailjet Email!")
                                .put(Emailv31.Message.TEXTPART, "Greetings from Mailjet!")
                                .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href=\"https://www.mailjet.com/\">Mailjet</a>!</h3><br />May the delivery force be with you!")));
        response = client.post(request);

        System.out.println(response.getStatus());
        System.out.println(response.getData());

      /*  // créé un expediteur du mail
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        // create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedbackEmail.getEmail()); // mail expediteur
        mailMessage.setTo("sr@feedback.com"); // mail envoyé à destinataire
        mailMessage.setSubject("New feedback from " + feedbackEmail.getName());
        mailMessage.setText(feedbackEmail.getTextMessage());

        // send mail
        mailSender.send(mailMessage);*/
    }



    /*@Autowired
    private EmailService emailService;*/

    /*@PostMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Email> envoyerEmail(@RequestBody Email email) {
        try {
            emailService.sendEmail(email);
            return new ResponseEntity<>(email, HttpStatus.OK);
        } catch(MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    /*@PostMapping(path = "/contact", consumes = MediaType.ALL_VALUE)
    public FeedbackEmail envoyerEmail(@RequestParam(required=false, name="subject") String subject,
                                      @RequestParam(required=false, name="textMessage") String textMessage,
                                      @RequestParam(required=false, name="email") String email,
                                      @RequestParam(required=false, name="name") String name){
        FeedbackEmail emailUser = new FeedbackEmail();
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
    }*/
}
