package com.spring.myhome.service.impl;

import com.spring.myhome.dto.User.UserDto;
import com.spring.myhome.dto.User.UserDtoResponse;
import com.spring.myhome.entities.User;
import com.spring.myhome.repository.UserRepository;
import com.spring.myhome.service.interfaces.IUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService extends GenericServiceImpl<UserDtoResponse,UserDto,User,UserRepository>

        implements IUser {
    private final ModelMapper modelMapper;



    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper){
       super(userRepository);
        this.modelMapper =modelMapper;
    }

    @Override
    protected User convertRequestToEntity(UserDto userDto) {
        return  modelMapper.map(userDto,User.class);
    }

    @Override
    protected UserDtoResponse convertEntityToResponse(User user) {
        return modelMapper.map(user,UserDtoResponse.class);
    }
}
