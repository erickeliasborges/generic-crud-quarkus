package com.example.user;

import com.example.generic.crud.GenericRepository;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserRepository extends GenericRepository<User, Long> {

}
