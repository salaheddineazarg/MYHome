package com.spring.myhome.dto.PropertyOperation;

import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.dto.Property.PropertyDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyOperationDtoResponse {

    PropertyDtoResponse propertyDtoResponse;
    OperationDtoResponse operationDtoResponse;
}
