package intra.poleemploi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="content")
public class Content implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contentName;
    private boolean published;
    private String description;
    @Column(name="NbLectures")
    private int nbLectures;
    @Column(name="NbAffichages")
    private int nbAffichages;
    private String icone;
    private String contentURL;
    private Date debut;
    private Date fin;
    @ManyToOne
    @JoinColumn(name = "id_appli", nullable = false)
    private Appli appli;
}
