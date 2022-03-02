-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 02 mars 2022 à 07:48
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `lprs_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `idAbsence` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  `dateD` time NOT NULL,
  `justificatif` text NOT NULL,
  `id_eleve` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `dateF` datetime NOT NULL,
  PRIMARY KEY (`idAbsence`),
  KEY `id_eleve` (`id_eleve`),
  KEY `id_prof` (`id_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `id_prof_principale` int(11) NOT NULL,
  PRIMARY KEY (`idClasse`),
  KEY `id_prof_principale` (`id_prof_principale`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idClasse`, `libelle`, `id_prof_principale`) VALUES
(3, '3emeB', 6),
(5, '5eme', 2),
(6, '6eme', 2);

-- --------------------------------------------------------

--
-- Structure de la table `demande_fournisseur`
--

DROP TABLE IF EXISTS `demande_fournisseur`;
CREATE TABLE IF NOT EXISTS `demande_fournisseur` (
  `idDemande` int(11) NOT NULL AUTO_INCREMENT,
  `idFourni` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `nbrStock` int(11) NOT NULL,
  `valide` int(11) NOT NULL DEFAULT '0',
  `idStock` int(11) NOT NULL,
  PRIMARY KEY (`idDemande`),
  KEY `idFourni` (`idFourni`),
  KEY `idUser` (`idUser`),
  KEY `idStock` (`idStock`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `demande_fournisseur`
--

INSERT INTO `demande_fournisseur` (`idDemande`, `idFourni`, `idUser`, `nbrStock`, `valide`, `idStock`) VALUES
(1, 1, 3, 35, 0, 6),
(2, 1, 3, 25, 0, 3),
(3, 1, 5, 40, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `demande_stock`
--

DROP TABLE IF EXISTS `demande_stock`;
CREATE TABLE IF NOT EXISTS `demande_stock` (
  `idDemande` int(10) NOT NULL,
  `id_stock` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `nbrDemande` int(11) NOT NULL,
  `valide` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idDemande`),
  KEY `id_stock` (`id_stock`),
  KEY `id_prof` (`id_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `demande_stock`
--

INSERT INTO `demande_stock` (`idDemande`, `id_stock`, `id_prof`, `nbrDemande`, `valide`) VALUES
(1, 3, 3, 4, 1),
(2, 1, 3, 10, 1);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `idEleve` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `classe` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEleve`),
  KEY `classe` (`classe`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`idEleve`, `nom`, `prenom`, `classe`) VALUES
