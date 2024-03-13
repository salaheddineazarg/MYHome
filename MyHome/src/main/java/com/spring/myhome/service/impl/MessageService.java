package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Message.MessageDto;
import com.spring.myhome.dto.Message.MessageDtoResponse;
import com.spring.myhome.entities.Message;
import com.spring.myhome.repository.MessageRepository;
import com.spring.myhome.service.interfaces.IMessage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MessageService extends GenericServiceImpl<MessageDtoResponse,MessageDto, Message,MessageRepository>

        implements IMessage {


    private final ModelMapper modelMapper ;


    public MessageService(MessageRepository messageRepository,ModelMapper modelMapper){
        super(messageRepository);
        this.modelMapper=modelMapper;
    }


    @Override
    protected Message convertRequestToEntity(MessageDto messageDto) {
        return modelMapper.map(messageDto,Message.class);
    }

    @Override
    protected MessageDtoResponse convertEntityToResponse(Message message) {
        return modelMapper.map(message,MessageDtoResponse.class);
    }
}
