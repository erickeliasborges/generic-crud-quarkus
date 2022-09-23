package com.example.generic.crud;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract class GenericRepository<T, ID> implements PanacheRepositoryBase<T, ID> {

}
