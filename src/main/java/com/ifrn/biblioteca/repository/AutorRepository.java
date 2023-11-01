package com.ifrn.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifrn.biblioteca.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
   
}
