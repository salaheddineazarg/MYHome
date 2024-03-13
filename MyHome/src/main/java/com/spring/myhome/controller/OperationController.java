package com.spring.myhome.controller;


import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.service.interfaces.IOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/operation")
public class OperationController extends GenericControllerImpl<OperationDtoResponse, OperationDto,IOperation> {


    public OperationController(IOperation service){
        super(service);
    }
}
