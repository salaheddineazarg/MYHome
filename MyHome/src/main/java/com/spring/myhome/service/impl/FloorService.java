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


    //@Transactional
    public List<Floor> saveFloorService(List<FloorDto> floorDtoList) {
        List<Floor> savedFloors = new ArrayList<>();


        System.out.println(floorDtoList);
        for (FloorDto floorDto : floorDtoList) {
            Floor floor = convertRequestToEntity(floorDto);
            Property property = propertyRepository.findById(floorDto.getProperty_id()).orElse(null);
            if (property != null && property.getFloorNbr() > floorRepository.countFloorByPropertyId(floorDto.getProperty_id())) {
                Floor savedFloor = floorRepository.save(floor);
                for (PieceDto pieceDto:floorDto.getPieces()){
                    pieceDto.setFloor_id(savedFloor.getId());
                }

              List<Piece> pieces =  pieceService.savePieceService(floorDto.getPieces());
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
