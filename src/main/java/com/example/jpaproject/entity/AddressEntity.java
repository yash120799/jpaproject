package com.example.jpaproject.entity;

import com.example.jpaproject.model.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="address")
public class AddressEntity {
    @Id
    @SequenceGenerator(name = "seq_address_id",initialValue = 1 ,sequenceName = "seq_address_id", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address_id")
    private Long id;

    private String  address1;

    private String address2;

    private String city;

    private String state;
    @Column(name="zip_code")
    private Long zipCode;
    @OneToOne(mappedBy = "address" )
    private PersonEntity person;


}
