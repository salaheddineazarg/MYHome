package com.spring.myhome.repository;

import com.spring.myhome.entities.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FloorRepository extends JpaRepository<Floor, UUID> {

    Long countFloorByPropertyId(UUID id);
}
