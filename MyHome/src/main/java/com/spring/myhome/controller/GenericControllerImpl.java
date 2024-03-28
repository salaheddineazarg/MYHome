package com.spring.myhome.controller;

import com.spring.myhome.service.interfaces.IData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public abstract class GenericControllerImpl<Response, Request,GenericService extends IData<Response, Request, UUID>  >  {

    private final GenericService service;

    public GenericControllerImpl(GenericService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Response>> getAll() {
        return new ResponseEntity<>(service.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody Request request) {

        return service.saveService(request)
                .map(user->new ResponseEntity<>(user,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Positive @PathVariable UUID id, @Valid @RequestBody Request request) {
        return service.updateService(request,id)
                .map(user->new ResponseEntity<>(user,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@Positive @PathVariable UUID id) {

        return new ResponseEntity<>(service.deleteService(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable UUID id) {
        return service.findByIdService(id)
                .map(user->new ResponseEntity<>(user,HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }
}