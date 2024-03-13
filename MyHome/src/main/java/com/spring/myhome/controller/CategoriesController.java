package com.spring.myhome.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping( value = "api/categories",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesController {

    private final ObjectMapper objectMapper;

    public CategoriesController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public Map<String, Object> getPropertyTypes() throws IOException {
        System.out.println(new ClassPathResource("FloorController.java").exists());
        Resource resource = new ClassPathResource("./helper/categories.json");

        Map<String, Object> propertyTypes = objectMapper.readValue(resource.getInputStream(), Map.class);
        return propertyTypes;
    }


}
