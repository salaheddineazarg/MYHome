package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Converstaion.ConversationDto;
import com.spring.myhome.dto.Converstaion.ConversationDtoResponse;
import com.spring.myhome.entities.Conversation;
import com.spring.myhome.repository.ConversationRepository;
import com.spring.myhome.repository.UserRepository;
import com.spring.myhome.service.interfaces.IConversation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConversationService extends GenericServiceImpl<
        ConversationDtoResponse,
        ConversationDto,
        Conversation,
        ConversationRepository>

        implements IConversation {


     private final ModelMapper modelMapper;
     private final UserRepository userRepository;

     private final ConversationRepository conversationRepository;





    public ConversationService(ConversationRepository conversationRepository,
                               ModelMapper modelMapper,
                               UserRepository userRepository){

        super(conversationRepository);
        this.modelMapper=modelMapper;
        this.conversationRepository = conversationRepository;
        this.userRepository=userRepository;
    }


    @Override
    public Optional<ConversationDtoResponse> saveService(ConversationDto conversationDto) {
        Conversation conversation = convertRequestToEntity(conversationDto);
        if (conversationDto.getUser()!=null){
            conversation.setUser(
                    userRepository.findById(conversationDto.getUser()).get()
            );
        }

        if (conversationDto.getUser2()!=null){
            conversation.setUser2(
                    userRepository.findById(conversationDto.getUser2()).get()
            );
        }

        conversation = conversationRepository.save(conversation);

        return Optional.ofNullable(convertEntityToResponse(conversation));
    }

    @Override
    protected Conversation convertRequestToEntity(ConversationDto conversationDto) {
        return modelMapper.map(conversationDto,Conversation.class);
    }

    @Override
    protected ConversationDtoResponse convertEntityToResponse(Conversation conversation) {
        return modelMapper.map(conversation, ConversationDtoResponse.class);
    }
}
