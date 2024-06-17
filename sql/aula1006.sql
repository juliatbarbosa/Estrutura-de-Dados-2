CREATE DATABASE ed2

USE ed2

CREATE TABLE livro (
	idLivro INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(255) NOT NULL,
	autor VARCHAR(255) NOT NULL,
	ano int NOT NULL
)

DROP TABLE livro

SELECT * FROM livro

INSERT INTO livro(titulo, autor, ano) VALUES ('Dom Casmurro', 'Machado de Assis', 1899)

DELETE FROM livro WHERE idLivro = 4