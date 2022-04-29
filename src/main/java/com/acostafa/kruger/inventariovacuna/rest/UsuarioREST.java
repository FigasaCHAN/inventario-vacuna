package com.acostafa.kruger.inventariovacuna.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.acostafa.kruger.inventariovacuna.model.Usuario;
import com.acostafa.kruger.inventariovacuna.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    //region Guardar
    @PostMapping
    private ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario usuario) {
        Usuario temporal = usuarioService.create(usuario);

        try {
            return ResponseEntity.created(new URI("/api/usuarios" + temporal.getCedula())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    //endregion
    //region Listar usuarios
    @GetMapping
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarTodasLosUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping(value = "/listar/vacunados/{vacunado}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarVacunados(@PathVariable boolean vacunado) {
        return ResponseEntity.ok(usuarioService.getVacunados(vacunado));
    }

    @GetMapping(value = "/listar/vacunados-con/{vacuna}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarVacunados(@PathVariable String vacuna) {
        return ResponseEntity.ok(usuarioService.getVacunados(vacuna));
    }
    // endregion
    //region Eliminar
    @DeleteMapping(value = "/eliminar/{id}")
    private ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.delete(usuario.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    //endregion
    // region Busqueda
    @GetMapping(value = "/buscar/{id}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Usuario> buscarUsuarioPorID(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // endregion
}
