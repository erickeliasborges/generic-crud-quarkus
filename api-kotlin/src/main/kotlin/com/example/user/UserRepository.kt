package com.example.user

import com.example.generic.crud.GenericRepository
import javax.enterprise.context.RequestScoped

@RequestScoped
class UserRepository : GenericRepository<User?, Long?>()