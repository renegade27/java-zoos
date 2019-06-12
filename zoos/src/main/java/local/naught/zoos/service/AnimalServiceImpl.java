package local.naught.zoos.service;


import local.naught.zoos.repos.AnimalRepository;
import local.naught.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value="animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository restrepos;

    @Override
    public ArrayList<AnimalCount> getAnimalCount() {
        return restrepos.getAnimalCount();
    }
}
