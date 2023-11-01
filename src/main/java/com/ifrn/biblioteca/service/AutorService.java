package com.ifrn.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifrn.biblioteca.model.Autor;
import com.ifrn.biblioteca.repository.AutorRepository;

import java.util.List;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor criarAutor(Autor autor) {
       
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Autor atualizarAutor(Long id, Autor autor) {
        
        return autorRepository.save(autor);
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor buscarAutorPorId(Long id) {
        return null;
    }
}
