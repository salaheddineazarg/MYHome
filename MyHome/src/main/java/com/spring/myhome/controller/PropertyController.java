package com.spring.myhome.controller;

import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.service.interfaces.IProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/property")
public class PropertyController extends GenericControllerImpl<PropertyDtoResponse, PropertyDto, IProperty>{

    public PropertyController(IProperty service){
        super(service);
    }
}
