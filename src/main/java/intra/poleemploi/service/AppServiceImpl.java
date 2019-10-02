package intra.poleemploi.service;

import intra.poleemploi.dao.CoachedAppliRepository;
import intra.poleemploi.dao.ContentAppliRepository;
import intra.poleemploi.entities.CoachedAppli;
import intra.poleemploi.entities.ContentAppli;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Service
//@Transactional
//public class AppServiceImpl implements AppService {
    // interfaces DAO
//    private CoachedAppliRepository coachedAppliRepository;
//    private ContentAppliRepository contentAppliRepository;

    // Injection des dépendances
//    public AppServiceImpl(CoachedAppliRepository coachedAppliRepository, ContentAppliRepository contentAppliRepository) {
//        this.coachedAppliRepository = coachedAppliRepository;
//        this.contentAppliRepository = contentAppliRepository;
//    }
//
//    @Override
//    public CoachedAppli saveCoachedAppli(String appliName) {
//        CoachedAppli appli = coachedAppliRepository.findCoachedAppliByAppliName(appliName);
//        if(appli != null) throw new RuntimeException("coachedAppli already exist !!!");
//        CoachedAppli coachedAppli = new CoachedAppli();
//        coachedAppli.setAppliName(appliName);
//
//        coachedAppliRepository.save(coachedAppli);
//        //addContentToAppli(appliName, "Pastille");
//        return coachedAppli;
//    }

//    @Override
//    public ContentAppli saveContentAppli(ContentAppli contentAppli) {
//        return contentAppliRepository.save(contentAppli);
//    }
//
//    @Override
//    public void addContentToAppli(String appliName, String contentName) {
//        CoachedAppli coachedAppli = coachedAppliRepository.findCoachedAppliByAppliName(appliName);
//        ContentAppli contentAppli = contentAppliRepository.findContentAppliByContentName(contentName);
//        coachedAppli.getContents().add(contentAppli);
//    }
//
//    @Override
//    public List<CoachedAppli> findAllCoachedAppli() {
//        return coachedAppliRepository.findAll();
//    }

//    @Override
//    public CoachedAppli findCoachedAppliById(int id) {
//        return null;
//    }

//    @Override
//    public void deleteCoachedAppli() {
//        coachedAppliRepository.deleteAll();
//    }

//    @Override
//    @GetMapping(value="/listApplis")
//    public List<CoachedAppli> getListCoachedAppli() {
//        return coachedAppliRepository.findAll();
//    }

//}
