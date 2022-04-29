package com.acostafa.kruger.inventariovacuna.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuarios")
public class Usuario {
    // region Viables de Instancia
    @Id
    @Column(name = "id_usuario")
    @NotBlank
    @Length(min = 10, max = 10)
    @Pattern(regexp = "[0-9]{10}", message = "Formato de Cedula Invalido")
    private String cedula;

    @NotBlank
    @Length(min = 3, max = 15)
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Nombre no valido")
    private String nombre;

    @NotBlank
    @Length(min = 3, max = 15)
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Apellido no valido")
    private String apellido;

    @NotBlank
    @Email(message = "No es un email valido")
    private String email;

    @NotBlank
    private String usuario;

    @NotBlank
    private String contraseña;

    private boolean administrador; // TODO implementar entidad Rol
    // region Datos Personales
    @JoinColumn(name = "id_datosPersonales", unique=true)
    @OneToOne(cascade = CascadeType.ALL)
    private DatosPersonales datosPersonales;

    @JoinColumn(name = "id_vacuna", unique=true)
    @OneToOne(cascade = CascadeType.ALL)
    private Vacuna vacuna; // TODO relacionar con una tabla de Vacunacion
    // endregion
    // endregion
    // region Constructores

    public Usuario() {
    }

    
    public Usuario(
            @NotBlank @Length(min = 10, max = 10) @Pattern(regexp = "[0-9]{10}", message = "Formato de Cedula Invalido") String cedula,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Nombre no valido") String nombre,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Apellido no valido") String apellido,
            @NotBlank @Email(message = "No es un email valido") String email, @NotBlank String usuario,
            @NotBlank String contraseña, boolean administrador, DatosPersonales datosPersonales, Vacuna vacuna) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
        this.datosPersonales = datosPersonales;
        this.vacuna = vacuna;
    }
    // endregion



    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }


    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }


    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    
    // endregion

}
