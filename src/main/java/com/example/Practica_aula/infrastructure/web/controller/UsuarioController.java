package com.example.Practica_aula.infrastructure.web.controller;

import com.example.Practica_aula.application.dto.UsuarioDto;
import com.example.Practica_aula.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> guardar (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.guardar(usuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("eliminarfisico/{id}")
    public ResponseEntity<Void> eliminar_fisico(@PathVariable Long id) {
        usuarioService.eliminar_fisico(id);
        return ResponseEntity.noContent().build();
    }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioDto>> listarUsuariosActivos(){
        return ResponseEntity.ok(usuarioService.listarActivos());
    }
}
