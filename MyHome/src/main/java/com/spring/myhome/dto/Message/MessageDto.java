package com.spring.myhome.dto.Message;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

     private UUID id;

     @NotBlank(message = "Text cannot be blank")
     private String text;

     @NotNull(message = "DateTime cannot be null")
     @Temporal(TemporalType.TIMESTAMP)
     private LocalDateTime dateTime;

     @NotNull(message = "wasRead cannot be null")
     private Boolean wasRead;

     @NotNull(message = "Conversation ID cannot be null")
     private UUID conversation_id;

     @NotNull(message = "Conversation ID cannot be null")
     private UUID user_id;
}
