-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bilhete`
--

DROP TABLE IF EXISTS `bilhete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bilhete` (
  `bilhete_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `sessao_id` mediumint(9) DEFAULT NULL,
  `cliente_id` mediumint(9) DEFAULT NULL,
  `vendedor_id` mediumint(9) DEFAULT NULL,
  `data` date NOT NULL,
  `meia_entrada` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`bilhete_id`),
  KEY `sessao_dia_id` (`sessao_id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `vendedor_id` (`vendedor_id`),
  CONSTRAINT `fk_cliente_bilhete` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`),
  CONSTRAINT `fk_sessao_bilhete` FOREIGN KEY (`sessao_id`) REFERENCES `sessao` (`sessao_id`),
  CONSTRAINT `fk_vendedor_bilhete` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`vendedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilhete`
--

LOCK TABLES `bilhete` WRITE;
/*!40000 ALTER TABLE `bilhete` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilhete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilheteextra`
--

DROP TABLE IF EXISTS `bilheteextra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bilheteextra` (
  `bilhete_extra_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `extra_id` mediumint(9) NOT NULL,
  `bilhete_id` mediumint(9) NOT NULL,
  PRIMARY KEY (`bilhete_extra_id`),
  KEY `extra_id` (`extra_id`),
  KEY `bilhete_id` (`bilhete_id`),
  CONSTRAINT `fk_bilhete_bilhete_extra` FOREIGN KEY (`bilhete_id`) REFERENCES `bilhete` (`bilhete_id`),
  CONSTRAINT `fk_extra_bilhete_extra` FOREIGN KEY (`extra_id`) REFERENCES `extra` (`extra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilheteextra`
--

LOCK TABLES `bilheteextra` WRITE;
/*!40000 ALTER TABLE `bilheteextra` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilheteextra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilhetepreco`
--

DROP TABLE IF EXISTS `bilhetepreco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bilhetepreco` (
  `bilhete_preco_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `bilhete_id` mediumint(9) NOT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`bilhete_preco_id`),
  KEY `bilhete_id` (`bilhete_id`),
  CONSTRAINT `fk_bilhete_bilhete_preco` FOREIGN KEY (`bilhete_id`) REFERENCES `bilhete` (`bilhete_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilhetepreco`
--

LOCK TABLES `bilhetepreco` WRITE;
/*!40000 ALTER TABLE `bilhetepreco` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilhetepreco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificacao` (
  `classificacao_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`classificacao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
INSERT INTO `classificacao` VALUES (1,'Livre');
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cliente_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `pessoa_id` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `pessoa_id` (`pessoa_id`),
  CONSTRAINT `fk_pessoa_cliente` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienteinteresse`
--

DROP TABLE IF EXISTS `clienteinteresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienteinteresse` (
  `interesse_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `cliente_id` mediumint(9) DEFAULT NULL,
  `genero_id` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`interesse_id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `genero_id` (`genero_id`),
  CONSTRAINT `fk_cliente_cliente_interesse` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`),
  CONSTRAINT `fk_genero_cliente_interesse` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`genero_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienteinteresse`
--

LOCK TABLES `clienteinteresse` WRITE;
/*!40000 ALTER TABLE `clienteinteresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `clienteinteresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra`
--

DROP TABLE IF EXISTS `extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra` (
  `extra_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`extra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra`
--

LOCK TABLES `extra` WRITE;
/*!40000 ALTER TABLE `extra` DISABLE KEYS */;
INSERT INTO `extra` VALUES (1,'Poltrona inteligente',10.00,'Poltrona inteligente que fornece maior realismo e conforto ao cinéfilo'),(2,'Óculos ativo',5.00,'Óculos de funcionalidade ativa que amplifica a interação do consumidor com a obra'),(3,'Kit Clássico',12.00,'Pipoca média + Refrigerante lata');
/*!40000 ALTER TABLE `extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filme`
--

DROP TABLE IF EXISTS `filme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filme` (
  `filme_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `classificacao_id` mediumint(9) DEFAULT NULL,
  `genero_id` mediumint(9) DEFAULT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `duracao_minutos` tinyint(4) DEFAULT NULL,
  `duracao_horas` tinyint(4) DEFAULT NULL,
  `ano_lancamento` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`filme_id`),
  KEY `classificacao_id` (`classificacao_id`),
  KEY `genero_id` (`genero_id`),
  CONSTRAINT `fk_classificacao_filme` FOREIGN KEY (`classificacao_id`) REFERENCES `classificacao` (`classificacao_id`),
  CONSTRAINT `fk_genero_filme` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`genero_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filme`
--

LOCK TABLES `filme` WRITE;
/*!40000 ALTER TABLE `filme` DISABLE KEYS */;
INSERT INTO `filme` VALUES (1,1,1,'Harry',123,123,123),(3,1,2,'Comédia braba',12,1,2019),(4,1,2,'Uma comédia nada romantica',12,1,2019),(5,1,1,'GodFather',123,1,2019),(6,1,1,'Shrek',123,1,2019),(7,1,1,'Brasileirinhas',123,1,2019);
/*!40000 ALTER TABLE `filme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `funcionario_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `pessoa_id` mediumint(9) DEFAULT NULL,
  `usuario` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `senha` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`funcionario_id`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `pessoa_id` (`pessoa_id`),
  CONSTRAINT `fk_pessoa_funcionario` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,1,'melo23','da3380aded1904ade382f890d4be7990'),(4,4,'teste22','3221d2a4361d0a0f203fe09f26eff6fe'),(5,5,'filos33','075024622c7ba72b527f9d34d296c025'),(6,6,'giulya33','78479e545889058e5d15fcb71e1f2175'),(7,7,'melo43','8e339103382883b277baa8a72835f494'),(8,8,'dasda','d6cdd1a281487ac6515b8f0d4330d90c'),(9,9,'teste','21eba6159e1d2a455b4becc43a95842d');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionariotelefone`
--

DROP TABLE IF EXISTS `funcionariotelefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionariotelefone` (
  `funcionario_telefone_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `funcionario_id` mediumint(9) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`funcionario_telefone_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `fk_funcionario_funcionario_telefone` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionariotelefone`
--

LOCK TABLES `funcionariotelefone` WRITE;
/*!40000 ALTER TABLE `funcionariotelefone` DISABLE KEYS */;
INSERT INTO `funcionariotelefone` VALUES (1,1,'38210478'),(4,4,'389920291'),(5,5,'382102292'),(6,6,'38210478'),(7,7,'2312382'),(8,8,'123132'),(9,9,'281232922');
/*!40000 ALTER TABLE `funcionariotelefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `genero_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`genero_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Terror'),(2,'Comédia'),(3,'Romance');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerente`
--

DROP TABLE IF EXISTS `gerente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gerente` (
  `gerente_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `funcionario_id` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`gerente_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `fk_funcionario_gerente` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerente`
--

LOCK TABLES `gerente` WRITE;
/*!40000 ALTER TABLE `gerente` DISABLE KEYS */;
INSERT INTO `gerente` VALUES (2,4),(3,5),(4,9);
/*!40000 ALTER TABLE `gerente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `pessoa_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_cadastro` date DEFAULT NULL,
  PRIMARY KEY (`pessoa_id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'02132449694','Gabriel','gabrielmelocomp@gmail.com','2019-11-20','2019-11-20'),(3,'021324495','Gabriel Vendedor','gabrielmeloco@gmail.com','2019-11-20','2019-11-20'),(4,'02132449699','Gabriel Gerente','gabriela@gmail.com','2019-11-20','2019-11-20'),(5,'2131223231','Filósofo Gerente','filosofo@gerente.com','2019-11-20','2019-11-20'),(6,'02334567421','Giulya','giulya@vendedora.com','2019-11-20','2019-11-20'),(7,'1231231231','Teste da mascara','gabriel@teste.com','2019-11-20','2019-11-20'),(8,'1231321','teste1','sadass','2019-11-20','1996-02-22'),(9,'0213222232','Gerentaço','gbriiel.com','2019-11-20','2002-12-22');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `sala_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `capacidade` tinyint(4) DEFAULT NULL,
  `quatro_d` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`sala_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,40,0),(2,30,1);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessao` (
  `sessao_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `sala_id` mediumint(9) DEFAULT NULL,
  `filme_id` mediumint(9) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `valor` decimal(13,2) DEFAULT NULL,
  `legendado` tinyint(1) DEFAULT '0',
  `tecnologia_id` mediumint(9) DEFAULT '0',
  PRIMARY KEY (`sessao_id`),
  KEY `sala_id` (`sala_id`),
  KEY `filme_id` (`filme_id`),
  KEY `fk_tecnologia_sessao` (`tecnologia_id`),
  CONSTRAINT `fk_filme_sessao` FOREIGN KEY (`filme_id`) REFERENCES `filme` (`filme_id`),
  CONSTRAINT `fk_sala_sessao` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`sala_id`),
  CONSTRAINT `fk_tecnologia_sessao` FOREIGN KEY (`tecnologia_id`) REFERENCES `tecnologia` (`tecnologia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
INSERT INTO `sessao` VALUES (1,1,1,'2019-02-22','2019-12-22','04:00:00',10.00,1,NULL),(2,1,1,'2019-02-22','2019-12-22','04:00:00',10.00,1,NULL),(3,1,1,'2019-02-22','2019-12-22','04:00:00',20.00,1,NULL),(4,2,5,'2019-02-22','2019-12-22','04:00:00',20.00,0,3),(5,2,5,'2019-02-22','2020-01-01','04:00:00',23.90,1,1);
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnologia`
--

DROP TABLE IF EXISTS `tecnologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnologia` (
  `tecnologia_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`tecnologia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnologia`
--

LOCK TABLES `tecnologia` WRITE;
/*!40000 ALTER TABLE `tecnologia` DISABLE KEYS */;
INSERT INTO `tecnologia` VALUES (1,'Tradicional',NULL),(2,'3D',NULL),(3,'4D',NULL);
/*!40000 ALTER TABLE `tecnologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `vendedor_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `funcionario_id` mediumint(9) DEFAULT NULL,
  `gerente_id` mediumint(9) DEFAULT NULL,
  `meta_vendas` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`vendedor_id`),
  KEY `gerente_id` (`gerente_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `fk_funcionario_vendedor` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`funcionario_id`),
  CONSTRAINT `fk_gerente_vendedor` FOREIGN KEY (`gerente_id`) REFERENCES `gerente` (`gerente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (3,6,3,10),(4,7,2,12),(5,8,2,12);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cinema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-21 10:25:46
