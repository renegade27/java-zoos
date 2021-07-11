package local.naught.zoos.service;

import local.naught.zoos.model.Animal;
import local.naught.zoos.views.AnimalCount;

import java.util.ArrayList;

public interface AnimalService {
    ArrayList<AnimalCount> getAnimalCount();
    Animal update(Animal a, long id);
}
