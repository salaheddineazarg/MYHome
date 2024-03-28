package com.spring.myhome.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive value")
    private Double area;

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 50, message = "Country must be less than 50 characters")
    private String country;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City must be less than 50 characters")
    private String city;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @Temporal(TemporalType.DATE)
    @Past(message = "yearBuilt must be in past")
    private LocalDate yearBuilt;

    @PositiveOrZero(message = "Floor number must be a positive value or zero")
    private Integer floorNbr;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Floor> floors;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Operation> operations;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Photo> photos;
}
