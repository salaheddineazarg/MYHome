package com.spring.myhome.dto.Photo;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {

    private UUID id;

    @NotBlank(message = "Link cannot be blank")
    @Pattern(regexp = "^https?://\\S+$", message = "Link must be a valid URL")
    private String link;


}
