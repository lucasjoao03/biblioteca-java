package com.ifrn.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    @ManyToOne
    private Livro livroEmprestado;

    @ManyToOne
    private Usuario usuarioRealizouEmprestimo;

    // Construtores, getters e setters

    public Emprestimo() {
        // Construtor padrão
    }

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livroEmprestado, Usuario usuarioRealizouEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livroEmprestado = livroEmprestado;
        this.usuarioRealizouEmprestimo = usuarioRealizouEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livro livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }

    public Usuario getUsuarioRealizouEmprestimo() {
        return usuarioRealizouEmprestimo;
    }

    public void setUsuarioRealizouEmprestimo(Usuario usuarioRealizouEmprestimo) {
        this.usuarioRealizouEmprestimo = usuarioRealizouEmprestimo;
    }
}
