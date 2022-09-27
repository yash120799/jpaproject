package com.example.jpaproject.service;

import com.example.jpaproject.entity.AddressEntity;
import com.example.jpaproject.entity.PersonEntity;
import com.example.jpaproject.mapper.AddressMapper;
import com.example.jpaproject.mapper.PersonMapper;
import com.example.jpaproject.model.Address;
import com.example.jpaproject.model.Person;
import com.example.jpaproject.model.PersonResponse;
import com.example.jpaproject.repository.AddressRepo;
import com.example.jpaproject.repository.PersonRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class PersonAddressService {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AddressMapper addressMapper;

    public PersonResponse createPerson(Person person) {

       AddressEntity addressEntity = new AddressEntity();
       addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipcode());
        addressRepo.save(addressEntity);
        addressEntity = addressMapper.addressToEntity(new Address());
        addressRepo.save(addressEntity);

        PersonResponse personResponse = new PersonResponse();

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(addressEntity);
        personRepo.save(personEntity);
       /* personEntity=personMapper.personToEntity(person);
        personRepo.save(personEntity);*/
        personResponse.setId(personEntity.getPersonId());
        return personResponse;

}
       /* public PersonResponse createPerson(Person person) {

            AddressEntity addressEntity;
            addressEntity = addressMapper.addressToEntity(person.getAddress());

            PersonEntity personEntity;
            personEntity = personMapper.personToEntity(person);
            personEntity.setAddress(addressEntity);
            personRepo.save(personEntity);

            PersonResponse personResponse = new PersonResponse();
            personResponse.setId(personEntity.getPersonId());
            return personResponse;

        }
*/
    public Person getPerson(Long id) {


        Optional<PersonEntity> personEntityOptional = personRepo.findById(id);
        Person person = new Person();
        Address address=new Address();
        if (personEntityOptional.isPresent()) {
            AddressEntity addressEntity = personEntityOptional.get().getAddress();
            PersonEntity personEntity = personEntityOptional.get();
            person=personMapper.entityToPerson(personEntity);
            address = addressMapper.entityToAddress(addressEntity);
            person.setAddress(address);


        } else {
            log.info("Person id" + id + "Not found");
        }

        return person;

    }

    public void updatePerson(Long id, Person person) {
        PersonEntity personEntity=personRepo.findById(id).get();
        AddressEntity addressEntity=addressRepo.findById(personEntity.getAddress().getId()).get();

        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipcode());
        addressRepo.save(addressEntity);

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personRepo.save(personEntity);
    }

    public void deletePerson(Long id){

        personRepo.deleteById(id);
    }


}
