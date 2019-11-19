CREATE TABLE Funcionario (
	funcionario_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(10),
	nome VARCHAR(100),
	email VARCHAR(50),
	data_cadastro DATE
);

CREATE TABLE FuncionarioTelefone (
	funcionario_telefone_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	funcionario_id MEDIUMINT ,
	telefone VARCHAR(50),
	CONSTRAINT fk_funcionario_funcionario_telefone FOREIGN KEY (funcionario_id) REFERENCES Funcionario (funcionario_id),
	INDEX (funcionario_id)
);

CREATE TABLE Gerente (
	gerente_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	funcionario_id MEDIUMINT,
	usuario VARCHAR(35),
	senha VARCHAR(35),
	CONSTRAINT fk_funcionario_gerente FOREIGN KEY (funcionario_id) REFERENCES Funcionario (funcionario_id),
	INDEX (funcionario_id)
);

CREATE TABLE Vendedor (
	vendedor_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	funcionario_id MEDIUMINT,
	usuario_id VARCHAR(35),
	CONSTRAINT fk_funcionario_vendedor FOREIGN KEY (funcionario_id) REFERENCES Funcionario (funcionario_id),
	INDEX (funcionario_id)
);

CREATE TABLE Sala (
	sala_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	capacidade TINYINT,
	quatro_d TINYINT(1)
);

CREATE TABLE Classificacao (
	classificacao_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE Genero (
	genero_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE Filme (
	filme_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	classificacao_id MEDIUMINT,
	genero_id MEDIUMINT,
	titulo VARCHAR(35),
	duracao_minutos TINYINT,
	duracao_horas TINYINT,
	ano_lancamento TINYINT,
	CONSTRAINT fk_classificacao_filme FOREIGN KEY (classificacao_id) REFERENCES Classificacao (classificacao_id),
	CONSTRAINT fk_genero_filme FOREIGN KEY (genero_id) REFERENCES Genero (genero_id),
	INDEX (classificacao_id),
	INDEX (genero_id)
);

CREATE TABLE FilmeTresD (
	filme_tres_d_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	filme_id MEDIUMINT,
	valor_oculos_ativo DECIMAL (13, 2),
	valor_oculos_passivo DECIMAL (13, 2),
	oculos_ativo TINYINT(1),
	CONSTRAINT fk_filme_tres_d_filme FOREIGN KEY (filme_id) REFERENCES Filme (filme_id),
	INDEX (filme_id)
);

CREATE TABLE FilmeQuatroD (
	filme_quatro_d_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	filme_id MEDIUMINT,
	valor_poltrona DECIMAL (13, 2),
	valor_poltrona_inteligente DECIMAL (13, 2),
	poltrona TINYINT(1),
	CONSTRAINT fk_filme_quatro_d_filme FOREIGN KEY (filme_id) REFERENCES Filme (filme_id),
	INDEX (filme_id)
);

CREATE TABLE Sessao (
	sessao_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sala_id MEDIUMINT,
	filme_id MEDIUMINT,
	data_inicio DATE,
	data_fim DATE,
	hora TIME,
	valor DECIMAL(13, 2),
	CONSTRAINT fk_sala_sessao FOREIGN KEY (sala_id) REFERENCES Sala (sala_id),
	CONSTRAINT fk_filme_sessao FOREIGN KEY (filme_id) REFERENCES Filme (filme_id),
	INDEX (sala_id),
	INDEX (filme_id)
);

CREATE TABLE SessaoDia (
	sessao_dia_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sessao_id MEDIUMINT,
	dia DATE,
	CONSTRAINT fk_sessao_sessao_dia FOREIGN KEY (sessao_id) REFERENCES Sessao (sessao_id),
	INDEX (sessao_id)
);

CREATE TABLE Bilhete (
	bilhete_id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sessao_dia_id MEDIUMINT,
	cliente_nome VARCHAR(100),
	cliente_cpf VARCHAR(11),
	CONSTRAINT fk_sessao_dia_bilhete FOREIGN KEY (sessao_dia_id) REFERENCES SessaoDia (sessao_dia_id),
	INDEX (sessao_dia_id)
);


/* CONFIGURAÇÕES */
SET GLOBAL time_zone = '+3:00';