package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.entities.Photo;
import com.spring.myhome.entities.Property;
import com.spring.myhome.repository.PhotoRepository;
import com.spring.myhome.repository.PropertyRepository;
import com.spring.myhome.service.interfaces.IProperty;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    private final PhotoRepository photoRepository;


    public PropertyService(PropertyRepository propertyRepository,
                           ModelMapper modelMapper,
                           PhotoRepository photoRepository){
        super(propertyRepository);
        this.modelMapper = modelMapper;
        this.propertyRepository =propertyRepository;
        this.photoRepository =photoRepository;
    }

    @Override
    public Optional<PropertyDtoResponse> saveService(PropertyDto propertyDto) {
        Property property = convertRequestToEntity(propertyDto);

        if(propertyDto.getImage_id().size() > 0){

            List<Photo> photos = Arrays.asList(modelMapper.map(propertyDto.getImage_id(), Photo[].class));
            for(int i=0;i<photos.size();i++){
              Photo photo = photos.get(i);
              photo.setProperty(property);
                photos.set(i,photo);
            }
            property.setPhotos(photos);
        }

        property = propertyRepository.save(property);

        return Optional.ofNullable(convertEntityToResponse(property));
    }

    @Override
    protected Property convertRequestToEntity(PropertyDto propertyDto) {
        return modelMapper.map(propertyDto,Property.class);
    }

    @Override
    protected PropertyDtoResponse convertEntityToResponse(Property property) {
        return modelMapper.map(property, PropertyDtoResponse.class);
    }
}
