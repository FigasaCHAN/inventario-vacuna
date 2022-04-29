package com.acostafa.kruger.inventariovacuna.repository;
import java.util.List;
import com.acostafa.kruger.inventariovacuna.model.Vacuna;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VacunaRepository extends JpaRepository<Vacuna, String>{
    public abstract List<Vacuna> findAll(); 
    public abstract List<Vacuna> findByTipo(String tipo);
    public abstract List<Vacuna> findByFechaDeAplicacion(String fechaDeAplicacion);
    public abstract List<Vacuna> findByNumeroDeDosis(int numeroDeDosis);
}
