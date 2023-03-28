package com.example.exception

import com.example.response.GenericResponse
import java.util.*
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ExceptionHandler : ExceptionMapper<Exception> {
    override fun toResponse(exception: Exception): Response {
        val errorId = UUID.randomUUID().toString()
        return Response.serverError()
                .entity(GenericResponse(
                        errorId,
                        "Ocorreu um erro inesperado no sistema.",
                        exception.message,
                        Response.Status.INTERNAL_SERVER_ERROR.statusCode))
                .build()
    }
}