package com.example.Practica_aula.application.service;

import com.example.Practica_aula.application.dto.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar (UsuarioDto usuarioDto);
    void eliminar_fisico(long id);
    void eliminar(long id);
    List<UsuarioDto> listar();
    List<UsuarioDto> listarActivos();
}
