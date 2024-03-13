package com.spring.myhome.dto.Converstaion;


import com.spring.myhome.dto.Message.MessageDto;
import com.spring.myhome.dto.User.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationDtoResponse {
    private UUID id;

    private UserDto user;

    private UserDto user2;

    private List<MessageDto> messages;
}
