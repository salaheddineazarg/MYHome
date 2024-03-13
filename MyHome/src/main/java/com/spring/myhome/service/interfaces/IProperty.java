package com.spring.myhome.service.interfaces;

import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;

import java.util.UUID;

public interface IProperty extends IData<PropertyDtoResponse, PropertyDto, UUID> {
}
