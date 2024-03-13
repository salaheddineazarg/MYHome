package com.spring.myhome.entities;


import com.spring.myhome.enumeration.TypeOperation;
import jakarta.persistence.*;
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
@Entity
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
    private Double price;

    @NotNull(message = "Type of operation cannot be null")
    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation;

    @NotNull(message = "Date cannot be null")
    private LocalDateTime date;

    @ManyToOne
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne
    @NotNull(message = "Property cannot be null")
    private Property property;
}
