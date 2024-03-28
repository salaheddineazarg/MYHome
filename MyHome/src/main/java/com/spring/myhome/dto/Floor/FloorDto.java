package com.spring.myhome.dto.Floor;


import com.spring.myhome.dto.Piece.PieceDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

  //  @Positive(message = "Property ID must be a positive number")
    private UUID property_id;

    private List<PieceDto> pieces;
}
