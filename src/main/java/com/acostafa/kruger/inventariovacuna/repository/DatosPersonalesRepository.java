package com.acostafa.kruger.inventariovacuna.repository;

import com.acostafa.kruger.inventariovacuna.model.DatosPersonales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, String> {
    
}
