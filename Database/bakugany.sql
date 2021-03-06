-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Maj 2022, 16:21
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bakugan`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bakugany`
--

CREATE TABLE `bakugany` (
  `bakuID` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `xp` double DEFAULT NULL,
  `transferSingle` int(11) DEFAULT NULL,
  `transferSingleName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `transferArea` int(11) DEFAULT NULL,
  `transferAreaName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `attackSingle` int(11) DEFAULT NULL,
  `attackSingleName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `attackArea` int(11) DEFAULT NULL,
  `attackAreaName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `hpBoostv1` int(11) DEFAULT NULL,
  `hpBoostv1Name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `hpBoostv2` int(11) DEFAULT NULL,
  `hpBoostv2Name` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `blockHealFriend` int(11) DEFAULT NULL,
  `blockHealFriendName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `blockHealTeam` int(11) DEFAULT NULL,
  `blockHealTeamName` varchar(100) COLLATE utf8mb4_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `bakugany`
--

INSERT INTO `bakugany` (`bakuID`, `name`, `hp`, `xp`, `transferSingle`, `transferSingleName`, `transferArea`, `transferAreaName`, `attackSingle`, `attackSingleName`, `attackArea`, `attackAreaName`, `hpBoostv1`, `hpBoostv1Name`, `hpBoostv2`, `hpBoostv2Name`, `blockHealFriend`, `blockHealFriendName`, `blockHealTeam`, `blockHealTeamName`) VALUES
(1, 'Apophix', 1600, 0.2, 400, 'Suchy ??wiat', 400, 'Odg??os Aquosa', 400, 'Fala Ucisku', 300, 'Rw??ca Fala', 500, 'Dominacja Aquosa', 600, 'Wysycenie', 300, 'Sztorm', 200, 'Podwodna Ruina'),
(2, 'Babadrill', 1100, 0.25, 300, 'Strza?? Gwiezdnego Py??u', 400, 'Wodna Kraina', -2, 'Podw??jny Powr??t', 400, 'Ksi????ycowa T??cza', 400, 'Skrzyd??o Mercurego', 300, 'Delta Snieg Morski', 500, 'Zagluszanie', 700, 'Niebieska tarcza'),
(3, 'Serpillious', 1500, 0.29, 700, 'Postrach Oceanu', 400, 'Lustrzane Kopie', 300, 'Rozszczepiaj??ca Toksyna', 400, 'S??uszny Po??piech', 500, 'Metalowa Armia ??mierci', 300, 'Metalowy Pazur', 300, 'Rybie Kleszcze', 200, 'Wodniste Pn??cza'),
(4, 'Centipod', 1300, 0.25, 500, 'Prysznic kwasu', 600, '??miertelny przyp??yw', 400, 'Merfolk', 300, 'Mega Loscania', 500, 'Megalo Bariera', 300, 'Truj??ca Rozkosz', 600, 'Chitynowa Tama', 200, 'W??t??o???? W??gorza'),
(5, 'Cycloid', 1500, 0.18, 600, 'Truj??cy Bicz', 500, '??mija Gorhony', 300, 'Atak ??owcy', 200, 'Trucizna', 400, 'Kula Plazmy', 500, 'Prymat W????a', 300, 'Tr??j ??mija', 100, 'Ukryty Pazur'),
(6, 'Gillator', 1400, 0.3, 300, 'Strumie?? Strachu', 200, 'Agenda Wiru', 700, 'Metalowy Gniew', 500, 'Mina Aquosa', 400, 'Cyklon G????bin', 700, 'Inpuls Nacisku', 200, 'Wodny Bunkier', 400, 'Os??ona cyklonu'),
(7, 'Dragonoid', 1800, 0.3, 400, 'Czarownik Mocy', 700, 'Ostatni Czarownik', 500, 'M??ot Mg??awicy', 300, 'Czarodziej Grawitonu', 600, 'Pot??ga Darkusa', 300, 'Anarchia Ciemno??ci', 100, 'Zw??tpienie', 100, 'Zas??ona Mroku'),
(8, 'Gillator', 1500, 0.28, 400, 'Strumie?? Strachu', 300, 'Agenda Wiru', 700, 'Metalowy Gniew', 500, 'Mina Darkusa', 400, 'Cyklon G????bin', 500, 'Inpuls Nacisku', 300, 'Mroczny Bunkier', 200, 'Os??ona Ciemno??ci'),
(9, 'Howlkor', 1300, 0.24, 400, 'Krzyk Kwazaru', 200, 'Miotacz', 700, 'Kwazar Zniszczenia', 300, 'Dzia??o Ragnaroka', -2, 'Farbas Niesko??czono??ci', 200, 'Wielki Wojownik', 100, 'Miotacz 2.0', 300, 'Blok Ostrza??u'),
(10, 'Nillious', 1700, 0.21, 700, 'Zament Darkusa', 300, 'Poziom Zero', 300, 'Wyssanie Mocy', 400, 'Promie?? Mocy', 500, 'Cisza Grozy', 600, 'Burza Darkusa', 100, 'Cichy Mrok', 200, 'Tarcza Kosmosu'),
(11, 'Sairus', 1400, 0.16, 600, 'Atak ??wiat??a Chaosu', 400, 'Tr??jz??b Zniszczenia', 300, 'Si??a Zniszczenia', -2, 'Tr??jz??b ??aru', 400, 'Ekstremalny B??ysk', 300, 'Tr??jz??b Zag??ady', 300, 'Koszmar Indygo', 100, 'Mroczna Blokada'),
(12, 'Viloch', 1800, 0.32, 200, 'Fala Exodusu', 300, 'Podmuch Z??a', 800, 'Szczytowa Fala', 600, 'Otch??a?? Ciemno??ci', 800, 'Sonda Ognia', 400, 'B??ysk Ciemno??ci', 100, 'Os??ona Ciemno??ci', 100, 'Mroczny Je??dziec'),
(13, 'Hydranoid', 1300, 0.23, 300, 'Szale??stwo Mira??u', 200, 'Duo Komandos', 500, 'Dysza Mira??u', 200, 'Cios Aurory', 600, 'Z??udzenie', 400, 'Aleja Pi????ci', 400, 'Pi?????? Valkyrii', 400, '??wiat??o Wsparcia'),
(14, 'Mantonoid', 1200, 0.28, 500, 'Magiczny Maniatus', 400, 'Pier??cienie Magii', 200, 'Klatka Duch??w', -2, 'Kosa Haosu', 200, 'Bariera Moczar??w', 400, 'Wymiar Aurory', 100, 'Ryk Mocy Haosu', 300, '??zy Haosu'),
(15, 'Mutasect', 1500, 0.16, 500, 'Miecz Arkadii', 300, 'Kie?? Mocy', 500, 'Spiralne Ostrze', 200, 'Z??udzenie Ostrza', 200, 'Skowyt Wilka', 400, 'Kie?? Skolla', 200, 'Wierzcho??ek B??ysku', 100, 'Tarcza Garma'),
(16, 'Nobilious', 1800, 0.25, 200, 'Spirala Hyentu', 200, 'Wichrowa Burza', 600, 'Niebia??ski Podmuch', 100, 'Fala ??wiat??o??ci', 700, 'Zew Wolno??ci', 300, '??wiat??o????', 500, 'Cyklon Jasno??ci', 400, 'Podniebna Tarcza'),
(17, 'Phaedrus', 1500, 0.31, 300, 'Pr??dko???? K??a', 200, 'Elektryczny Kie??', 500, 'B??ysk Szabli', 400, 'Metalowy Kie??', 300, 'Tornado ??wiat??a', 400, 'Hiper Pr??dko???? K??a', 400, 'Oblicze Haosu', 400, 'Tarcza B??yskawic'),
(18, 'Sairus', 1600, 0.22, 400, 'Flanka Goliata', 200, 'Armata Urazy', 600, 'Flanka Fausta', 200, 'Zmiana Torsena', 600, 'Wzmocnienie Haosu', 500, 'Anarchia', 100, 'Tarcza Mocy', 100, 'Promienie Pomocy'),
(19, 'Dragonoid', 1700, 0.32, 400, 'Czarownik Mocy', 700, 'Ostatni Czarownik', 200, 'M??ot Mg??awicy', 300, 'Czarodziej Grawitonu', 600, 'Pot??ga Pyrusa', 100, 'Anarchia P??omieni', 0, 'Zw??tpienie', 100, 'Zas??ona Ognia'),
(20, 'Fangzor', 1400, 0.24, 500, 'Maksymalny Pyrus', 500, 'Neo Value', 200, 'Redukcja Saiam', 200, 'Si??a Rozproszenia', -2, 'Duma W????a', 600, 'Eksplozja Niesko??czono??ci', 500, 'Maksymalna Rewolucja', 100, 'W????a Sk??ra'),
(21, 'Garganoid', 1300, 0.19, 200, 'Kapelusz Hammera', 100, 'Wojownik Karli', 200, 'Armia Metalu', 400, 'Skr??tocios', 600, 'Podw??jny Pazur', 700, 'Dominacja Pyrusa', 300, 'Pazur Ognia', 200, 'Ognista Zas??ona'),
(22, 'Serpenteze', 1600, 0.23, 300, 'Kie?? Korundu', 500, 'Inwazja ', 500, 'Pole Z??udzenia', 500, 'Rubinowy Zab??jca', 400, 'Szkar??atna Tafla', 600, 'Czerwona G????bina', 100, 'Smocza Jaskinia', 200, 'Szkar??atna Obrona'),
(23, 'Viperagon', 1400, 0.3, 200, 'Pojedynczy Smok', 100, 'Podw??jny Smok', 500, 'Rdze?? Elementu', 300, 'Skuteczny Podzia??', 400, 'P??omienna Otch??a??', 200, 'Smocza Pycha', 500, 'Wsparcie Pyrusa', 500, 'Os??ona Po??ogi'),
(24, 'Hydranoid', 1600, 0.28, 300, 'Szale??stwo Mira??u', 400, 'Duo Komandos', 500, 'Dysza Mira??u', 200, '??arz??cy Cios', 300, 'Z??udzenie', 400, 'Aleja Pi????ci', 200, 'Pi?????? Valkyrii', 400, 'Znak Wsparcia'),
(25, 'Auxillataur', 1700, 0.29, 400, 'Wielki Herkules', 200, 'Okrzyk Bitewny', 700, 'Elektryczny ??a??cuch', 500, 'Dzia??o Ifryta', 600, 'Elektryczny Szok', 200, 'Aleja Pi????ci', 200, 'Pancerna Skorupa', 100, 'Znak Wsparcia'),
(26, 'Mantanoid', 1300, 0.22, 100, 'Magiczny Maniatus', 300, 'Pier??cienie Magii', 200, 'Klatka Duch??w', -2, 'Kosa Subterry', 500, 'Bariera Moczar??w', 400, 'Wymiar Aurory', 100, 'Ryk Mocy Subterry', 300, '??zy Gai'),
(27, 'Nillious', 1600, 0.24, 600, 'Zament', 300, 'Poziom Zero', 300, 'Wyssanie Mocy', 400, 'Promie?? Mocy', 500, 'Cisza Grozy', 600, 'Burza Gai', 400, 'Cichy Mrok', 200, 'Tarcza Kosmosu'),
(28, 'Phaedrus', 1600, 0.21, 300, 'Pr??dko???? K??a', 200, 'Elektryczny Kie??', 500, 'B??ysk Szabli', 400, 'Metalowy Kie??', 500, 'Tornado ??wiat??a', 400, 'Hiper Pr??dko???? K??a', 400, 'Oblicze Subterry', 400, 'Tarcza B??yskawic'),
(29, 'Pincitaur', 1200, 0.15, 300, 'Wybuch Atomowej Ziemi', -2, 'Ziemskie Oblicze', 400, 'Granat Mocy', 300, 'Przedwczesny Wybuch', 200, 'Podziemny Wybuch', 400, 'Ziemny Rewolwer', 300, 'Moc Granitu', 100, 'Wsparcie Subterry'),
(30, 'Skorporos', 1400, 0.27, 400, 'Wibrowiatr', 300, 'Tytanowa Pi??????', 500, 'Uderzenie ??widra', 600, '????d??o ??mierci', 300, 'Hiper Zderzenie', 200, 'O??ywienie', 200, 'Wielka Egida', 100, 'Wi??zienie Subterry'),
(31, 'Auxillataur', 1600, 0.32, 400, 'Wielki Herkules', 300, 'Okrzyk Bitewny', 600, 'Elektryczny ??a??cuch', 500, 'Dzia??o Ifryta', 600, 'Elektryczny Szok', 400, 'Pancerna Skorupa', 200, 'Zbroja Ofensywy', 400, 'Skowyt Wiatru'),
(32, 'Serpillious', 1600, 0.23, 700, 'Postrach Wiatru', 400, 'Lustrzane Kopie', 300, 'Rozszczepiaj??ca Toksyna', 400, 'S??uszny Po??piech', 500, 'Metalowa Armia ??mierci', 400, 'Metalowy Pazur', 300, 'Kleszcze Ventusa', 200, 'Piorunuj??ce Pn??cza'),
(33, 'Viperagon', 1500, 0.21, 200, 'Pojedynczy Smok', 100, 'Podw??jny Smok', 500, 'Rdze?? Elementu', 300, 'Skuteczny Podzia??', 400, 'P??omienna Otch??a??', 500, 'Smocza Pycha', 500, 'Wsparcie Ventusa', 300, 'Os??ona Po??ogi'),
(34, 'Viloch', 1700, 0.26, 300, 'Fala Exodusu', 300, 'Podmuch Z??a', 700, 'Szczytowa Fala', 500, 'Otch??a?? Ventusa', 800, 'Sonda Ognia', 400, 'B??ysk Zniszczenia', 200, 'Os??ona Ventusa', 300, 'Burzowy Je??dziec'),
(35, 'Viloch', 1600, 0.17, 200, 'B??ysk Pioruna', 300, 'Ogie??  Piorun??w', 400, 'Wiruj??cy Spodek', 600, 'Dzia??o Szoku', 700, 'B??ysk Ognia', 400, 'Blask Pioruna', 300, 'Mega Tarcza', 100, 'Detonator Pioruna'),
(36, 'Webam', 1400, 0.21, 400, 'Wiedza Feniksa', 500, 'Uderzenie Pioruna', 300, 'Zdmuchni??cie', 300, 'Niszcz??cy Deszcz Meteor??w', -2, 'Wiatr W??ciek??o????i', 500, 'Destrukcyjny Delta Deszcz', 400, 'W??ciek??a Burza', 300, 'Vivat Ventusa');

--
-- Indeksy dla zrzut??w tabel
--

--
-- Indeksy dla tabeli `bakugany`
--
ALTER TABLE `bakugany`
  ADD PRIMARY KEY (`bakuID`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `bakugany`
--
ALTER TABLE `bakugany`
  MODIFY `bakuID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
