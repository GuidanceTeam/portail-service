package intra.poleemploi.utility;


import intra.poleemploi.dao.*;
import intra.poleemploi.entities.*;
import intra.poleemploi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication(scanBasePackages={"intra.poleemploi"})
public class FillingDataBaseMainDemo {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private UserAppRepository userAppRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FillingDataBaseMainDemo.class, args);
        ctx.close();
    }

    @Bean
    CommandLineRunner startFillingDataBase(AppliRepository appliRepository, ContentRepository contentRepository, AuthService authService, UserAppRepository userAppRepository, RoleAppRepository roleAppRepository) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Appli.class, Content.class, UserApp.class, RoleApp.class);
            //Table User
            userAppRepository.deleteAll();
            //Table role
            roleAppRepository.deleteAll();
            //Table Appli filling
            appliRepository.deleteAll();

            authService.delAllAppToAllUser();
            List<Appli> listAppli;
            ReadExcelDemo readExcel = new ReadExcelDemo();
            listAppli = readExcel.getAppliList();
            for (Appli tempAppli : listAppli) {
                appliRepository.save(tempAppli);
            }
            appliRepository.findAll().forEach(System.out::println);

            // Table Content filling
            contentRepository.deleteAll();
            List<Content> listContent;
            listContent = readExcel.getContentList(appliRepository.findAll());
            for (Content tempContent : listContent) {
                contentRepository.save(tempContent);
            }
            contentRepository.findAll().forEach(System.out::println);

            // AUTHENTICATION
            // ajout de 2 roles
            authService.saveRoleApp(new RoleApp(null, "USER"));
            authService.saveRoleApp(new RoleApp(null, "ADMIN"));

            // ajout users
            Stream.of("user1", "user2", "user3", "user4", "admin").forEach(username -> {
                authService.saveUserApp(username, "1234", "1234");
            });

            // ajout role ADMIN a l'admin
            authService.addRoleToUser("admin", "ADMIN");

            // ajout appli à user
            authService.addAppliToUser("user1", "MAP Vue DE");
            authService.addAppliToUser("user1", "Profil de compétences");
            authService.addAppliToUser("user1", "AUDE Presta");
            authService.addAppliToUser("user2", "MRS Digitale");
            authService.addAppliToUser("user2", "MAP Vue DE");
            authService.addAppliToUser("user3", "Profil de compétences");
            userAppRepository.findAll().forEach(System.out::println);
        };
    }

}

