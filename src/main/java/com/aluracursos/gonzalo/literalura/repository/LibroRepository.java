package com.aluracursos.gonzalo.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aluracursos.gonzalo.literalura.model.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l ORDER BY l.title ASC")
    List<Libro> obtenerTodosLosLibros();

    @Query("SELECT l FROM Libro l JOIN l.languages lang WHERE :idioma IN (lang)")
    List<Libro> findByIdioma(@Param("idioma") String idioma);


}
