package com.spring.myhome.dto.Property;


import com.spring.myhome.costumeValidation.ValidType;
import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Photo.PhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDtoResponse {

    private UUID id;
    private String description;
    @ValidType
    private String category;
    private Double area;
    private Integer floorNbr;

    private String country;

    private String city;

    private String address;

    private List<FloorDto> floors;


    private List<OperationDto> operations;


    private List<PhotoDto> photos;
}
