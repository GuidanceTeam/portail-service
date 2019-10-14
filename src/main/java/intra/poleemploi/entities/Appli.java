package intra.poleemploi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name="appli")
public class Appli implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idAppliKM;
    @Column(unique = true)
    private String appliName;
    //@ManyToMany(fetch = FetchType.EAGER)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "appli", orphanRemoval = true)
    private Collection<Content> contents = new ArrayList<>();

    @Override
    public String toString() {
        return "Appli{" +
                "id=" + id +
                ", idAppliKM='" + idAppliKM + '\'' +
                ", appliName='" + appliName + '\'' +
                '}';
    }
}