package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Floor.FloorDtoResponse;
import com.spring.myhome.entities.Floor;
import com.spring.myhome.entities.Property;
import com.spring.myhome.repository.FloorRepository;
import com.spring.myhome.repository.PropertyRepository;
import com.spring.myhome.service.interfaces.IFloor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FloorService extends GenericServiceImpl<FloorDtoResponse,FloorDto,Floor,FloorRepository>

        implements IFloor {

    private final ModelMapper modelMapper;
    private final PropertyRepository propertyRepository;

    private final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository,
                        ModelMapper modelMapper,
                        PropertyRepository propertyRepository){
        super(floorRepository);
        this.modelMapper = modelMapper;
        this.floorRepository=floorRepository;
        this.propertyRepository=propertyRepository;

    }



    @Override
    public Optional<FloorDtoResponse> saveService(FloorDto floorDto) {
         Floor floor = convertRequestToEntity(floorDto);
        Property property = propertyRepository.findById(floorDto.getProperty_id()).get();
        if (property.getFloorNbr() > floorRepository.countFloorByPropertyId(floorDto.getProperty_id())){

            floor = floorRepository.save(floor);

            return Optional.of(convertEntityToResponse(floor));
        }

        return Optional.empty();
    }

    @Override
    protected Floor convertRequestToEntity(FloorDto floorDto) {
        return modelMapper.map(floorDto,Floor.class);
    }

    @Override
    protected FloorDtoResponse convertEntityToResponse(Floor floor) {
        return modelMapper.map(floor, FloorDtoResponse.class);
    }
}
