package com.example.practica_aula.application.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.practica_aula.infrastructure.persistence.UsuarioRepository;
import com.example.practica_aula.application.dto.UsuarioDto;
import com.example.practica_aula.domain.Usuario;
import com.example.practica_aula.application.service.UsuarioService;
import com.example.practica_aula.domain.UsuarioAdmin;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {

        Usuario usuario;

        if (usuarioDto.getFlagAdmin()) {
            usuario = new UsuarioAdmin();
        } else {
            usuario = new Usuario();
        }

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setFlagAdmin(usuarioDto.getFlagAdmin());
        usuario.setEliminado(false);

        Usuario guardar = usuarioRepository.save(usuario);

        return new UsuarioDto(guardar);
    }

    @Override
    public UsuarioDto editar(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());

        if (usuarioDto.getFlagAdmin() != null) {
            usuario.setFlagAdmin(usuarioDto.getFlagAdmin());
            usuario.setRol(usuarioDto.getFlagAdmin() ? "ADMIN" : "NORMAL");
        }

        Usuario actualizado = usuarioRepository.save(usuario);
        return new UsuarioDto(actualizado);
    }

    @Override
    public List<UsuarioDto> listar(){
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDto(u))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> listarActivos(){
        return usuarioRepository.listarActivos();
    }

}
