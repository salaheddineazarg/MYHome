package com.spring.myhome.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IData<Response,Request,Type> {

    List<Response> getAllService();
    Optional<Response> saveService(Request request);
    Boolean deleteService(Type id);
    Optional<Response> updateService(Request request,Type id);
    Optional<Response> findByIdService(Type id);
}
