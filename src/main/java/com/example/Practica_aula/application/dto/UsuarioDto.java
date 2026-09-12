package com.example.practica_aula.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import com.example.practica_aula.domain.Usuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    private Boolean eliminado;
    private String rol;
    private Boolean flagAdmin;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
        this.fechaCreacion = usuario.getFechaCreacion();
        this.fechaModificacion = usuario.getFechaModificacion();
        this.creadoPor = usuario.getCreadoPor();
        this.modificadoPor = usuario.getModificadoPor();
        this.eliminado = usuario.getEliminado();
        this.rol = usuario.getRol();
        this.flagAdmin = usuario.getFlagAdmin();
    }
}
