package local.naught.zoos.repos;

import local.naught.zoos.model.Zoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ZooRepository extends CrudRepository<Zoo, Long> {
}
