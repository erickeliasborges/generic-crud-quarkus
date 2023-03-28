package com.example.user

import com.example.generic.crud.GenericService
import javax.enterprise.context.RequestScoped

@RequestScoped
class UserService : GenericService<User?, Long?>(UserRepository())