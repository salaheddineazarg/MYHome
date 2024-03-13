package com.spring.myhome.controller;

import com.spring.myhome.dto.Converstaion.ConversationDto;
import com.spring.myhome.dto.Converstaion.ConversationDtoResponse;
import com.spring.myhome.service.interfaces.IConversation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/conversation")
public class ConversationController extends GenericControllerImpl<ConversationDtoResponse, ConversationDto,IConversation> {


    public ConversationController(IConversation service){
        super(service);
    }
}
