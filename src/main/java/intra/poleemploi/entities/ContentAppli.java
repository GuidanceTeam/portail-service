package intra.poleemploi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ContentAppli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String contentName;
    private boolean published;
    private String description;
    private Long nbLectures;
    private Long nbUsers;
    private double displayDuration;
    private Date date;
}
