package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Photo.PhotoDto;
import com.spring.myhome.dto.Photo.PhotoDtoResponse;
import com.spring.myhome.repository.PhotoRepository;
import com.spring.myhome.service.interfaces.IPhoto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PhotoService implements IPhoto {



    private final PhotoRepository photoRepository;


    public PhotoService(PhotoRepository photoRepository){
        this.photoRepository =photoRepository;

    }


    @Override
    public List<PhotoDtoResponse> getAllService() {
        return null;
    }

    @Override
    public Optional<PhotoDtoResponse> saveService(PhotoDto photoDto) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteService(UUID id) {
        return null;
    }

    @Override
    public Optional<PhotoDtoResponse> updateService(PhotoDto photoDto, UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<PhotoDtoResponse> findByIdService(UUID id) {
        return Optional.empty();
    }
}
