package com.spring.myhome.dto.Floor;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorDto {
    private UUID id;
    @NotNull(message = "Piece number cannot be null")
    @PositiveOrZero(message = "Piece number must be a positive number or zero")
    private Integer pieceNbr;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive number")
    private Double area;

    @NotNull(message = "Property ID cannot be null")
    @Positive(message = "Property ID must be a positive number")
    private UUID property_id;
}
