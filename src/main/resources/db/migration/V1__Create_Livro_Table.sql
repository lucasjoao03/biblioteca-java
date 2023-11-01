-- V1__Create_Livro_Table.sql
CREATE TABLE Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    ISBN VARCHAR(13),
    ano_publicacao INT,
    quantidade_copias_disponiveis INT,
    autor_id INT,
    FOREIGN KEY (autor_id) REFERENCES Autor(id)
);
