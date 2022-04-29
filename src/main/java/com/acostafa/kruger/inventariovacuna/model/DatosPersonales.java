package com.acostafa.kruger.inventariovacuna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "DatosPersonales")
public class DatosPersonales {

    @Id
    @Column(name = "id_datosPersonales")
    @NotBlank
    @Length(min = 10, max = 10)
    private String id; //este id estara relacionado al id del usuario

    private String fechaDeNacimiento;

    private String domicilio;

    private String telefonoMovil;

    private boolean vacunado;

    // region Constructores
    public DatosPersonales(){

    }

   

    public DatosPersonales(@NotBlank @Length(min = 10, max = 10) String id, String fechaDeNacimiento, String domicilio,
            String telefonoMovil, boolean vacunado) {
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.domicilio = domicilio;
        this.telefonoMovil = telefonoMovil;
        this.vacunado = vacunado;
    }
    // endregion

    // region Getters y Setters
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
    //endregion
    
}
