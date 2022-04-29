package com.acostafa.kruger.inventariovacuna.repository;

import java.util.List;

import com.acostafa.kruger.inventariovacuna.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public abstract List<Usuario> findByVacunadoTrue(); 
    public abstract List<Usuario> findByVacunadoFalse(); 
}