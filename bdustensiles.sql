-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 20 déc. 2020 à 20:23
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bdustensiles`
--

-- --------------------------------------------------------

--
-- Structure de la table `assiettecarree`
--

DROP TABLE IF EXISTS `assiettecarree`;
CREATE TABLE IF NOT EXISTS `assiettecarree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anneeFabrication` int(11) NOT NULL,
  `cote` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `assiettecarree`
--

INSERT INTO `assiettecarree` (`id`, `anneeFabrication`, `cote`) VALUES
(1, 2018, 20),
(2, 2015, 10);

-- --------------------------------------------------------

--
-- Structure de la table `assietteronde`
--

DROP TABLE IF EXISTS `assietteronde`;
CREATE TABLE IF NOT EXISTS `assietteronde` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anneeFabrication` int(11) NOT NULL,
  `rayon` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `assietteronde`
--

INSERT INTO `assietteronde` (`id`, `anneeFabrication`, `rayon`) VALUES
(1, 2012, 15),
(2, 2010, 30);

-- --------------------------------------------------------

--
-- Structure de la table `cuillere`
--

DROP TABLE IF EXISTS `cuillere`;
CREATE TABLE IF NOT EXISTS `cuillere` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anneeFabrication` int(11) NOT NULL,
  `longueur` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `cuillere`
--

INSERT INTO `cuillere` (`id`, `anneeFabrication`, `longueur`) VALUES
(1, 2020, 20),
(2, 2012, 16),
(3, 1900, 20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
