package com.aluracursos.gonzalo.literalura.principal;

import com.aluracursos.gonzalo.literalura.model.Author;
import com.aluracursos.gonzalo.literalura.model.GutendexResponse;
import com.aluracursos.gonzalo.literalura.model.Libro;
import com.aluracursos.gonzalo.literalura.repository.AutorRepository;
import com.aluracursos.gonzalo.literalura.repository.LibroRepository;
import com.aluracursos.gonzalo.literalura.service.ConsumoAPI;
import com.aluracursos.gonzalo.literalura.service.ConvertirDatos;

import java.util.List;
import java.util.Scanner;

public class Principal {

    Scanner teclado = new Scanner(System.in);

    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private AutorRepository autorRepositorio;
    private LibroRepository libroRepositorio;

    List<Libro> libros;
    List<Author> autores;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.autorRepositorio = autorRepository;
        this.libroRepositorio = libroRepository;
    }

    public void mostraMenu() {
        String input;
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("""
                \n===========================
                Elija una opcion (1-5):
                ===========================
                1 - Buscar un libro por su título
                2 - Mostrar todos los libros guardados
                3 - Ver lista de autores registrados
                4 - Buscar autor por año de nacimiento
                5 - Mostrar libros por idioma
                0 - Salir de la aplicación
                """);

            input = teclado.nextLine();

            try {
                opcion = Integer.parseInt(input); // intentar convertir a int
            } catch (NumberFormatException e) {
                System.out.println("Input invalido, debe ingresar un numero.");
                continue; // volver al inicio del while
            }

            switch (opcion) {
                case 1:
                    Libro libro = buscarLibroPorTitulo();
                    if (libro != null && libro.getAuthors() != null) {
                        List<Author> persistedAuthors = guardarAutor(libro.getAuthors());
                        libro.setAuthors(persistedAuthors);
                        libroRepositorio.save(libro);
                        System.out.println("Libro registrado exitosamente:");
                    }
                    break;
                case 2:
                    mostrarTodosLosLibros();
                    break;
                case 3:
                    mostrarTodosLosAutores();
                    break;
                case 4:
                    buscarAutorPorAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("Input invalido, intentelo nuevamente.");
                    break;
            }
        }
    }

    private List<Libro> getLibros() {
        String API_URL = "https://gutendex.com/books";
        var json = consumoApi.obtenerDatos(API_URL);
        ConvertirDatos convertirDatos = new ConvertirDatos();
        GutendexResponse gutendexResponse = convertirDatos.obtenerDatos(json, GutendexResponse.class);
        return gutendexResponse.getResults();
    }

    private List<Author> guardarAutor(List<Author> autores) {
        for (int i = 0; i < autores.size(); i++) {
            Author autor = autores.get(i);
            Author persisted = autorRepositorio.findByName(autor.getName())
                    .orElseGet(() -> autorRepositorio.save(autor));
            autores.set(i, persisted);
        }
        return autores;
    }

    private Libro buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo del libro:");
        String titulo = teclado.nextLine().toLowerCase();
        List<Libro> libros = getLibros();
        for (Libro libro : libros) {
            if (libro.getTitle().toLowerCase().contains(titulo)) {
                return libro;
            }
        }
        System.out.println("Libro no encontrado.");
        return null;
    }

    private void mostrarTodosLosLibros() {
        libros = libroRepositorio.obtenerTodosLosLibros();
        libros.forEach(System.out::println);
    }

    private void mostrarTodosLosAutores() {
        autores = autorRepositorio.obtenerTodosLosAutores();
        autores.stream()
                .forEach(System.out::println);
    }

    private void buscarAutorPorAnio() {
        System.out.println("Ingrese el año de nacimiento del autor:");
        Integer year = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer
        List<Author> autores = autorRepositorio.findByYear(year);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores nacidos en ese año.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma del libro (Ejemplo: en, es, fr):");
        String idioma = teclado.nextLine().toLowerCase();

        List<Libro> librosPorIdioma = libroRepositorio.findByIdioma(idioma);

        if (librosPorIdioma.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma.");
        } else {
            System.out.println("Libros en idioma '" + idioma + "':");
            for (Libro libro : librosPorIdioma) {

                System.out.println(libro);
            }
        }
    }

}