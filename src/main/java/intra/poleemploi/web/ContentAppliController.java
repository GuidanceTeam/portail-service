package intra.poleemploi.web;

import intra.poleemploi.dao.ContentAppliRepository;
import intra.poleemploi.entities.ContentAppli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContentAppliController {
    @Autowired
    private ContentAppliRepository contentAppliRepository;

    @GetMapping(value = "/contents")
    public List<ContentAppli> listContentApplis(){
        return contentAppliRepository.findAll();
    }

    @GetMapping(value = "/contents/{id}")
    public ContentAppli contentAppliById(@PathVariable(name = "id") Integer id){
        return contentAppliRepository.findById(id).get();
    }

    @PutMapping(value = "/contents/{id}")
    public ContentAppli updateContentAppli(@PathVariable(name = "id") Integer id, @RequestBody ContentAppli cnt) {
        cnt.setId(id);
        return contentAppliRepository.save(cnt);
    }

    @PostMapping(value = "/contents")
    public ContentAppli saveContentAppli(@RequestBody ContentAppli cnt){
        return contentAppliRepository.save(cnt);
    }

    @DeleteMapping(value = "/contents/{id}")
    public void deleteContentAppli(@PathVariable(name="id") Integer id){
        contentAppliRepository.deleteById(id);
    }
}
