package com.example.exception;

import com.example.response.GenericResponse;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(GenericResponse
                        .getGenericResponse(e.getMessage(), Response.Status.NOT_FOUND.getStatusCode()))
                .build();
    }

}
