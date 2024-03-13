package com.spring.myhome.service.interfaces;

import com.spring.myhome.dto.Message.MessageDto;
import com.spring.myhome.dto.Message.MessageDtoResponse;

import java.util.UUID;

public interface IMessage extends IData<MessageDtoResponse, MessageDto, UUID> {
}
