package com.spring.myhome.security.auth;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.myhome.dto.User.UserDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    private UserDtoResponse user;
}
