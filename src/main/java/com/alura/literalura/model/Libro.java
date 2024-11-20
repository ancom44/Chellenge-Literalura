package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.size;

@Entity
@Table(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String titulo;
    private String idioma;
    private Double descargas;

    @OneToMany(mappedBy="libro", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Autor> autor;

    public Libro(){};
    public Libro(DatosLibro datosApi) {
        this.titulo =  datosApi.titulo();
        if(datosApi.autores().size()>0){
            this.autor = datosApi.autores().stream()
                    .map(Autor::new)
                    .collect(Collectors.toList());
        }
        else{
            autor.add(new Autor(null, null, null));
        }

        try{
            this.idioma = datosApi.idiomas().stream()
                    .collect(Collectors.joining(", "));
        }catch (Exception e){
            System.out.println(e);
            this.idioma=null;
        }
        if(datosApi.numeroDescargas()>0){
            this.descargas = datosApi.numeroDescargas();
        }
        else{
            this.descargas=0.0;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        autor.forEach(e->e.setLibro(this));
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", descargas=" + descargas +
                '}';
    }
}
