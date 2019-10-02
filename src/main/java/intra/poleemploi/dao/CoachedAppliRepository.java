package intra.poleemploi.dao;

import intra.poleemploi.entities.CoachedAppli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CoachedAppliRepository extends JpaRepository<CoachedAppli, Integer> {
    //public CoachedAppli findCoachedAppliByAppliName(String appliName);

}
