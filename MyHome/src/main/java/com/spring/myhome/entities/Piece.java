package com.spring.myhome.entities;

import com.spring.myhome.enumeration.TypePiece;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive value")
    private Double area;

    @NotNull(message = "Type of piece cannot be null")
    @Enumerated(EnumType.STRING)
    private TypePiece typePiece;

    @ManyToOne
  //  @NotNull(message = "Floor cannot be null")
    private Floor floor;

}
