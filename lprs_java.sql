-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 05, 2022 at 07:18 PM
-- Server version: 5.7.32
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lprs_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

CREATE TABLE `absence` (
  `idAbsence` int(10) NOT NULL,
  `libelle` varchar(25) NOT NULL,
  `justificatif` text NOT NULL,
  `id_eleve` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `dateF` datetime NOT NULL,
  `dateD` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE `classe` (
  `idClasse` int(10) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_prof_principale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`idClasse`, `libelle`, `id_prof_principale`) VALUES
(3, '3emeB', 6),
(5, '5eme', 2),
(6, '6eme', 2);

-- --------------------------------------------------------

--
-- Table structure for table `demande_fournisseur`
--

CREATE TABLE `demande_fournisseur` (
  `idDemande` int(11) NOT NULL,
  `idFourni` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `nbrStock` int(11) NOT NULL,
  `valide` int(11) NOT NULL DEFAULT '0',
  `idStock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `demande_fournisseur`
--

INSERT INTO `demande_fournisseur` (`idDemande`, `idFourni`, `idUser`, `nbrStock`, `valide`, `idStock`) VALUES
(1, 1, 3, 35, 0, 6),
(2, 1, 3, 25, 0, 3),
(3, 1, 5, 40, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `demande_stock`
--

CREATE TABLE `demande_stock` (
  `idDemande` int(10) NOT NULL,
  `id_stock` int(11) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `nbrDemande` int(11) NOT NULL,
  `valide` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `demande_stock`
--

INSERT INTO `demande_stock` (`idDemande`, `id_stock`, `id_prof`, `nbrDemande`, `valide`) VALUES
(1, 3, 3, 4, 1),
(2, 1, 3, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

CREATE TABLE `eleve` (
  `idEleve` int(10) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `classe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `eleve`
--

INSERT INTO `eleve` (`idEleve`, `nom`, `prenom`, `classe`) VALUES
(6, 'test1', 'test1', 3),
(7, 'test2', 'test2', 5),
(8, 'test3', 'test3', 6),
(9, 'test4', 'test4', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idFourni` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`idFourni`, `nom`, `mail`) VALUES
(1, 'Auchan', 'auchan@mail.com'),
(2, 'cyberConnect', 'test@mail.com');

-- --------------------------------------------------------

--
-- Table structure for table `horaire`
--

CREATE TABLE `horaire` (
  `idHoraire` int(11) NOT NULL,
  `heure` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `horaire`
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
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `idParent` int(10) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `id_eleve` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`idParent`, `nom`, `prenom`, `id_eleve`, `mail`) VALUES
(1, 'test', 'test', 6, 'deoliveirathomas93@gmail.com'),
(2, 'test2', 'test2', 8, 'deoliveirathomas02@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `profclasse`
--

CREATE TABLE `profclasse` (
  `Classe` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `matiere` varchar(30) NOT NULL,
  `jour` int(11) NOT NULL,
  `heureD` int(11) NOT NULL,
  `heureF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profclasse`
--

INSERT INTO `profclasse` (`Classe`, `idProf`, `matiere`, `jour`, `heureD`, `heureF`) VALUES
(3, 6, 'Mathematique', 1, 1, 3),
(3, 2, 'Francais', 1, 3, 4),
(3, 2, 'Francais', 3, 5, 7),
(3, 7, 'Anglais', 2, 1, 2),
(3, 7, 'Anglais', 5, 7, 8);

-- --------------------------------------------------------

--
-- Table structure for table `rdv`
--

CREATE TABLE `rdv` (
  `idRdv` int(10) NOT NULL,
  `libelle` varchar(25) NOT NULL,
  `date` date NOT NULL,
  `id_parent` int(11) NOT NULL,
  `id_prof_principale` int(11) NOT NULL,
  `idHoraire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rdv`
--

INSERT INTO `rdv` (`idRdv`, `libelle`, `date`, `id_parent`, `id_prof_principale`, `idHoraire`) VALUES
(2, 'test', '2022-03-16', 1, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `retard`
--

CREATE TABLE `retard` (
  `idRetard` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `justificatif` varchar(50) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `retard`
--

INSERT INTO `retard` (`idRetard`, `idEleve`, `idProf`, `justificatif`, `date`) VALUES
(0, 6, 8, 'transport', '2022-04-04 20:38:27'),
(1, 6, 8, 'vomis', '2022-04-04 20:39:28');

-- --------------------------------------------------------

--
-- Table structure for table `sanction`
--

CREATE TABLE `sanction` (
  `idSanction` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `commentaire` text NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idProf` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `semaine`
--

CREATE TABLE `semaine` (
  `idJour` int(11) NOT NULL,
  `libelle` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `semaine`
--

INSERT INTO `semaine` (`idJour`, `libelle`) VALUES
(1, 'Lundi'),
(2, 'Mardi'),
(3, 'Mercredi'),
(4, 'Jeudi'),
(5, 'Vendredi');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `idStock` int(10) NOT NULL,
  `libelle` varchar(25) NOT NULL,
  `nbrStock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock`
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
-- Table structure for table `stock_fournisseur`
--

CREATE TABLE `stock_fournisseur` (
  `idFourni` int(11) NOT NULL,
  `idStock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock_fournisseur`
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
-- Table structure for table `typesanction`
--

CREATE TABLE `typesanction` (
  `idType` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `typesanction`
--

INSERT INTO `typesanction` (`idType`, `libelle`) VALUES
(1, 'Mot dans le carnet'),
(2, 'Heure de colle'),
(3, 'Exclusion de cour'),
(4, 'Exclusion de l\'ecole');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `mdp` varchar(65) NOT NULL,
  `profil` varchar(25) NOT NULL,
  `active` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `nom`, `prenom`, `mail`, `mdp`, `profil`, `active`) VALUES
(2, 'test', 'test', 'test@mail', '098f6bcd4621d373cade4e832627b4f6', 'Professeur', 0),
(3, 'deo', 'thomas', 'deo@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Administratif', 0),
(4, 'test2', 'test2', 'test2@gmail', 'ad0234829205b9033196ba818f7a872b', 'Administratif', 0),
(5, 'theo', 'test', 'blabla@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Administratif', 0),
(6, 'prof', 'test', 'prof@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'Professeur', 0),
(7, 'testMail', 'testMail', 'depelit561@shackvine.com', '69e153e4d7add22f245e24de590eec21', 'Professeur', 0),
(8, 'prof', 'test', 'prof@test.fr', '098f6bcd4621d373cade4e832627b4f6', 'Professeur', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`idAbsence`),
  ADD KEY `id_eleve` (`id_eleve`),
  ADD KEY `id_prof` (`id_prof`);

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`idClasse`),
  ADD KEY `id_prof_principale` (`id_prof_principale`);

--
-- Indexes for table `demande_fournisseur`
--
ALTER TABLE `demande_fournisseur`
  ADD PRIMARY KEY (`idDemande`),
  ADD KEY `idFourni` (`idFourni`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idStock` (`idStock`);

--
-- Indexes for table `demande_stock`
--
ALTER TABLE `demande_stock`
  ADD PRIMARY KEY (`idDemande`),
  ADD KEY `id_stock` (`id_stock`),
  ADD KEY `id_prof` (`id_prof`);

--
-- Indexes for table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`idEleve`),
  ADD KEY `classe` (`classe`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idFourni`);

--
-- Indexes for table `horaire`
--
ALTER TABLE `horaire`
  ADD PRIMARY KEY (`idHoraire`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`idParent`),
  ADD KEY `id_eleve` (`id_eleve`);

--
-- Indexes for table `profclasse`
--
ALTER TABLE `profclasse`
  ADD KEY `Classe` (`Classe`),
  ADD KEY `idProf` (`idProf`),
  ADD KEY `jour` (`jour`),
  ADD KEY `heureD` (`heureD`),
  ADD KEY `heureF` (`heureF`);

--
-- Indexes for table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`idRdv`),
  ADD KEY `id_parent` (`id_parent`),
  ADD KEY `id_prof_principale` (`id_prof_principale`),
  ADD KEY `idHoraire` (`idHoraire`);

--
-- Indexes for table `retard`
--
ALTER TABLE `retard`
  ADD PRIMARY KEY (`idRetard`),
  ADD KEY `idEleve` (`idEleve`),
  ADD KEY `idProf` (`idProf`);

--
-- Indexes for table `sanction`
--
ALTER TABLE `sanction`
  ADD PRIMARY KEY (`idSanction`),
  ADD KEY `idType` (`idType`),
  ADD KEY `idEleve` (`idEleve`),
  ADD KEY `idProf` (`idProf`);

--
-- Indexes for table `semaine`
--
ALTER TABLE `semaine`
  ADD PRIMARY KEY (`idJour`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`idStock`);

--
-- Indexes for table `stock_fournisseur`
--
ALTER TABLE `stock_fournisseur`
  ADD KEY `idFourni` (`idFourni`),
  ADD KEY `idStock` (`idStock`);

--
-- Indexes for table `typesanction`
--
ALTER TABLE `typesanction`
  ADD PRIMARY KEY (`idType`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absence`
--
ALTER TABLE `absence`
  MODIFY `idAbsence` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `idClasse` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `demande_fournisseur`
--
ALTER TABLE `demande_fournisseur`
  MODIFY `idDemande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `idEleve` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idFourni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `horaire`
--
ALTER TABLE `horaire`
  MODIFY `idHoraire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `parent`
--
ALTER TABLE `parent`
  MODIFY `idParent` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `idRdv` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `idStock` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `absence_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `absence_ibfk_2` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`idEleve`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`id_prof_principale`) REFERENCES `user` (`idUser`);

--
-- Constraints for table `demande_fournisseur`
--
ALTER TABLE `demande_fournisseur`
  ADD CONSTRAINT `demande_fournisseur_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `demande_fournisseur_ibfk_2` FOREIGN KEY (`idFourni`) REFERENCES `fournisseur` (`idFourni`),
  ADD CONSTRAINT `demande_fournisseur_ibfk_3` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`);

--
-- Constraints for table `demande_stock`
--
ALTER TABLE `demande_stock`
  ADD CONSTRAINT `demande_stock_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `demande_stock_ibfk_2` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`idStock`);

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`classe`) REFERENCES `classe` (`idClasse`);

--
-- Constraints for table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `parent_ibfk_1` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`idEleve`);

--
-- Constraints for table `profclasse`
--
ALTER TABLE `profclasse`
  ADD CONSTRAINT `profclasse_ibfk_1` FOREIGN KEY (`heureD`) REFERENCES `horaire` (`idHoraire`),
  ADD CONSTRAINT `profclasse_ibfk_2` FOREIGN KEY (`jour`) REFERENCES `semaine` (`idJour`),
  ADD CONSTRAINT `profclasse_ibfk_3` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `profclasse_ibfk_4` FOREIGN KEY (`Classe`) REFERENCES `classe` (`idClasse`),
  ADD CONSTRAINT `profclasse_ibfk_5` FOREIGN KEY (`heureF`) REFERENCES `horaire` (`idHoraire`);

--
-- Constraints for table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_ibfk_1` FOREIGN KEY (`id_prof_principale`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `rdv_ibfk_2` FOREIGN KEY (`id_parent`) REFERENCES `parent` (`idParent`),
  ADD CONSTRAINT `rdv_ibfk_3` FOREIGN KEY (`idHoraire`) REFERENCES `horaire` (`idHoraire`);

--
-- Constraints for table `retard`
--
ALTER TABLE `retard`
  ADD CONSTRAINT `retard_ibfk_1` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `retard_ibfk_2` FOREIGN KEY (`idEleve`) REFERENCES `eleve` (`idEleve`);

--
-- Constraints for table `sanction`
--
ALTER TABLE `sanction`
  ADD CONSTRAINT `sanction_ibfk_1` FOREIGN KEY (`idProf`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `sanction_ibfk_2` FOREIGN KEY (`idType`) REFERENCES `typesanction` (`idType`),
  ADD CONSTRAINT `sanction_ibfk_3` FOREIGN KEY (`idEleve`) REFERENCES `eleve` (`idEleve`);

--
-- Constraints for table `stock_fournisseur`
--
ALTER TABLE `stock_fournisseur`
  ADD CONSTRAINT `stock_fournisseur_ibfk_1` FOREIGN KEY (`idFourni`) REFERENCES `fournisseur` (`idFourni`),
  ADD CONSTRAINT `stock_fournisseur_ibfk_2` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
