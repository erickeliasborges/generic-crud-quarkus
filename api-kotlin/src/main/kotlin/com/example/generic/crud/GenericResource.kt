package com.example.generic.crud

import com.example.user.User
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.Response

abstract class GenericResource<T, ID>(private val service: GenericService<T, ID>) {

    @GET
    fun get(): Response {
        return Response.ok(service.findAll()).build()
    }

    @GET
    @Path("{id}")
    fun getById(@PathParam("id") id: ID): Response {
        return Response.ok(service.findById(id)).build()
    }

    @POST
    @Transactional
    fun save(genericClass: @Valid T): Response {
        return Response.status(Response.Status.CREATED).entity(service.save(genericClass)).build()
    }

    @PUT
    @Transactional
    fun update(genericClass: @Valid T): Response {
        return Response.ok(service.update(genericClass)).build()
    }

    @DELETE
    @Path("{id}")
    @Transactional
    fun deleteById(@PathParam("id") id: ID): Response {
        return Response.ok(service.deleteById(id)).build()
    }

}