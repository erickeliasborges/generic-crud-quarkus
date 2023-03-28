package com.example.user

import com.example.generic.crud.GenericResource
import com.example.generic.crud.GenericService
import javax.enterprise.context.RequestScoped
import javax.ws.rs.Path

@RequestScoped
@Path("user")
class UserResource : GenericResource<User?, Long?>(UserService()) {
}