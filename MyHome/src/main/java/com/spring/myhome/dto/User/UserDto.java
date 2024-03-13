package com.spring.myhome.dto.User;


import com.spring.myhome.enumeration.IdentityDoc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private UUID id;

    @NotBlank(message = "fullName cannot be blank")
    private String fullName;

    @NotBlank(message = "First name cannot be blank")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]+$", message = "Password must contain at least one letter, one number, and may include special characters")
    private String password;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Identity document cannot be null")
    private IdentityDoc identityDocument;

    @NotBlank(message = "Identity number cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Identity number must contain only letters and digits")
    private String identityNumber;
}
