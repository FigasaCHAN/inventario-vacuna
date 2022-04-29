package com.acostafa.kruger.inventariovacuna.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DatosPersonales")
public class DatosPersonales {
    @Id
    private String id;

    private String fechaDeNacimiento;

    private String domicilio;

    private String telefonoMovil;

    private boolean vacunado;

    public DatosPersonales(){

    }

    public DatosPersonales(String id, String fechaDeNacimiento, String domicilio, String telefonoMovil,
            boolean vacunado) {
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.domicilio = domicilio;
        this.telefonoMovil = telefonoMovil;
        this.vacunado = vacunado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
    
    
}
