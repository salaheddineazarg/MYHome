package com.spring.myhome.service.interfaces;

import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Operation.OperationDtoResponse;

import java.util.UUID;

public interface IOperation extends IData<OperationDtoResponse, OperationDto, UUID>{
}
