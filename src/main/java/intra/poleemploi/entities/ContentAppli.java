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
@Table(name="contentAppli")
public class ContentAppli implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idContent;
    private String contentName;
    //private boolean published;
    //private String description;
    //private int nbLectures;
    //private int nbUsers;
    //private double displayDuration;
    //private Date date;
    //@ManyToOne(fetch = FetchType.LAZY)//(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "coachedAppli_id")
    private CoachedAppli coachedAppli;


}
