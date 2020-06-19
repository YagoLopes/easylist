-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 06/06/2019 às 01:13
-- Versão do servidor: 10.1.39-MariaDB
-- Versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `easylist`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `lista`
--

CREATE TABLE `lista` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `usuarioID` int(11) DEFAULT NULL,
  `inativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `lista`
--

INSERT INTO `lista` (`id`, `nome`, `usuarioID`, `inativo`) VALUES
(1, 'Lista Teste1', 2, 1),
(5, 'Lista do Yago', 2, 1),
(8, 'Uma Lista Qualquer2', 2, 0),
(9, 'Lista Teste3', 2, 0),
(10, 'Lista Teste 4', 2, 0),
(11, 'Lista Teste 5', 2, 0),
(12, 'Lista Teste 6', 2, 0),
(13, 'Lista Teste 7', 2, 0),
(14, 'Lista Teste usuario2', 3, 0),
(15, 'Mais um teste', 2, 0),
(16, 'Mais um teste', 2, 0),
(17, 'Mais um teste2', 2, 0),
(18, 'Mais um teste2', 2, 0),
(19, 'Mais um teste2', 2, 0),
(20, 'Mais um teste2', 3, 0),
(21, 'Mais um teste2', 3, 0),
(23, 'lista de exemplo', 2, 0),
(24, 'mais um exemplo', 2, 0),
(25, 'Lista do Yago 75', 2, 0),
(26, 'Mais um teste22', 2, 0),
(27, 'Lista de compra Reginez', 2, 0),
(28, 'Lista de salgados', 2, 0),
(29, 'Lista de materiais imepac', 2, 0),
(30, 'lista do schultz', 2, 0),
(31, 'lista de teste admin', 2, 0),
(32, 'Lista da Gaby', 2, 0),
(33, 'lista 32', 2, 0),
(34, 'lista Everthon', 2, 0),
(35, 'Mais um teste55', 2, 0),
(36, 'uma lista qualquer', 2, 0),
(37, 'minha primeira lista', 2, 0),
(38, 'minha primeira lista ', 4, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `valor` varchar(45) NOT NULL,
  `mercado` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `comprovante` varchar(100) DEFAULT NULL,
  `listaID` int(11) DEFAULT NULL,
  `inativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `valor`, `mercado`, `descricao`, `comprovante`, `listaID`, `inativo`) VALUES
(7, 'Arroz Vasconcelos', '10', 'Mega TJotão', '20Kg', 'https://comprovante/arroz/imagens', 1, 1),
(16, 'cebola 2', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 5, 1),
(17, 'Arroz 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 5, 0),
(18, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 5, 0),
(19, 'Frangão do mauá', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 8, 1),
(20, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 1, 0),
(21, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 5, 0),
(22, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 9, 0),
(23, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 10, 0),
(24, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 11, 0),
(25, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 11, 0),
(26, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 12, 0),
(27, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 13, 0),
(28, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 14, 0),
(29, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 15, 0),
(30, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 16, 0),
(31, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 17, 0),
(32, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 18, 0),
(33, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 19, 0),
(34, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 12, 0),
(35, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 20, 0),
(36, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 21, 0),
(38, 'Frango 123', '15', 'Tejotão', 'Arroz 10kg', 'https://localhos/imagens/comprovante1', 21, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `inativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `inativo`) VALUES
(2, 'Yago Lopes Lazaro', 'yagolopeslazaro@gmail.com', '123456', 1),
(3, 'usuario2', 'usuario2@gmail.com', '123456', 0),
(4, 'Admin', 'admin@gmail.com', '123456', 0);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `lista`
--
ALTER TABLE `lista`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuarioID` (`usuarioID`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_listaID` (`listaID`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `lista`
--
ALTER TABLE `lista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `lista`
--
ALTER TABLE `lista`
  ADD CONSTRAINT `lista_ibfk_1` FOREIGN KEY (`usuarioID`) REFERENCES `usuario` (`id`);

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_listaID` FOREIGN KEY (`listaID`) REFERENCES `lista` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
