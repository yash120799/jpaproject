package com.example.jpaproject.repository;

import com.example.jpaproject.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity,Long> {
}
