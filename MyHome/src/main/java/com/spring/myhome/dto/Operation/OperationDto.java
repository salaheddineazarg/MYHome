package com.spring.myhome.dto.Operation;



import com.spring.myhome.enumeration.TypeOperation;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {

    private UUID id;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "Type of operation cannot be null")
    private TypeOperation typeOperation;

    @NotNull(message = "Date cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be a positive number")
    private String user_name;


}
