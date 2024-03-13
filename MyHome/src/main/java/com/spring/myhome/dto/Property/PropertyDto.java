package com.spring.myhome.dto.Property;

import com.spring.myhome.costumeValidation.ValidType;
import com.spring.myhome.entities.Floor;
import com.spring.myhome.entities.Operation;
import com.spring.myhome.entities.Photo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private UUID id;
    @NotNull(message = "Description cannot be null")
    private String description;

    @ValidType(message = "Invalid category")
    private String category;

    @NotNull(message = "Area cannot be null")
    @Positive(message = "Area must be a positive number")
    private Double area;

    @Temporal(TemporalType.DATE)
    @Past(message = "yearBuilt must be in past")
    private LocalDate yearBuilt;

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 50, message = "Country must be less than 50 characters")
    private String country;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City must be less than 50 characters")
    private String city;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Floor number cannot be null")
    @Positive(message = "Floor number must be a positive number")
    private Integer floorNbr;

    @NotNull(message = "Image IDs cannot be null")
    @Size(min = 1, message = "At least one image ID must be provided")
    private List<UUID> image_id;


}
