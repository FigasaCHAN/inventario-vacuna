package com.acostafa.kruger.inventariovacuna.repository;

import com.acostafa.kruger.inventariovacuna.model.Vacuna;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VacunaRepository extends JpaRepository<Vacuna, String>{
    
}
