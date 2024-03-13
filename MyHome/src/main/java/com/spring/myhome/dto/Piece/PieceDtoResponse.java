package com.spring.myhome.dto.Piece;



import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.enumeration.TypePiece;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PieceDtoResponse {

    private UUID id;
    private Double area;
    private TypePiece typePiece;
    private FloorDto floor;
}
