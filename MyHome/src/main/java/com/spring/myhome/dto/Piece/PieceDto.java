package com.spring.myhome.dto.Piece;


import com.spring.myhome.enumeration.TypePiece;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PieceDto {

    private UUID id;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive number")
    private Double area;

    @NotNull(message = "Type of piece cannot be null")
    @Enumerated(EnumType.STRING)
    private TypePiece typePiece;

    private UUID floor_id;

}
