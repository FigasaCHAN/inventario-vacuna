package com.acostafa.kruger.inventariovacuna.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table (name = "usuarios")
public class Usuario {
    //region Viables de Instancia
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    // @Colum (name = nombrePropiedad) esto indica que en la BDD la propiedad tendrá otro nombre
    @NotBlank
    @Length(min = 10, max = 10)
    @Pattern(regexp="[0-9]{10}",message="Formato de Cedula Invalido")
    private String cedula;

    @NotBlank
    @Length(min = 3, max = 15)
    @Pattern(regexp="[A-Z]{1}[a-z]{2,15}",message="Nombre no valido")
    private String nombre;

    @NotBlank
    @Length(min = 3, max = 15)
    @Pattern(regexp="[A-Z]{1}[a-z]{2,15}",message="Apellido no valido")
    private String apellido; 

    @NotBlank
    @Email (message="No es un email valido")
    private String email;

    @NotBlank
    private String usuario;

    @NotBlank
    private String contraseña;

    private boolean administrador; //TODO implementar entidad Rol
    // region Datos Personales
    private Date fechaDeNacimiento;
    private String domicilio;
    private String telefonoMovil;
    private boolean vacunado;
    private String vacuna; //TODO relacionar con una tabla de Vacunacion
    // endregion
    // endregion
    //region Constructores
    public Usuario(){
    }
    
    

    public Usuario(
            @NotBlank @Length(min = 10, max = 10) @Pattern(regexp = "[0-9]{10}", message = "Formato de Cedula Invalido") String cedula,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Nombre no valido") String nombre,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Apellido no valido") String apellido,
            @NotBlank @Email(message = "No es un email valido") String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }



    
    // endregion


    public Usuario(Long id,
            @NotBlank @Length(min = 10, max = 10) @Pattern(regexp = "[0-9]{10}", message = "Formato de Cedula Invalido") String cedula,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Nombre no valido") String nombre,
            @NotBlank @Length(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z]{2,15}", message = "Apellido no valido") String apellido,
            @NotBlank @Email(message = "No es un email valido") String email, @NotBlank String usuario,
            @NotBlank String contraseña, boolean administrador, Date fechaDeNacimiento, String domicilio,
            String telefonoMovil, boolean vacunado, String vacuna) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.domicilio = domicilio;
        this.telefonoMovil = telefonoMovil;
        this.vacunado = vacunado;
        this.vacuna = vacuna;
    }



    // region Getters y Setters
    public Long getId() {
        return id;
    }
    public String getCedula(){
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

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
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
    public String getVacuna() {
        return vacuna;
    }
    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean estaVacunado) {
        this.vacunado = estaVacunado;
    }
    
    // endregion
    
    
    
}
