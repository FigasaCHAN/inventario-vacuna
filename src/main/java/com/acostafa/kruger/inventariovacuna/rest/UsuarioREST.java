package com.acostafa.kruger.inventariovacuna.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.acostafa.kruger.inventariovacuna.model.Usuario;
import com.acostafa.kruger.inventariovacuna.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioREST {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario usuario) {
        Usuario temporal = usuarioService.create(usuario);

        try {
            return ResponseEntity.created(new URI("/api/usuarios" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // @GetMapping(value = "/listar/todos")
    @GetMapping
    private ResponseEntity<List<Usuario>> listarTodasLosUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping(value = "/listar/vacunados")
    private ResponseEntity<List<Usuario>> listarVacunados() {
        return ResponseEntity.ok(usuarioService.getVacunados(true));
    }
    @GetMapping(value = "/listar/no-vacunados")
    private ResponseEntity<List<Usuario>> listarNoVacunados() {
        return ResponseEntity.ok(usuarioService.getVacunados(false));
    }

    @DeleteMapping(value = "/eliminar/{id}")
    private ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.delete(usuario.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(value = "/buscar/{id}")
    private ResponseEntity<Usuario> buscarUsuarioPorID(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}