(6, 'test1', 'test1', 3),
(7, 'test2', 'test2', 5),
(8, 'test3', 'test3', 6),
(9, 'test4', 'test4', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `idFourni` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`idFourni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`idFourni`, `nom`, `mail`) VALUES
(1, 'Auchan', 'auchan@mail.com'),
(2, 'cyberConnect', 'test@mail.com');

-- --------------------------------------------------------

--
-- Structure de la table `horaire`
--

DROP TABLE IF EXISTS `horaire`;
CREATE TABLE IF NOT EXISTS `horaire` (
  `idHoraire` int(11) NOT NULL AUTO_INCREMENT,
  `heure` time NOT NULL,
  PRIMARY KEY (`idHoraire`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `horaire`
--

INSERT INTO `horaire` (`idHoraire`, `heure`) VALUES
(1, '09:00:00'),
(2, '10:00:00'),
(3, '11:00:00'),
(4, '12:00:00'),
(5, '14:00:00'),
(6, '15:00:00'),
(7, '16:00:00'),
(8, '17:00:00'),
(9, '09:30:00'),
(10, '10:30:00'),
(11, '11:30:00'),
(12, '12:30:00'),
(13, '14:30:00'),
(14, '15:30:00'),
(15, '16:30:00'),
(16, '17:30:00');

-- --------------------------------------------------------

--
-- Structure de la table `parent`
--

DROP TABLE IF EXISTS `parent`;
CREATE TABLE IF NOT EXISTS `parent` (
  `idParent` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `id_eleve` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`idParent`),
  KEY `id_eleve` (`id_eleve`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `parent`
--

INSERT INTO `parent` (`idParent`, `nom`, `prenom`, `id_eleve`, `mail`) VALUES
(1, 'test', 'test', 6, 'deoliveirathomas93@gmail.com'),
(2, 'test2', 'test2', 8, 'deoliveirathomas02@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `profclasse`
--

DROP TABLE IF EXISTS `profclasse`;
CREATE TABLE IF NOT EXISTS `profclasse` (
  `Classe` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `matiere` varchar(30) NOT NULL,
  `jour` int(11) NOT NULL,
  `heureD` int(11) NOT NULL,
  `heureF` int(11) NOT NULL,
  KEY `Classe` (`Classe`),
  KEY `idProf` (`idProf`),
  KEY `jour` (`jour`),
  KEY `heureD` (`heureD`),
  KEY `heureF` (`heureF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `profclasse`
--

INSERT INTO `profclasse` (`Classe`, `idProf`, `matiere`, `jour`, `heureD`, `heureF`) VALUES
(3, 6, 'Mathematique', 1, 1, 3),
(3, 2, 'Francais', 1, 3, 4),
(3, 2, 'Francais', 3, 5, 7),
(3, 7, 'Anglais', 2, 1, 2),
(3, 7, 'Anglais', 5, 7, 8);

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `idRdv` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  `date` date NOT NULL,
  `id_parent` int(11) NOT NULL,
  `id_prof_principale` int(11) NOT NULL,
  `idHoraire` int(11) NOT NULL,
  PRIMARY KEY (`idRdv`),
  KEY `id_parent` (`id_parent`),
  KEY `id_prof_principale` (`id_prof_principale`),
  KEY `idHoraire` (`idHoraire`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`idRdv`, `libelle`, `date`, `id_parent`, `id_prof_principale`, `idHoraire`) VALUES
(2, 'test', '2022-03-16', 1, 6, 2);

-- --------------------------------------------------------

--
-- Structure de la table `retard`
--

DROP TABLE IF EXISTS `retard`;
CREATE TABLE IF NOT EXISTS `retard` (
  `idRetard` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `justificatif` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idRetard`),
  KEY `idEleve` (`idEleve`),
  KEY `idProf` (`idProf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sanction`
--

DROP TABLE IF EXISTS `sanction`;
CREATE TABLE IF NOT EXISTS `sanction` (
  `idSanction` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `commentaire` text NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idSanction`),
  KEY `idType` (`idType`),
  KEY `idEleve` (`idEleve`),
  KEY `idProf` (`idProf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `semaine`
--

DROP TABLE IF EXISTS `semaine`;
CREATE TABLE IF NOT EXISTS `semaine` (
  `idJour` int(11) NOT NULL,
  `libelle` varchar(15) NOT NULL,
  PRIMARY KEY (`idJour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `semaine`
--

INSERT INTO `semaine` (`idJour`, `libelle`) VALUES
(1, 'Lundi'),
(2, 'Mardi'),
(3, 'Mercredi'),
(4, 'Jeudi'),
(5, 'Vendredi');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `idStock` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  `nbrStock` int(11) NOT NULL,
  PRIMARY KEY (`idStock`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`idStock`, `libelle`, `nbrStock`) VALUES
(1, 'stylo', 140),
(2, 'crayon', 100),
(3, 'Feutre', 76),
(4, 'Ordinateur', 20),
(5, 'livres', 50),
(6, 'colles UHU', 100),
(7, 'porte crayon', 35),
(8, 'papier', 50);

-- --------------------------------------------------------

--
-- Structure de la table `stock_fournisseur`
--

DROP TABLE IF EXISTS `stock_fournisseur`;
CREATE TABLE IF NOT EXISTS `stock_fournisseur` (
  `idFourni` int(11) NOT NULL,
  `idStock` int(11) NOT NULL,
  KEY `idFourni` (`idFourni`),
  KEY `idStock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stock_fournisseur`
--

INSERT INTO `stock_fournisseur` (`idFourni`, `idStock`) VALUES
(1, 6),
(1, 2),
(1, 3),
(1, 1),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `typesanction`
--

DROP TABLE IF EXISTS `typesanction`;
CREATE TABLE IF NOT EXISTS `typesanction` (
  `idType` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `typesanction`
--

INSERT INTO `typesanction` (`idType`, `libelle`) VALUES
(1, 'Mot dans le carnet'),
(2, 'Heure de colle'),
(3, 'Exclusion de cour'),
(4, 'Exclusion de l\'ecole');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `mdp` varchar(65) NOT NULL,
  `profil` varchar(25) NOT NULL,
  `active` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `nom`, `prenom`, `mail`, `mdp`, `profil`, `active`) VALUES
(2, 'test', 'test', 'test@mail', '098f6bcd4621d373cade4e832627b4f6', 'Professeur', 0),
(3, 'deo', 'thomas', 'deo@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Administratif', 0),
(4, 'test2', 'test2', 'test2@gmail', 'ad0234829205b9033196ba818f7a872b', 'Administratif', 0),
(5, 'theo', 'test', 'blabla@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Administratif', 0),
(6, 'prof', 'test', 'prof@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Professeur', 0),
(7, 'testMail', 'testMail', 'depelit561@shackvine.com', '69e153e4d7add22f245e24de590eec21', 'Professeur', 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `absence_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `absence_ibfk_2` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`idEleve`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`id_prof_principale`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `demande_fournisseur`
--
ALTER TABLE `demande_fournisseur`
  ADD CONSTRAINT `demande_fournisseur_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `demande_fournisseur_ibfk_2` FOREIGN KEY (`idFourni`) REFERENCES `fournisseur` (`idFourni`),
  ADD CONSTRAINT `demande_fournisseur_ibfk_3` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`);

--
-- Contraintes pour la table `demande_stock`
--
ALTER TABLE `demande_stock`
  ADD CONSTRAINT `demande_stock_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `demande_stock_ibfk_2` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`idStock`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`classe`) REFERENCES `classe` (`idClasse`);

--
-- Contraintes pour la table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `parent_ibfk_1` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`idEleve`);

--
-- Contraintes pour la table `profclasse`
--
ALTER TABLE `profclasse`
  ADD CONSTRAINT `profclasse_ibfk_1` FOREIGN KEY (`heureD`) REFERENCES `horaire` (`idHoraire`),
  ADD CONSTRAINT `profclasse_ibfk_2` FOREIGN KEY (`jour`) REFERENCES `semaine` (`idJour`),
  ADD CONSTRAINT `profclasse_ibfk_3` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `profclasse_ibfk_4` FOREIGN KEY (`Classe`) REFERENCES `classe` (`idClasse`),
  ADD CONSTRAINT `profclasse_ibfk_5` FOREIGN KEY (`heureF`) REFERENCES `horaire` (`idHoraire`);

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_ibfk_1` FOREIGN KEY (`id_prof_principale`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `rdv_ibfk_2` FOREIGN KEY (`id_parent`) REFERENCES `parent` (`idParent`),
  ADD CONSTRAINT `rdv_ibfk_3` FOREIGN KEY (`idHoraire`) REFERENCES `horaire` (`idHoraire`);

--
-- Contraintes pour la table `retard`
--
ALTER TABLE `retard`
  ADD CONSTRAINT `retard_ibfk_1` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `retard_ibfk_2` FOREIGN KEY (`idEleve`) REFERENCES `eleve` (`idEleve`);

--
-- Contraintes pour la table `sanction`
--
ALTER TABLE `sanction`
  ADD CONSTRAINT `sanction_ibfk_1` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `sanction_ibfk_2` FOREIGN KEY (`idType`) REFERENCES `typesanction` (`idType`),
  ADD CONSTRAINT `sanction_ibfk_3` FOREIGN KEY (`idEleve`) REFERENCES `eleve` (`idEleve`);

--
-- Contraintes pour la table `stock_fournisseur`
--
ALTER TABLE `stock_fournisseur`
  ADD CONSTRAINT `stock_fournisseur_ibfk_1` FOREIGN KEY (`idFourni`) REFERENCES `fournisseur` (`idFourni`),
  ADD CONSTRAINT `stock_fournisseur_ibfk_2` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
