package intra.poleemploi.service;

import intra.poleemploi.entities.CoachedAppli;
import intra.poleemploi.entities.ContentAppli;

import java.util.ArrayList;
import java.util.List;

public interface AppService {
    // enregistrer une coachedAppli
    //public CoachedAppli saveCoachedAppli(String appliName);

    // enregistrer un content
    //public ContentAppli saveContentAppli(ContentAppli contentAppli);

    // ajouter un content à une coachedAppli
    public void addContentToAppli(String appliName, String contentName);

    // supprimer les données
    //public void deleteCoachedAppli();

    //récupérer liste des coachedAppli
    //public List<CoachedAppli> findAllCoachedAppli();
    // récupérer une coachedAppli par son Id
    //public CoachedAppli findCoachedAppliById(int id);


}
