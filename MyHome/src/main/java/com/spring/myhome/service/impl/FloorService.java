package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Floor.FloorDtoResponse;
import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.entities.Floor;
import com.spring.myhome.entities.Piece;
import com.spring.myhome.entities.Property;
import com.spring.myhome.repository.FloorRepository;
import com.spring.myhome.repository.PropertyRepository;
import com.spring.myhome.service.interfaces.IFloor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class FloorService extends GenericServiceImpl<FloorDtoResponse,FloorDto,Floor,FloorRepository>

        implements IFloor {

    private final ModelMapper modelMapper;
    private final PropertyRepository propertyRepository;
    private final FloorRepository floorRepository;

    private final PieceService pieceService;


    public FloorService(FloorRepository floorRepository,
                        ModelMapper modelMapper,
                        PropertyRepository propertyRepository,
                        PieceService pieceService){
        super(floorRepository);
        this.modelMapper = modelMapper;
        this.floorRepository=floorRepository;
        this.propertyRepository=propertyRepository;
        this.pieceService=pieceService;

    }


    @Override
    public Optional<FloorDtoResponse> saveService(FloorDto floorDto) {
        return super.saveService(floorDto);
    }






    public List<Floor> saveFloorService(UUID propertyId, List<FloorDto> floorDtoList) {
        List<Floor> savedFloors = new ArrayList<>();

        for (FloorDto floorDto : floorDtoList) {
            Floor floor = convertRequestToEntity(floorDto);
            Property property = propertyRepository.findById(propertyId)
                    .orElseThrow(() -> new IllegalArgumentException("Property not found for id: " + propertyId));

            if (property.getFloorNbr() > floorRepository.countFloorByPropertyId(propertyId)) {
                floor.setProperty(property);
                Floor savedFloor = floorRepository.save(floor);

                List<PieceDto> pieceDtos = floorDto.getPieces();
                List<Piece> pieces = pieceService.savePieceService(pieceDtos, savedFloor.getId());

                savedFloor.setPieces(pieces);
                savedFloors.add(savedFloor);
            }
        }

        return savedFloors;
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
