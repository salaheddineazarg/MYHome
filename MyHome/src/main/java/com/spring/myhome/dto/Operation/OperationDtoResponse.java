package com.spring.myhome.dto.Operation;

import com.spring.myhome.dto.Property.PropertyDto;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import com.spring.myhome.dto.User.UserDto;
import com.spring.myhome.enumeration.TypeOperation;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDtoResponse {
    private UUID id;
    private Double price;
    @Enumerated
    private TypeOperation typeOperation;
    private LocalDateTime date;
    private UserDto user;
    private PropertyDtoResponse property;
}
