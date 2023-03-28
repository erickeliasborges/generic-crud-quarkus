package com.example.exception

import com.example.response.GenericResponse
import javax.ws.rs.NotFoundException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class NotFoundExceptionHandler : ExceptionMapper<NotFoundException> {
    override fun toResponse(e: NotFoundException): Response {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(GenericResponse(e.message, Response.Status.NOT_FOUND.statusCode))
                .build()
    }
}