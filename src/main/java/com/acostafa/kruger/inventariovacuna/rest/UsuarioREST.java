package com.acostafa.kruger.inventariovacuna.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.acostafa.kruger.inventariovacuna.model.Usuario;
import com.acostafa.kruger.inventariovacuna.service.implementaciones.UsuarioServiceImp;

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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioREST {
    @Autowired
    private UsuarioServiceImp usuarioService;

    //region Guardar
    @Operation(summary = "Guarda nuevo usuario, todos los id deben ser iguales")
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
    @Operation(summary = "Se obtiene una lista con todos los usuarios")
    @GetMapping
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarTodasLosUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
    @Operation(summary = "Recibe como param un boolean y devuelve una lista con los usuarios vacunado/no-vacunado")
    @GetMapping(value = "/listar/vacunados/{vacunado}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarVacunados(@PathVariable boolean vacunado) {
        return ResponseEntity.ok(usuarioService.getVacunados(vacunado));
    }
    @Operation(summary = "Recibe el nombre de una vacuna y devuelve una lista de vacunados con ese tipo")
    @GetMapping(value = "/listar/vacunados-con/{vacuna}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Usuario>> listarVacunados(@PathVariable String vacuna) {
        return ResponseEntity.ok(usuarioService.getVacunados(vacuna));
    }
    // endregion
    //region Eliminar
    @Operation(summary = "Elimina a un usuario segun su id")
    @DeleteMapping(value = "/eliminar/{id}")
    private ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        Usuario usuarioAEliminar = usuarioService.findById(id);
        if(usuarioAEliminar!=null){
            usuarioService.delete(usuarioAEliminar);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    //endregion
    // region Busqueda
    @Operation(summary = "Busca un usuario segun su id")
    @GetMapping(value = "/buscar/{id}")
    @Procedure(value = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Usuario> buscarUsuarioPorID(@PathVariable String id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario!=null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // endregion
}
