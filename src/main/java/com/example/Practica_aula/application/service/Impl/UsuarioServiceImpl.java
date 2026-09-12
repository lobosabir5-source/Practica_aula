package com.example.Practica_aula.application.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;
import com.example.Practica_aula.infrastructure.persistence.UsuarioRepository;
import com.example.Practica_aula.application.dto.UsuarioDto;
import com.example.Practica_aula.domain.Usuario;
import com.example.Practica_aula.application.service.UsuarioService;
import com.example.Practica_aula.domain.UsuarioAdmin;
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
    public void eliminar(long id){
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        
        usuario.setEliminado(true);
        usuarioRepository.save(usuario);

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
