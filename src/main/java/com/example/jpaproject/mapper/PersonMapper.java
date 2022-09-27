package com.example.jpaproject.mapper;

import com.example.jpaproject.entity.PersonEntity;
import com.example.jpaproject.model.Person;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface PersonMapper {
     PersonEntity personToEntity(Person person);
     Person entityToPerson(PersonEntity personEntity );
}
