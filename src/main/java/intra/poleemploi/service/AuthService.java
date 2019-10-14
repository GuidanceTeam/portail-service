package intra.poleemploi.service;

import intra.poleemploi.entities.RoleApp;
import intra.poleemploi.entities.UserApp;

public interface AuthService {
    UserApp saveUserApp(String username, String password, String confirmedPassword);
    void saveRoleApp(RoleApp role);
    UserApp loadUserAppByUsername(String username);
    void addRoleToUser(String username, String roleName);
}
