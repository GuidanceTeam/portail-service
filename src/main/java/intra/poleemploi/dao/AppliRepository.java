package intra.poleemploi.dao;

import intra.poleemploi.entities.Appli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppliRepository extends JpaRepository<Appli, Integer> {
    //public Appli findAppliByAppliName(String appliName);

}
