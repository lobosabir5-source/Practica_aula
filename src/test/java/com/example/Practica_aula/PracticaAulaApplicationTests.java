package com.example.Practica_aula;

import com.example.practica_aula.application.dto.UsuarioDto;
import com.example.practica_aula.application.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PracticaAulaApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	void contextLoads() {
	}

	@Test
	void deberiaEditarUsuario() {
		UsuarioDto guardado = usuarioService.guardar(new UsuarioDto(null, "Ana", "ana@test.com", null, null, null, null, false, "NORMAL", false));

		UsuarioDto actualizado = usuarioService.editar(guardado.getId(), new UsuarioDto(guardado.getId(), "Ana Actualizada", "ana.nueva@test.com", null, null, null, null, false, "NORMAL", false));

		assertEquals("Ana Actualizada", actualizado.getNombre());
		assertEquals("ana.nueva@test.com", actualizado.getEmail());
	}

}
