package com.acostafa.kruger.inventariovacuna.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table (name = "vacunas")
public class Vacuna {

    @Id
    @Column(name = "id_vacuna")
    @NotBlank
    @Length(min = 10, max = 10)
    private String id; //este id estara relacionado al id del usuario

    @NotBlank
    @Length(max = 32)
    @Pattern(regexp = "(^Sputnik$)|(^AstraZeneca$)|(^Pfizer$)|(^Jhonson&Jhonson$)", message = "Tipo no valido")
    private String tipo;

    @NotBlank
    @Length(max = 32)
    @Pattern(regexp = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", message = "Fecha no valida")
    private String fechaDeAplicacion;

    @NotNull
    @Range(min = 1)
    private int numeroDeDosis;
    
    // region Constructores
    public Vacuna(){

    }
    
    public Vacuna(@NotBlank @Length(min = 10, max = 10) String id,
            @NotBlank @Length(max = 32) @Pattern(regexp = "(^Sputnik$)|(^AstraZeneca$)|(^Pfizer$)|(^Jhonson&Jhonson$)", message = "Tipo no valido") String tipo,
            @NotBlank @Length(max = 32) @Pattern(regexp = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", message = "Fecha no valida") String fechaDeAplicacion,
            @NotNull @Range(min = 1) int numeroDeDosis) {
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
    public String getFechaDeAplicacion() {
        return fechaDeAplicacion;
    }
    public void setFechaDeAplicacion(String fechaDeAplicacion) {
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
