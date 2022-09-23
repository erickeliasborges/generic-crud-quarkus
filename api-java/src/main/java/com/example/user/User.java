package com.example.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

}
