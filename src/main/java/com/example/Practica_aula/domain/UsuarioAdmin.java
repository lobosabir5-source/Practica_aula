package com.example.Practica_aula.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin(){
        setRol("ADMIN");
    }
}
