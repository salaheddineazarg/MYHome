package com.spring.myhome.dto.Converstaion;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationDto {

    private UUID id;

    @NotNull(message = "User cannot be null")
    @Positive(message = "User must be a positive number")
    private UUID user;

    @NotNull(message = "User2 cannot be null")
    @Positive(message = "User2 must be a positive number")
    private UUID user2;


}
