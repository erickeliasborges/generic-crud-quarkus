package com.example.user

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User : Serializable {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var username: String? = null
}