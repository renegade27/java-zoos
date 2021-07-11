package local.naught.zoos.service;

import local.naught.zoos.model.Zoo;

import java.util.ArrayList;
import java.util.List;

public interface ZooService {
    ArrayList<Zoo> findAll();
    Zoo update(Zoo z, long id);
    Zoo save(Zoo zoo);
    void deleteByZooid(long id);
}
