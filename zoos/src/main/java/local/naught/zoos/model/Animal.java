package local.naught.zoos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @ManyToMany
    @JoinTable(name="zooanimals", joinColumns = {@JoinColumn(name="animalid")},
                                  inverseJoinColumns = {@JoinColumn(name="zooid")})
    @JsonIgnore
    private List<Zoo> zoos = new ArrayList<>();

    public Animal() {
    }

    public Animal(String animaltype) {
        this.animaltype = animaltype;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public List<Zoo> getZoos() {
        return zoos;
    }

    public void setZoos(List<Zoo> zoos) {
        this.zoos = zoos;
    }
}
