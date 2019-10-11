
package intra.poleemploi.web;

import intra.poleemploi.dao.CoachedAppliRepository;
import intra.poleemploi.entities.CoachedAppli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoachedAppliController {
    @Autowired
    private CoachedAppliRepository coachedAppliRepository;

    @GetMapping(value = "/applis")
    public List<CoachedAppli> listCoachedApplis(){
        return coachedAppliRepository.findAll();
    }

    @GetMapping(value = "/applis/{id}")
    public ResponseEntity<CoachedAppli> getCoachedAppliById(@PathVariable(value = "id") Integer idAppli) throws ResourceNotFoundException {
        CoachedAppli coachedAppli = coachedAppliRepository.findById(idAppli)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found for this id :: " + idAppli));
        return ResponseEntity.ok().body(coachedAppli);
    }

    @PutMapping(value = "/applis/{id}")
    public CoachedAppli updateCoachedAppli(@PathVariable(name = "id") Integer id, @RequestBody CoachedAppli ca) {
        ca.setId(id);
        return coachedAppliRepository.save(ca);
    }

    @PostMapping(value = "/applis")
    public CoachedAppli saveCoachedAppli(@RequestBody CoachedAppli ca){
        return coachedAppliRepository.save(ca);
    }

    @DeleteMapping(value = "/applis/{id}")
    public void deleteCoachedAppli(@PathVariable(name="id") Integer id){
        coachedAppliRepository.deleteById(id);
    }
}

