package com.aluracursos.gonzalo.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.gonzalo.literalura.model.Author;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    @Query("SELECT a FROM Author a ORDER BY a.name ASC")
    List<Author> obtenerTodosLosAutores(); //

    @Query("SELECT a FROM Author a WHERE a.birth_year <= :year AND (a.death_year IS NULL OR a.death_year >= :year)")
    List<Author> findByYear(Integer year); //


}
