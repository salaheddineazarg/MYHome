package com.spring.myhome.dto.PropertyOperation;

import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Property.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyOperationDto {

    PropertyDto propertyDto;
    OperationDto operationDto;
    List<FloorDto> floors;
}
