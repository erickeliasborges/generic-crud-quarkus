package com.example.generic.crud;

import com.example.user.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public abstract class GenericResource<T, S extends GenericService> {

    @Inject
    S service;

    @GET
    public Response get() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @POST
    @Transactional
    public Response save(@Valid User user) {
        return Response.status(Response.Status.CREATED).entity(service.save(user)).build();
    }

    @PUT
    @Transactional
    public Response update(@Valid User user) {
        return Response.ok(service.update(user)).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        return Response.ok(service.deleteById(id)).build();
    }

}
