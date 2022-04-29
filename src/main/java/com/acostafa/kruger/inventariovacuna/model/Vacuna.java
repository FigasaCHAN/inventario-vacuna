package com.acostafa.kruger.inventariovacuna.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "vacunas")
public class Vacuna {
    @Id
    @Column(name = "id_vacuna")
    private String id;
    private String tipo;
    private Date fechaDeAplicacion;
    private int numeroDeDosis;
    
    // region Constructores
    public Vacuna(){

    }
    public Vacuna(String id, String tipo, Date fechaDeAplicacion, int numeroDeDosis) {
        this.id = id;
        this.tipo = tipo;
        this.fechaDeAplicacion = fechaDeAplicacion;
        this.numeroDeDosis = numeroDeDosis;
    }
    //endregion
    // region Getters y Setters
    public String getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFechaDeAplicacion() {
        return fechaDeAplicacion;
    }
    public void setFechaDeAplicacion(Date fechaDeAplicacion) {
        this.fechaDeAplicacion = fechaDeAplicacion;
    }
    public int getNumeroDeDosis() {
        return numeroDeDosis;
    }
    public void setNumeroDeDosis(int numeroDeDosis) {
        this.numeroDeDosis = numeroDeDosis;
    }
    // endregion
}
