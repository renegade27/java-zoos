package local.naught.zoos.service;

import local.naught.zoos.model.Zoo;
import local.naught.zoos.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
