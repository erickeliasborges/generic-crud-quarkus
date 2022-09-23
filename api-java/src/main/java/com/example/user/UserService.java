package com.example.user;

import com.example.generic.crud.GenericService;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserService extends GenericService<User, Long, UserRepository> {

}
