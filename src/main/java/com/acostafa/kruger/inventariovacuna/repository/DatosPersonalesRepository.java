package com.acostafa.kruger.inventariovacuna.repository;

import java.util.List;

import com.acostafa.kruger.inventariovacuna.model.DatosPersonales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, String> {
    public abstract List<DatosPersonales> findByVacunaIsNotNull();
    public abstract List<DatosPersonales> findByVacunaIsNull();
}
