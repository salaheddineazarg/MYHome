package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.dto.PropertyOperation.PropertyOperationDto;
import com.spring.myhome.dto.PropertyOperation.PropertyOperationDtoResponse;
import com.spring.myhome.entities.*;
import com.spring.myhome.repository.OperationRepository;
import com.spring.myhome.repository.PhotoRepository;
import com.spring.myhome.repository.PropertyRepository;
import com.spring.myhome.repository.UserRepository;
import com.spring.myhome.service.interfaces.IProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyService extends GenericServiceImpl<
        PropertyDtoResponse,
        PropertyDto,
        Property,
        PropertyRepository
        >
        implements IProperty {


    private final ModelMapper modelMapper;
    private final  PropertyRepository propertyRepository;
    private final  OperationRepository operationRepository;
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;
    private final FloorService floorService;



    public PropertyService(PropertyRepository propertyRepository,
                           ModelMapper modelMapper,
                           PhotoRepository photoRepository,
                           OperationRepository operationRepository,
                           UserRepository userRepository,
                           FloorService floorService){
        super(propertyRepository);
        this.modelMapper = modelMapper;
        this.propertyRepository =propertyRepository;
        this.photoRepository =photoRepository;
        this.operationRepository =operationRepository;
        this.userRepository = userRepository;
        this.floorService=floorService;


    }


    @Override
    public Optional<OperationDtoResponse> saveService(PropertyOperationDto propertyOperationDto) {
        PropertyDto propertyDto = propertyOperationDto.getPropertyDto();
        OperationDto operationDto = propertyOperationDto.getOperationDto();
        List<FloorDto> floorDtos = propertyOperationDto.getFloors();

        Property property = convertRequestToEntity(propertyDto);
        property = propertyRepository.save(property);


        if (property == null) {
            return Optional.empty();
        }
        final Property finalProperty = property;
        List<Photo> photos = propertyDto.getPhotos().stream()
                .map(photoDto -> {
                    Photo photo = modelMapper.map(photoDto, Photo.class);
                    photo.setProperty(finalProperty);
                    return photo;
                })
                .collect(Collectors.toList());
        photoRepository.saveAll(photos);

        property.setPhotos(photos);

        if (property.getFloorNbr() > 0 && floorDtos.size() == property.getFloorNbr()) {
            List<Floor> savedFloors = floorService.saveFloorService(property.getId(), floorDtos);
            property.setFloors(savedFloors);
        }

        System.out.println("property:"+property);
        System.exit(10);
        Operation operation = convertRequestToEntity(operationDto);
        operation.setProperty(property);
        operation.setUser(userRepository.findByUserName(operationDto.getUser_name()).orElseThrow());

        operation = operationRepository.save(operation);

        return Optional.ofNullable(convertEntityToResponse(operation));
    }








    @Override
    protected Property convertRequestToEntity(PropertyDto propertyDto) {
        return modelMapper.map(propertyDto,Property.class);
    }

    @Override
    protected PropertyDtoResponse convertEntityToResponse(Property property) {
        return modelMapper.map(property, PropertyDtoResponse.class);
    }


    protected OperationDtoResponse convertEntityToResponse(Operation operation) {
        return modelMapper.map(operation, OperationDtoResponse.class);
    }

    protected Operation convertRequestToEntity(OperationDto operationDto) {
        return modelMapper.map(operationDto,Operation.class);
    }


}
