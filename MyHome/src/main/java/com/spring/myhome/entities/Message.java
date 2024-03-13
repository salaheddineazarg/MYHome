package com.spring.myhome.entities;


import jakarta.persistence.*;
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
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Text cannot be blank")
    private String text;

    @NotNull(message = "DateTime cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    @NotNull(message = "wasRead cannot be null")
    private Boolean wasRead;

    @ManyToOne
    @NotNull(message = "Conversation cannot be null")
    private Conversation conversation;

    @ManyToOne
    @NotNull(message = "Conversation cannot be null")
    private User user;

}
