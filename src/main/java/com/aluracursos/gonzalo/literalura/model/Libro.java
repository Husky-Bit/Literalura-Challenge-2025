package com.aluracursos.gonzalo.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    private int id;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Author> authors = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;
    private int download_count;

    @Override
    public String toString() {
        return "\n============= LIBRO =============\n" +
                "Titulo: " + title + '\n' +
                "Autor: " + (authors != null && !authors.isEmpty() ? authors.get(0).getName() : "Desconocido") + '\n' +
                "Idiomas: " + (languages != null && !languages.isEmpty() ? languages.get(0) : "") + '\n' +
                "Cantidad de descargas: " + download_count +
                "\n=================================\n";
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }


}