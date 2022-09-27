package com.example.jpaproject.controller;
import com.example.jpaproject.model.Person;
import com.example.jpaproject.model.PersonResponse;
import com.example.jpaproject.service.PersonAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
public class PersonController {
    @Autowired
    private PersonAddressService personAddressService;

    @PostMapping(path = "/persons",  produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse>createPerson(@RequestBody Person person) {
        PersonResponse createResponse = personAddressService.createPerson(person);
        return new ResponseEntity<>(createResponse, HttpStatus.OK);
    }
    @GetMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Person>getPerson(@PathVariable Long id){
    Person getPerson=personAddressService.getPerson(id);
    return new ResponseEntity<>(getPerson,HttpStatus.OK);
    }
    @PutMapping(path = "/persons/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updatePerson(@PathVariable Long id , @RequestBody Person person){
         personAddressService.updatePerson(id,person);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/persons/{id}")
    public ResponseEntity<Void>deletePerson(@PathVariable Long id){
        personAddressService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}