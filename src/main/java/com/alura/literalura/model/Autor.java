package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double anioNacimiento;
    private Double anioDefunsion;

    @ManyToOne

    private Libro libro;

    public Autor() {
    }

    public Autor(String nombre, Double anioNacimiento, Double anioDefunsion) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioDefunsion = anioDefunsion;
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.anioNacimiento = datosAutor.fechaDeNacimiento();
        this.anioDefunsion = datosAutor.fechaDeDefunsion();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Double getAnioDefunsion() {
        return anioDefunsion;
    }

    public void setAnioDefunsion(Double anioDefunsion) {
        this.anioDefunsion = anioDefunsion;
    }

    public Double getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Double anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}