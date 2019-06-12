package local.naught.zoos.controller;

import local.naught.zoos.model.Zoo;
import local.naught.zoos.service.AnimalService;
import local.naught.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/")
public class ZooController {

    @Autowired
    private ZooService zooService;

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/zoos/zoos")
    public ResponseEntity<?> getAllZoos() {
        ArrayList<Zoo> list = zooService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/animals/count")
    public ResponseEntity<?> getAnimalCount() {
        return new ResponseEntity<>(animalService.getAnimalCount(), HttpStatus.OK);
    }
}
