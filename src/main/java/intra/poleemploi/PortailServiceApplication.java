package intra.poleemploi;

import intra.poleemploi.dao.CoachedAppliRepository;
import intra.poleemploi.dao.ContentAppliRepository;
import intra.poleemploi.entities.CoachedAppli;
import intra.poleemploi.entities.ContentAppli;
import intra.poleemploi.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class PortailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortailServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CoachedAppliRepository coachedAppliRepository, ContentAppliRepository contentAppliRepository){
		return args -> {

			// supprime les données coachedAppli avant chaque lancement de l'appli
			coachedAppliRepository.deleteAll();
			// save les données coachedAppli en BDD
			coachedAppliRepository.save(new CoachedAppli(1, "APP01", "Profil de compétences", new HashSet<>()));
			coachedAppliRepository.save(new CoachedAppli(2, "APP02", "MRS Digitale", new HashSet<>()));
			coachedAppliRepository.save(new CoachedAppli(3, "APP03", "MAP DE", new HashSet<>()));
			// parcourt et affiche les données
			coachedAppliRepository.findAll().forEach(System.out::println);
			// supprime les données contentAppli avant chaque lancement de l'appli
			contentAppliRepository.deleteAll();
			// récupère coachedAppli app01 et app02
			CoachedAppli app01 = coachedAppliRepository.findById(1).get();
			CoachedAppli app02 = coachedAppliRepository.findById(2).get();
			// save les données contentAppli en BDD
			ContentAppli c1 = contentAppliRepository.save(new ContentAppli(null, "c1", "Pastille", app01));
			ContentAppli c2 = contentAppliRepository.save(new ContentAppli(null, "c2", "Info Bulle", app01));
			// ajout des content c1 & c2 à app01 et c2 à app02
			app01.getContents().add(c1);
			app01.getContents().add(c2);
			app02.getContents().add(c2);
			// met à jour app01 & app02
			coachedAppliRepository.save(app01);
			coachedAppliRepository.save(app02);
			// parcourt et affiche les contents
			contentAppliRepository.findAll().forEach(cnt -> {
				System.out.println(cnt.toString());
			});


			// ajout 3 contentAppli
			//CoachedAppli ca1 = coachedAppliRepository.findCoachedAppliByAppliName("Profil de compétences");
			//CoachedAppli ca2 = coachedAppliRepository.findCoachedAppliByAppliName("MRS Digitale");
			//CoachedAppli ca1 = new CoachedAppli(null, "Profil de compétences", new ArrayList<>());
			//CoachedAppli ca2 = new CoachedAppli(null, "MRS Digitale", new ArrayList<>());


//			appService.saveContentAppli(new ContentAppli(null, "c1", "Pastille"));
//			appService.saveContentAppli(new ContentAppli(null, "c2", "Info Bulle"));
//			appService.saveContentAppli(new ContentAppli(null, "c3", "Video"));

			// ajout appli coachées
//			Stream.of("Profil de compétences", "MRS Digitale", "MAP DE").forEach(ca -> {
//				appService.saveCoachedAppli(ca);
//			});

			// ajout du content à coachedAppli
//			appService.addContentToAppli("Profil de compétences", "Video");
//			appService.addContentToAppli("Profil de compétences", "Pastille");
//			appService.addContentToAppli("MRS Digitale", "Video");
//			appService.addContentToAppli("MRS Digitale", "Pastille");
//			appService.addContentToAppli("MAP DE", "Info Bulle");
//
//			appService.findAllCoachedAppli().forEach(coachedAppli -> {
//				System.out.println(coachedAppli.toString());
//			});

		};
	}

}

