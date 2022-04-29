package com.acostafa.kruger.inventariovacuna.service;

import java.util.List;
import java.util.Optional;

import com.acostafa.kruger.inventariovacuna.model.Usuario;
import com.acostafa.kruger.inventariovacuna.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    public List<Usuario> getVacunados(boolean vacunado){
        return vacunado? usuarioRepository.findByVacunadoTrue() : usuarioRepository.findByVacunadoFalse();
    }
    public List<Usuario> getVacunados(String vacuna){
        //TODO Corregir
        //return usuarioRepository.findByVacuna(vacuna);
        return null;
    }
    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> findById(String id){
        return usuarioRepository.findById(id);
    }
}   
