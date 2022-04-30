package com.acostafa.kruger.inventariovacuna.model;


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
            @NotBlank String contraseña, boolean administrador, DatosPersonales datosPersonales) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
        this.datosPersonales = datosPersonales;
    }
    // endregion
    //region Getters y Setters
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

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }


    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (administrador ? 1231 : 1237);
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
        result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
        result = prime * result + ((datosPersonales == null) ? 0 : datosPersonales.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (administrador != other.administrador)
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (cedula == null) {
            if (other.cedula != null)
                return false;
        } else if (!cedula.equals(other.cedula))
            return false;
        if (contraseña == null) {
            if (other.contraseña != null)
                return false;
        } else if (!contraseña.equals(other.contraseña))
            return false;
        if (datosPersonales == null) {
            if (other.datosPersonales != null)
                return false;
        } else if (!datosPersonales.equals(other.datosPersonales))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Usuario [administrador=" + administrador + ", apellido=" + apellido + ", cedula=" + cedula
                + ", contraseña=" + contraseña + ", datosPersonales=" + datosPersonales + ", email=" + email
                + ", nombre=" + nombre + ", usuario=" + usuario + "]";
    }
    
    // endregion

    
}
