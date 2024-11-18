package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DatosAPI;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private final String URL_BASE="https://gutendex.com/books?search=";
    int opcion;
    ConsumoAPI peticion=new ConsumoAPI();
    private Scanner teclado=new Scanner(System.in);
    private ConvierteDatos convierteDatos=new ConvierteDatos();
    private LibroRepository repositorio;

    public void mostrarMenu(){
        opcion=-1;
        while(opcion!=0){
            var menu= """
                MENU:
                 1) Buscar libro por titulo
                 2) Listar libros registrados de POSTGREST o MYSQL
                 3) Listar autores registrados
                 4) Listar autores vivos en un determinado anio
                 5) Listar libros por idioma
                """;
            System.out.println(menu);
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    buscarLibroApi();
                    break;
                case 2:
                    librosEnDB();
                    break;
                case 3:
                    autoresRegistradosEnDB();
                    break;
                case 4:
                    autoresVivo();
                    break;
                case 5:
                    libroPorIdioma();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }
        }

    private DatosLibro  getDatosLibro(){

        System.out.println("Escriba el nombre del libro: ");
        var nombreLibro=teclado.nextLine();
        var json =peticion.obtenerDatos(URL_BASE+ nombreLibro.replace(" ","+"));
        System.out.println(json);
        DatosLibro datosApi=convierteDatos.obtenerDatos(json, DatosAPI.class).libros().get(0);
        return datosApi;
    }


    private void  buscarLibroApi(){
        DatosLibro datosApi=getDatosLibro();

        Libro libro=new Libro(datosApi);




    }
    private void autoresRegistradosEnDB() {

    }

    private void librosEnDB() {
    }


    private void autoresVivo(){
        System.out.println("Ingrese el anio a explorar");
        var anio=teclado.nextInt();
    }
    private void libroPorIdioma(){
        System.out.println("Ingrese el idioma");
        var idioma=teclado.next();
    }



}
