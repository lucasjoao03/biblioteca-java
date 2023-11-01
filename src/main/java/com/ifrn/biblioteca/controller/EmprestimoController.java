package com.ifrn.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifrn.biblioteca.model.Emprestimo;
import com.ifrn.biblioteca.service.EmprestimoService;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    // Endpoint para criar um novo empréstimo
    /**
     * @param emprestimo
     * @return
     */
    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        // Implemente a lógica de validação da regra de negócio aqui
        if (emprestimoService.validarEmprestimo(emprestimo)) {
            Emprestimo novoEmprestimo = emprestimoService.criarEmprestimo(emprestimo);
            return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Limite de empréstimos atingido", HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar um empréstimo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.buscarEmprestimoPorId(id);
        if (emprestimo != null) {
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para listar todos os empréstimos
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    // Endpoint para atualizar um empréstimo existente
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoAtualizado = emprestimoService.atualizarEmprestimo(id, emprestimo);
        if (emprestimoAtualizado != null) {
            return new ResponseEntity<>(emprestimoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para excluir um empréstimo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
