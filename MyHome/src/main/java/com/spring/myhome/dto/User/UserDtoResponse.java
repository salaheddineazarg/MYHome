package com.spring.myhome.dto.User;


import com.spring.myhome.dto.Converstaion.ConversationDto;
import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.enumeration.IdentityDoc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {

    private UUID id;


    private String userName;

    private String password;

    private String address;

    private IdentityDoc identityDocument;

    private String identityNumber;

    private List<OperationDto> operations;

    private List<ConversationDto> conversations;
}
