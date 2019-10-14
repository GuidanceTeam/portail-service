package intra.poleemploi;

import intra.poleemploi.dao.AppliRepository;
import intra.poleemploi.dao.ContentRepository;
import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.Content;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Random;


@SpringBootApplication
public class PortailServiceApplication {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(PortailServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AppliRepository appliRepository, ContentRepository contentRepository){
		return args -> {

			// supprime les données coachedAppli avant chaque lancement de l'appli
			appliRepository.deleteAll();
			// save les données coachedAppli en BDD
			appliRepository.save(new Appli(1, "APP01", "Profil de compétences", new ArrayList<>()));
			appliRepository.save(new Appli(2, "APP02", "MRS Digitale", new ArrayList<>()));
			appliRepository.save(new Appli(3, "APP03", "MAP DE", new ArrayList<>()));
			// parcourt et affiche les données
			appliRepository.findAll().forEach(System.out::println);
			// supprime les données contentAppli avant chaque lancement de l'appli
			// contentRepository.deleteAll();

			Random rnd = new Random();
			appliRepository.findAll().forEach(appli -> {
				for (int i = 0; i < 5; i++) {
					Content cnt = new Content();
					cnt.setId(rnd.nextInt());
					cnt.setContentName(RandomString.make(7));
					cnt.setAppli(appli);
					contentRepository.save(cnt);
				}
			});
			contentRepository.findAll().forEach(cnt -> {
				System.out.println(cnt.toString());
			});

		};
	}

}

