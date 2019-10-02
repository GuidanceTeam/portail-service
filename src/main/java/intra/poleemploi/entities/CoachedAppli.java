package intra.poleemploi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name="coachedAppli")
public class CoachedAppli implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idCoachedAppli;
    @Column(unique = true)
    private String appliName;
    @ManyToMany(fetch = FetchType.EAGER)
    //@OneToMany (cascade = CascadeType.ALL, mappedBy = "coachedAppli", orphanRemoval = true)
    private Collection<ContentAppli> contents = new ArrayList<>();

    @Override
    public String toString() {
        return "CoachedAppli{" +
                "id=" + id +
                ", idCoachedAppli='" + idCoachedAppli + '\'' +
                ", appliName='" + appliName + '\'' +
                '}';
    }
}
