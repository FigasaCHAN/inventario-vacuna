package com.acostafa.kruger.inventariovacuna.repository;

import java.util.List;

import com.acostafa.kruger.inventariovacuna.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    public abstract List<Usuario> findByVacunadoTrue(); 
    public abstract List<Usuario> findByVacunadoFalse(); 
    public abstract List<Usuario> findByVacuna(String vacuna);
}
