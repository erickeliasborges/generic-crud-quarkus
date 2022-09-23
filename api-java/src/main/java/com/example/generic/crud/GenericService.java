package com.example.generic.crud;

import com.example.response.GenericResponse;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID, R extends GenericRepository> {

    @Inject
    R repository;

    public List<T> findAll() {
        return repository.findAll().list();
    }

    public T findById(ID id) {
        Optional<T> optional = repository.findByIdOptional(id);
        if (!optional.isPresent())
            throwNotFoundException();

        return optional.get();
    }

    public GenericResponse save(T entity) {
        repository.persist(entity);
        return GenericResponse.getGenericResponse("Registro(s) incluído(s) com sucesso.", Response.Status.CREATED.getStatusCode());
    }

    public GenericResponse update(T entity) {
        repository.getEntityManager().merge(entity);
        return GenericResponse.getGenericResponse("Registro(s) atualizado(s) com sucesso.", Response.Status.OK.getStatusCode());
    }

    public GenericResponse deleteById(ID id) {
        if (!repository.deleteById(id))
            throwNotFoundException();

        return GenericResponse.getGenericResponse("Registro deletado com sucesso.", Response.Status.OK.getStatusCode());
    }

    private void throwNotFoundException() {
        throw new NotFoundException("Registro não encontrado.");
    }

}
