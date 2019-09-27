package intra.poleemploi.dao;

import intra.poleemploi.entities.CoachedAppli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoachedAppliRepository extends JpaRepository<CoachedAppli, String> {
    public CoachedAppli findCoachedAppliByAppliName(String appliName);
}
