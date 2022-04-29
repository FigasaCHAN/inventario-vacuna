package com.acostafa.kruger.inventariovacuna.service.interfaces;

import java.util.List;

import com.acostafa.kruger.inventariovacuna.model.Usuario;

public interface IUsuarioService {
    public Usuario create(Usuario usuario);
    public List<Usuario> getAllUsuarios();
    public List<Usuario> getVacunados(boolean vacunado);
    public List<Usuario> getVacunados(String vacuna);
    public List<Usuario> getVacunadosFechaEntre(String fechaInicio, String fechaFin);
    public void delete(Usuario usuario);
    public Usuario findById(String id);
}
