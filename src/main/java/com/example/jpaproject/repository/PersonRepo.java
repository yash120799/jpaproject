package com.example.jpaproject.repository;
import com.example.jpaproject.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity,Long> {

}
