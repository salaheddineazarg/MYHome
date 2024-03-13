package com.spring.myhome.repository;

import com.spring.myhome.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {


}
