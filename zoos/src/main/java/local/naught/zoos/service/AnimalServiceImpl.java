package local.naught.zoos.service;


import local.naught.zoos.model.Animal;
import local.naught.zoos.repos.AnimalRepository;
import local.naught.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value="animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository restrepos;

    @Override
    public ArrayList<AnimalCount> getAnimalCount() {
        return restrepos.getAnimalCount();
    }

    @Override
    public Animal update(Animal a, long id) {
        Animal currentAnimal = restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if(a.getAnimaltype() != null) {
            currentAnimal.setAnimaltype(a.getAnimaltype());
        }
        if(a.getZoos().size() > 0) {
            currentAnimal.getZoos().clear();
            currentAnimal.getZoos().addAll(a.getZoos());
        }
        return restrepos.save(currentAnimal);
    }
}
