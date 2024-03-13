package com.spring.myhome.controller;

import com.spring.myhome.dto.User.UserDto;
import com.spring.myhome.dto.User.UserDtoResponse;
import com.spring.myhome.service.interfaces.IUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/user")
public class UserController extends GenericControllerImpl<UserDtoResponse,UserDto,IUser>{

    public UserController(IUser service){

        super(service);
    }
}
