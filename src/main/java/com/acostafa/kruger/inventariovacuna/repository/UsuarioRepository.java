package com.acostafa.kruger.inventariovacuna.repository;

import java.util.List;
import java.util.Optional;

import com.acostafa.kruger.inventariovacuna.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    public abstract Optional<Usuario> findById(String id); 
    public abstract List<Usuario> findAll(); 

}
