package com.ifrn.biblioteca.model;

import javax.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private int anoPublicacao;

    @Column(nullable = false)
    private int quantidadeCopiasDisponiveis;

    @ManyToOne
    private Autor autor;

    // Construtores, getters e setters

    public Livro() {
        // Construtor padrão
    }

    public Livro(String titulo, String ISBN, int anoPublicacao, int quantidadeCopiasDisponiveis, Autor autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeCopiasDisponiveis = quantidadeCopiasDisponiveis;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidadeCopiasDisponiveis() {
        return quantidadeCopiasDisponiveis;
    }

    public void setQuantidadeCopiasDisponiveis(int quantidadeCopiasDisponiveis) {
        this.quantidadeCopiasDisponiveis = quantidadeCopiasDisponiveis;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
