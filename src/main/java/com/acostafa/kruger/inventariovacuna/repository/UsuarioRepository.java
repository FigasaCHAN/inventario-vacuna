package com.acostafa.kruger.inventariovacuna.repository;

import com.acostafa.kruger.inventariovacuna.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
