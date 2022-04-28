package com.acostafa.kruger.inventariovacuna.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class Usuario {
    //region Viables de Instancia
    @Id
    private Long id; // el id del usuario sera la celula
    // @Colum (name = nombrePropiedad) esto indica que en la BDD la propiedad tendrá otro nombre
    private String nombre;
    private String apellido; 
    private String email;
    private String usuario;
    private String contraseña;
    private boolean administrador; //TODO implementar entidad Rol
    // region Datos Personales
    private String fechaDeNacimiento;
    private String domicilio;
    private String telefonoMovil;
    private boolean estaVacunado;
    private String vacuna; //TODO relacionar con una tabla de Vacunacion
    // endregion
    // endregion
    public Usuario(Long cedula, String nombre, String apellido, String email){
        this.id = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    // region Getters y Setters
    public Long getId() {
        return id;
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
    public boolean isEstadoDeVacunacion() {
        return estaVacunado;
    }
    public void setEstadoDeVacunacion(boolean estadoDeVacunacion) {
        this.estaVacunado = estadoDeVacunacion;
    }
    public String getVacuna() {
        return vacuna;
    }
    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    // endregion
    
    
    
}
