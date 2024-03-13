package com.spring.myhome.service.impl;

import com.spring.myhome.service.interfaces.IData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<Response,Request,Entity,Repository extends JpaRepository<Entity,UUID>> implements IData<Response,Request,UUID> {


    private final Repository repository;

    public GenericServiceImpl(Repository repository){
        this.repository =repository;
    }


    @Override
    public List<Response> getAllService() {
        List<Entity> entities = repository.findAll();
        return entities.stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Response> saveService(Request request) {
        Entity entity = convertRequestToEntity(request);
        entity = repository.save(entity);
        Response response = convertEntityToResponse(entity);

        return Optional.ofNullable(response);
    }

    @Override
    public Boolean deleteService(UUID id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Response> updateService(Request request, UUID id) {

        return Optional.empty();
    }

    @Override
    public Optional<Response> findByIdService(UUID id) {
        Entity entity = repository.findById(id).get();
        return Optional.ofNullable(convertEntityToResponse(entity));

    }



    protected abstract Entity convertRequestToEntity(Request request);
    protected abstract Response convertEntityToResponse(Entity entity);
}
