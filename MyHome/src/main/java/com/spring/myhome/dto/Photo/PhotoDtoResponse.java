package com.spring.myhome.dto.Photo;


import com.spring.myhome.dto.Property.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDtoResponse {

    private UUID id;
    private String link;
    private PropertyDto property;

}
