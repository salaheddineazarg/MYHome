package com.spring.myhome.dto.Message;


import com.spring.myhome.dto.Converstaion.ConversationDto;
import com.spring.myhome.dto.User.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDtoResponse {
    private UUID id;
    private String text;
    private LocalDateTime dateTime;
    private Boolean wasRead;
    private ConversationDto conversation;
    private UserDto user;
}
