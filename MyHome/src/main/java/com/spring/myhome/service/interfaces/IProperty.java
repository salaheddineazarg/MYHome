package com.spring.myhome.service.interfaces;



import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.dto.PropertyOperation.PropertyOperationDto;
import com.spring.myhome.dto.PropertyOperation.PropertyOperationDtoResponse;

import java.util.Optional;
import java.util.UUID;

public interface IProperty extends IData<PropertyDtoResponse, PropertyDto, UUID> {


    @Override
    Optional<PropertyDtoResponse> saveService(PropertyDto propertyDto);
    Optional<OperationDtoResponse> saveService(PropertyOperationDto propertyOperationDto);



}
