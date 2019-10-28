package intra.poleemploi.web;

import intra.poleemploi.dao.UserAppRepository;
import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.RoleApp;
import intra.poleemploi.entities.UserApp;
import intra.poleemploi.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserAppRepository userAppRepository;

    @PostMapping("/adminUsers")
    public UserApp register(@RequestBody UserForm userForm){ // données envoyées au format JSON
        return authService.saveUserApp(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
    }

    @PutMapping("/updateUserRoles/{id}")
    public ResponseEntity<UserApp> updateUserRoles(@PathVariable(value="id") Long id, @RequestBody List<RoleApp> roles) throws ResourceNotFoundException {
        UserApp userBdd = userAppRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userBdd.setRoles(roles);
        ResponseEntity<UserApp> response = ResponseEntity.ok(authService.saveUserApp(userBdd));
        return response ;
    }

    @PutMapping("/updateUserApplis/{id}")
    public ResponseEntity<UserApp> updateUserApplis(@PathVariable(value="id") Long id, @RequestBody Set<Appli> applis) throws ResourceNotFoundException {
        UserApp userBdd = userAppRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userBdd.setApplis(applis);
        ResponseEntity<UserApp> response = ResponseEntity.ok(authService.saveUserApp(userBdd));
        return response ;
    }

    @GetMapping(value = "/adminUsers/{username}")
    public UserApp userAppByUsername(@PathVariable(name="username") String username){
        return userAppRepository.findUserByUsername(username);
    };
}
@Data
class UserForm {
    private String username;
    private String password;
    private String confirmedPassword;
}
