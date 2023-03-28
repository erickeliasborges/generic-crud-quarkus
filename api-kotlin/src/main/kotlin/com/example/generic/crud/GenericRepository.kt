package com.example.generic.crud

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase

abstract class GenericRepository<T, ID> : PanacheRepositoryBase<T, ID>