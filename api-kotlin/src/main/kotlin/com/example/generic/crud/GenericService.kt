package com.example.generic.crud

import com.example.response.GenericResponse
import java.util.*
import javax.inject.Inject
import javax.ws.rs.NotFoundException
import javax.ws.rs.core.Response

abstract class GenericService<T, ID>(private val repository: GenericRepository<T, ID>) {

    fun findAll(): List<T> {
        return repository.findAll().list()
    }

    fun findById(id: ID): T {
        val optional: Optional<T> = repository.findByIdOptional(id)
        if (!optional.isPresent) throwNotFoundException()
        return optional.get()
    }

    fun save(entity: T): GenericResponse {
        repository.persist(entity)
        return GenericResponse("Registro(s) incluído(s) com sucesso.", Response.Status.CREATED.statusCode)
    }

    fun update(entity: T): GenericResponse {
        repository.entityManager.merge(entity)
        return GenericResponse("Registro(s) atualizado(s) com sucesso.", Response.Status.OK.statusCode)
    }

    fun deleteById(id: ID): GenericResponse {
        if (!repository.deleteById(id)) throwNotFoundException()
        return GenericResponse("Registro deletado com sucesso.", Response.Status.OK.statusCode)
    }

    private fun throwNotFoundException() {
        throw NotFoundException("Registro não encontrado.")
    }

}