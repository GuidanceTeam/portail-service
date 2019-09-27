package intra.poleemploi.dao;

import intra.poleemploi.entities.ContentAppli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContentAppliRepository extends JpaRepository<ContentAppli, String> {
    public ContentAppli findContentAppliByContentName(String contentName);
}
