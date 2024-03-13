package com.spring.myhome.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Link cannot be blank")
    @Pattern(regexp = "^(http|https)://.*$", message = "Link must start with 'http://' or 'https://'")
    private String link;

    @ManyToOne
    @NotNull(message = "Property cannot be null")
    private Property property;
}
