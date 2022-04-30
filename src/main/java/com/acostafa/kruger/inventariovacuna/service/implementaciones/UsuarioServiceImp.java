package com.acostafa.kruger.inventariovacuna.service.implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.acostafa.kruger.inventariovacuna.model.DatosPersonales;
import com.acostafa.kruger.inventariovacuna.model.Usuario;
import com.acostafa.kruger.inventariovacuna.model.Vacuna;
import com.acostafa.kruger.inventariovacuna.repository.DatosPersonalesRepository;
import com.acostafa.kruger.inventariovacuna.repository.UsuarioRepository;
import com.acostafa.kruger.inventariovacuna.repository.VacunaRepository;
import com.acostafa.kruger.inventariovacuna.service.interfaces.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImp implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;
    @Autowired
    private VacunaRepository vacunasRepository;
    
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getVacunados(boolean vacunado) {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        List<DatosPersonales> listaDeVacunas = vacunado? datosPersonalesRepository.findByVacunaIsNotNull() :datosPersonalesRepository.findByVacunaIsNull() ;

        for(DatosPersonales elem : listaDeVacunas){
            String idABuscar= elem.getId();
            Usuario usuarioEncontrado = this.findById(idABuscar);
            listaDeUsuarios.add(usuarioEncontrado);
        }
        return listaDeUsuarios;
    }

    @Override
    public List<Usuario> getVacunados(String vacuna) {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        List<Vacuna> listaDeVacunas = vacunasRepository.findByTipo(vacuna);

        for(Vacuna elem : listaDeVacunas){
            String idABuscar= elem.getId();
            Usuario usuarioEncontrado = this.findById(idABuscar);
            listaDeUsuarios.add(usuarioEncontrado);
        }

        return listaDeUsuarios;
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario findById(String id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.isPresent()? usuario.get() : null;
    }

    @Override
    public List<Usuario> getVacunadosFechaEntre(String fechaInicio, String fechaFin) {
        // TODO Implementar Filtro de Fecha
        return null;
    }

    
}   
