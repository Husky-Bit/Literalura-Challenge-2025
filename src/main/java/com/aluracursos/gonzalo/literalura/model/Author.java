package com.aluracursos.gonzalo.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birth_year;
    private Integer death_year;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public List<String> titlesLibros() {
        return libros.stream()
                .map(Libro::getTitle)
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return "\nAutor: " + name + '\n' +
                "Fecha de nacimiento: " + birth_year + '\n' +
                "Fecha de fallecimiento: " + death_year + '\n' +
                "Libros: " + titlesLibros();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = (libros != null) ? libros : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }
}
