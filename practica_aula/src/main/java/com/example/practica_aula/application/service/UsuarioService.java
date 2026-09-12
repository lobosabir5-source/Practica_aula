package com.example.practica_aula.application.service;

import com.example.practica_aula.application.dto.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar (UsuarioDto usuarioDto);
    List<UsuarioDto> listar();
    List<UsuarioDto> listarActivos();
}
