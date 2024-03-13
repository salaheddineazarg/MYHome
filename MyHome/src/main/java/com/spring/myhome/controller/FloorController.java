package com.spring.myhome.controller;

import com.spring.myhome.dto.Floor.FloorDto;
import com.spring.myhome.dto.Floor.FloorDtoResponse;
import com.spring.myhome.service.interfaces.IFloor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/floor")
public class FloorController extends GenericControllerImpl<FloorDtoResponse, FloorDto,IFloor>{


    public FloorController(IFloor service){
        super(service);
    }
}
