package com.spring.myhome.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Floor {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Piece number cannot be null")
    @PositiveOrZero(message = "Piece number must be a positive integer or zero")
    private Integer pieceNbr;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive value")
    private Double area;

    @ManyToOne
    private Property property;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Piece> pieces;
}
