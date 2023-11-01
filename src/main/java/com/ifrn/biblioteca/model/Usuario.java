package com.ifrn.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataRegistro;

    @OneToMany(mappedBy = "usuarioRealizouEmprestimo")
    private List<Emprestimo> emprestimos;

    // Construtores, getters e setters

    public Usuario() {
        // Construtor padrão
    }

    public Usuario(String nome, LocalDate dataRegistro) {
        this.nome = nome;
        this.dataRegistro = dataRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public int getLimiteEmprestimos() {
        return 0;
    }
}
