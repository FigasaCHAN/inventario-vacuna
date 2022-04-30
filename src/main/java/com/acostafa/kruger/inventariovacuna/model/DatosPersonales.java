package com.acostafa.kruger.inventariovacuna.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private String id; // este id estara relacionado al id del usuario

    private String fechaDeNacimiento;

    private String domicilio;

    private String telefonoMovil;

    private boolean vacunado;

    @JoinColumn(name = "id_vacuna", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Vacuna vacuna;

    // region Constructores
    public DatosPersonales() {

    }

    public DatosPersonales(@NotBlank @Length(min = 10, max = 10) String id, String fechaDeNacimiento, String domicilio,
            String telefonoMovil, boolean vacunado, Vacuna vacuna) {
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.domicilio = domicilio;
        this.telefonoMovil = telefonoMovil;
        this.vacunado = vacunado;
        this.vacuna = vacuna;
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
    // endregion

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
        result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((telefonoMovil == null) ? 0 : telefonoMovil.hashCode());
        result = prime * result + ((vacuna == null) ? 0 : vacuna.hashCode());
        result = prime * result + (vacunado ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DatosPersonales other = (DatosPersonales) obj;
        if (domicilio == null) {
            if (other.domicilio != null)
                return false;
        } else if (!domicilio.equals(other.domicilio))
            return false;
        if (fechaDeNacimiento == null) {
            if (other.fechaDeNacimiento != null)
                return false;
        } else if (!fechaDeNacimiento.equals(other.fechaDeNacimiento))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (telefonoMovil == null) {
            if (other.telefonoMovil != null)
                return false;
        } else if (!telefonoMovil.equals(other.telefonoMovil))
            return false;
        if (vacuna == null) {
            if (other.vacuna != null)
                return false;
        } else if (!vacuna.equals(other.vacuna))
            return false;
        if (vacunado != other.vacunado)
            return false;
        return true;
    }

}
