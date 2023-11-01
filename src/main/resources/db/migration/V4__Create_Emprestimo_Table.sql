-- V4__Create_Emprestimo_Table.sql
CREATE TABLE Emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_emprestimo DATE,
    data_devolucao DATE,
    livro_id INT,
    usuario_id INT,
    FOREIGN KEY (livro_id) REFERENCES Livro(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
