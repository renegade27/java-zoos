package local.naught.zoos.controller;

import local.naught.zoos.model.Zoo;
import local.naught.zoos.service.AnimalService;
import local.naught.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PutMapping(value = "/admin/zoos/{zooid}")
    public ResponseEntity<?> updateZoo(@Valid @RequestBody Zoo z, @PathVariable long zooid) {
        return new ResponseEntity<>(zooService.update(z, zooid), HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/zoos/{zooid}")
    public ResponseEntity<?> deleteZoo(@PathVariable long zooid) {
        zooService.deleteByZooid(zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/admin/zoos")
    public ResponseEntity<?> newZoo(@Valid @RequestBody Zoo newZoo) {
        newZoo = zooService.save(newZoo);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
