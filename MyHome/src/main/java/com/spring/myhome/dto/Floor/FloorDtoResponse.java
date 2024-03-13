package com.spring.myhome.dto.Floor;


import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Property.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorDtoResponse {

    private UUID id;
    private Integer pieceNbr;
    private Double area;

    private PropertyDto property;

    private List<PieceDto> pieces;
}
