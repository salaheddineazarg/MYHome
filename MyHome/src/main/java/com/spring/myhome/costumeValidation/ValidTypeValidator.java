package com.spring.myhome.costumeValidation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ValidTypeValidator implements ConstraintValidator<ValidType, String> {

    private List<String> allowedTypes;

    @Override
    public void initialize(ValidType constraintAnnotation) {
        allowedTypes = loadAllowedTypes();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || allowedTypes.contains(value);
    }

    private List<String> loadAllowedTypes() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("../helper/categories.json")) {
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            String jsonContent = scanner.hasNext() ? scanner.next() : "";
            return parseJsonTypes(jsonContent);
        } catch (IOException e) {
            throw new RuntimeException("Error loading allowed types", e);
        }
    }

    private List<String> parseJsonTypes(String jsonContent) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonContent, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON content", e);
        }
    }
}
