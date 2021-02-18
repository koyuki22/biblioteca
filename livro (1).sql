-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Fev-2021 às 07:11
-- Versão do servidor: 10.4.16-MariaDB
-- versão do PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `titulo` text NOT NULL,
  `autor` text NOT NULL,
  `editora` text NOT NULL,
  `edicao` text NOT NULL,
  `ano` int(255) NOT NULL,
  `valor` varchar(255) NOT NULL,
  `estoque` tinyint(1) NOT NULL,
  `idLivro` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`titulo`, `autor`, `editora`, `edicao`, `ano`, `valor`, `estoque`, `idLivro`) VALUES
('eu odeio', 'linguagem', 'java', 'merd', 3, '1', 1, 1),
('sadasd', 'sadasd', 'teste2', '12', 3, '1', 1, 3),
('teste3', 'sadada', 'sadada', 'adsa', 3, '0.5', 0, 4),
('teste4', 'adsdas', 'sadas', 'dasda', 0, '0.5', 1, 5),
('teste4', 'adsdas', 'sadas', 'dasda', 0, '0.5', 1, 6),
('asdasd', 'asdads', 'asdasd', 'asdad', 0, '0.5', 0, 7),
('Vice', 'Leon Tassinari', 'Roco', '8', 1993, '75,90', 0, 8),
('dsfasdas', 'asdadsa', 'asdasd', 'asddasda', 6, '9,82', 0, 9);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`idLivro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `idLivro` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
