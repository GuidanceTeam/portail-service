package intra.poleemploi.dao;

import intra.poleemploi.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findContentByContentName(String contentName);
}
