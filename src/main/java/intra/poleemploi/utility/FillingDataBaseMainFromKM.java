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

import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication(scanBasePackages={"intra.poleemploi"})
public class FillingDataBaseMainFromKM {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private UserAppRepository userAppRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FillingDataBaseMainFromKM.class, args);
        ctx.close();
    }

    @Bean
    CommandLineRunner startFillingDataBaseKM(AppliRepository appliRepository, ContentRepository contentRepository, StatistiquesParJourRepository statistiquesParJourRepository, AuthService authService, UserAppRepository userAppRepository, RoleAppRepository roleAppRepository) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Appli.class, Content.class, StatistiquesParJour.class, UserApp.class, RoleApp.class);
            //Table User
            userAppRepository.deleteAll();
            //Table role
            roleAppRepository.deleteAll();
            //Table Appli filling
            appliRepository.deleteAll();

            authService.delAllAppToAllUser();
            List<Appli> listAppli;
            LoginKnowMore loginKnowMore = new LoginKnowMore();

            listAppli = loginKnowMore.post();                             //readHtmlTable.getAppliList();
            for (Appli tempAppli : listAppli) {
                appliRepository.save(tempAppli);
            }
            appliRepository.findAll().forEach(System.out::println);

            // Table Content filling
            contentRepository.deleteAll();
            List<Content> listContent;

          //  listContent = readHtmlTable.getContentList(appliRepository.findAll());
            listContent = loginKnowMore.get();

            for (Content tempContent : listContent) {
                contentRepository.save(tempContent);
            }
            contentRepository.findAll().forEach(System.out::println);

//            // Table statistique par jour filling
//            statistiquesParJourRepository.deleteAll();
//            List<StatistiquesParJour> listStatistiquesParJour = new ArrayList<>();
//            listStatistiquesParJour = readHtmlTable.getStatistiquesParJourList(contentRepository.findAll());
//            for (StatistiquesParJour tempStempStatistiquesParJour : listStatistiquesParJour) {
//                statistiquesParJourRepository.save(tempStempStatistiquesParJour);
//            }
            statistiquesParJourRepository.findAll().forEach(System.out::println);

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

