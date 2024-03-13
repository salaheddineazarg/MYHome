package com.spring.myhome.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne

    @NotNull
    private User user;
    @ManyToOne
    @NotNull
    private User user2;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Message> messages;
}
