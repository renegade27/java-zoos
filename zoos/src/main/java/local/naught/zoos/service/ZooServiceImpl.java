package local.naught.zoos.service;

import local.naught.zoos.model.Zoo;
import local.naught.zoos.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value="zooService")
public class ZooServiceImpl implements ZooService {

    @Autowired
    private ZooRepository restrepos;

    @Override
    public ArrayList<Zoo> findAll() {
        ArrayList<Zoo> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo update(Zoo z, long id) {
        Zoo currentZoo = restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if(z.getZooname() != null) {
            currentZoo.setZooname(z.getZooname());
        }
        if(z.getAnimals().size() > 0) {
            currentZoo.getAnimals().clear();
            currentZoo.getAnimals().addAll(z.getAnimals());
        }
        if(z.getPhones().size() > 0) {
            currentZoo.getPhones().clear();
            currentZoo.getPhones().addAll(z.getPhones());
        }
        return restrepos.save(currentZoo);
    }

    @Override
    public void deleteByZooid(long id) {
        if(restrepos.findById(id).isPresent()) {
            restrepos.deleteById(id);
        } else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();
        newZoo.setZooname(zoo.getZooname());
        newZoo.getAnimals().clear();
        newZoo.getAnimals().addAll(zoo.getAnimals());
        newZoo.getPhones().clear();
        newZoo.getPhones().addAll(zoo.getPhones());
        newZoo.setZooid(zoo.getZooid());
        return restrepos.save(newZoo);
    }
}
