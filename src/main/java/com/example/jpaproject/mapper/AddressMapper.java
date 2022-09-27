package com.example.jpaproject.mapper;

import com.example.jpaproject.entity.AddressEntity;
import com.example.jpaproject.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity addressToEntity(Address address);
    Address entityToAddress(AddressEntity addressEntity);
}
