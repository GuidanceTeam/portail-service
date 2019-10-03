package intra.poleemploi.web;

import intra.poleemploi.dao.CoachedAppliRepository;
import intra.poleemploi.entities.CoachedAppli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoachedAppliController {
    @Autowired
    private CoachedAppliRepository coachedAppliRepository;

    @GetMapping(value = "/applis")
    public List<CoachedAppli> listCoachedApplis(){
        return coachedAppliRepository.findAll();
    }

    @GetMapping(value = "/applis/{id}")
    public CoachedAppli coachedAppliById(@PathVariable(name = "id") Integer id){
        return coachedAppliRepository.findById(id).get();
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
