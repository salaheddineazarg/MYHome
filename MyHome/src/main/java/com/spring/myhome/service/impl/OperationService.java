package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Operation.OperationDto;
import com.spring.myhome.dto.Operation.OperationDtoResponse;
import com.spring.myhome.entities.Operation;
import com.spring.myhome.repository.OperationRepository;
import com.spring.myhome.repository.PropertyRepository;
import com.spring.myhome.repository.UserRepository;
import com.spring.myhome.service.interfaces.IOperation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OperationService extends GenericServiceImpl<
        OperationDtoResponse,
        OperationDto,
        Operation,
        OperationRepository
        >
        implements IOperation {


      private final ModelMapper modelMapper;
      private final OperationRepository operationRepository;

      private final PropertyRepository propertyRepository;

      private final UserRepository userRepository;


    public OperationService(OperationRepository operationRepository,
                            ModelMapper modelMapper,
                            PropertyRepository propertyRepository,
                            UserRepository userRepository){
     super(operationRepository);
     this.modelMapper =modelMapper;
     this.operationRepository =operationRepository;
     this.propertyRepository = propertyRepository;
     this.userRepository = userRepository;

    }


    @Override
    public Optional<OperationDtoResponse> saveService(OperationDto operationDto) {
        Operation operation = convertRequestToEntity(operationDto);

        if (operationDto.getProperty_id() != null){
            operation.setProperty(
                    propertyRepository.findById(operationDto.getProperty_id()).get()
            );
        }

        if (operationDto.getUser_id()!= null){
            operation.setUser(
                    userRepository.findById(operationDto.getUser_id()).get()
            );
        }
        operation = operationRepository.save(operation);

        return Optional.ofNullable(convertEntityToResponse(operation));
    }

    @Override
    protected Operation convertRequestToEntity(OperationDto operationDto) {
        return modelMapper.map(operationDto,Operation.class);
    }

    @Override
    protected OperationDtoResponse convertEntityToResponse(Operation operation) {
        return modelMapper.map(operation, OperationDtoResponse.class);
    }
}
