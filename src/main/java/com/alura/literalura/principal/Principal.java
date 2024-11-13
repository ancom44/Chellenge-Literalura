package com.alura.literalura.principal;

import com.alura.literalura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private final String URL_BASE="https://api-colombia.com/api/v1/Department";
    String opcion;
    ConsumoAPI peticion=new ConsumoAPI();
    private Scanner teclado=new Scanner(System.in);
    public void mostrarMenu(){
         var menu= """
                MENU:
                 1) Buscar libro por titulo
                 2) Listar libros registrados de POSTGREST o MYSQL
                 3) Listar autores registrados
                 4) Listar autores vivos en un determinado anio
                 5) Listar libros por idioma
                """;
        System.out.println(menu);
        getData();
        //opcion=teclado.nextLine();

    }

    private void  getData(){
        System.out.println("Escriba el nombre del libro: ");
        var nombreLibro=teclado.nextLine();
        var json =peticion.obtenerDatos(URL_BASE);
        System.out.println(json);
    }

}
