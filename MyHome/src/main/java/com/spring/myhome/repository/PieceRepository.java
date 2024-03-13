package com.spring.myhome.repository;

import com.spring.myhome.entities.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PieceRepository extends JpaRepository<Piece, UUID> {

    Long countPieceByFloorId(UUID id);
}
