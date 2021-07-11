package local.naught.zoos.repos;

import local.naught.zoos.model.Animal;
import local.naught.zoos.views.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(value = "SELECT a.animalid, a.animaltype, count(z.zooid) as zooamount FROM zooanimals z INNER JOIN animal a on z.animalid=a.animalid GROUP BY z.animalid, a.animaltype", nativeQuery = true)
    ArrayList<AnimalCount> getAnimalCount();
}
