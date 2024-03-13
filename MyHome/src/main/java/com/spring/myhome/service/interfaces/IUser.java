package com.spring.myhome.service.interfaces;

import com.spring.myhome.dto.User.UserDto;
import com.spring.myhome.dto.User.UserDtoResponse;

import java.util.UUID;

public interface IUser extends IData<UserDtoResponse, UserDto, UUID>{
}
