package com.ifrn.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifrn.biblioteca.model.Emprestimo;
import com.ifrn.biblioteca.model.Usuario;
import com.ifrn.biblioteca.repository.EmprestimoRepository;
import com.ifrn.biblioteca.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {
        // Verificar a restrição de empréstimos por usuário
        Usuario usuario = emprestimo.getUsuarioRealizouEmprestimo();
        if (usuario != null) {
            List<Emprestimo> emprestimosDoUsuario = usuario.getEmprestimos();
            if (emprestimosDoUsuario.size() < usuario.getLimiteEmprestimos()) {
                // O usuário ainda não atingiu o limite de empréstimos, podemos realizar o empréstimo
                emprestimo.setDataEmprestimo(LocalDate.now());
                return emprestimoRepository.save(emprestimo);
            }
        }
        // Caso contrário, o empréstimo é rejeitado
        return null;
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElse(null);
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo atualizarEmprestimo(Long id, Emprestimo emprestimo) {
        
        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }

    public boolean validarEmprestimo(Emprestimo emprestimo) {
        return false;
    }

    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        return null;
    }

    public Emprestimo buscarEmprestimoPorId(Long id) {
        return null;
    }
}
