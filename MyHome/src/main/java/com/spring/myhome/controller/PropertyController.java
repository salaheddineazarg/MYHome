package com.spring.myhome.controller;

import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.dto.PropertyOperation.PropertyOperationDto;
import com.spring.myhome.service.interfaces.IProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/property")
public class PropertyController extends GenericControllerImpl<PropertyDtoResponse, PropertyDto, IProperty>{

    private  final IProperty service;
    public PropertyController(IProperty service){
        super(service);
        this.service=service;

    }


    @Override
    public ResponseEntity<PropertyDtoResponse> create(PropertyDto propertyDto) {
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<OperationDtoResponse> create(@RequestBody PropertyOperationDto propertyOperationDto) {
        return service.saveService(propertyOperationDto)
                .map(user->new ResponseEntity<>(user, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }
}

