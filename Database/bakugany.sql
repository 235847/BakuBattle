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
(1, 'Apophix', 1600, 0.2, 400, 'Suchy Świat', 400, 'Odgłos Aquosa', 400, 'Fala Ucisku', 300, 'Rwąca Fala', 500, 'Dominacja Aquosa', 600, 'Wysycenie', 300, 'Sztorm', 200, 'Podwodna Ruina'),
(2, 'Babadrill', 1100, 0.25, 300, 'Strzał Gwiezdnego Pyłu', 400, 'Wodna Kraina', -2, 'Podwójny Powrót', 400, 'Księżycowa Tęcza', 400, 'Skrzydło Mercurego', 300, 'Delta Snieg Morski', 500, 'Zagluszanie', 700, 'Niebieska tarcza'),
(3, 'Serpillious', 1500, 0.29, 700, 'Postrach Oceanu', 400, 'Lustrzane Kopie', 300, 'Rozszczepiająca Toksyna', 400, 'Słuszny Pośpiech', 500, 'Metalowa Armia Śmierci', 300, 'Metalowy Pazur', 300, 'Rybie Kleszcze', 200, 'Wodniste Pnącza'),
(4, 'Centipod', 1300, 0.25, 500, 'Prysznic kwasu', 600, 'Śmiertelny przypływ', 400, 'Merfolk', 300, 'Mega Loscania', 500, 'Megalo Bariera', 300, 'Trująca Rozkosz', 600, 'Chitynowa Tama', 200, 'Wątłość Węgorza'),
(5, 'Cycloid', 1500, 0.18, 600, 'Trujący Bicz', 500, 'Żmija Gorhony', 300, 'Atak Łowcy', 200, 'Trucizna', 400, 'Kula Plazmy', 500, 'Prymat Węża', 300, 'Trój żmija', 100, 'Ukryty Pazur'),
(6, 'Gillator', 1400, 0.3, 300, 'Strumień Strachu', 200, 'Agenda Wiru', 700, 'Metalowy Gniew', 500, 'Mina Aquosa', 400, 'Cyklon Głębin', 700, 'Inpuls Nacisku', 200, 'Wodny Bunkier', 400, 'Osłona cyklonu'),
(7, 'Dragonoid', 1800, 0.3, 400, 'Czarownik Mocy', 700, 'Ostatni Czarownik', 500, 'Młot Mgławicy', 300, 'Czarodziej Grawitonu', 600, 'Potęga Darkusa', 300, 'Anarchia Ciemności', 100, 'Zwątpienie', 100, 'Zasłona Mroku'),
(8, 'Gillator', 1500, 0.28, 400, 'Strumień Strachu', 300, 'Agenda Wiru', 700, 'Metalowy Gniew', 500, 'Mina Darkusa', 400, 'Cyklon Głębin', 500, 'Inpuls Nacisku', 300, 'Mroczny Bunkier', 200, 'Osłona Ciemności'),
(9, 'Howlkor', 1300, 0.24, 400, 'Krzyk Kwazaru', 200, 'Miotacz', 700, 'Kwazar Zniszczenia', 300, 'Działo Ragnaroka', -2, 'Farbas Nieskończoności', 200, 'Wielki Wojownik', 100, 'Miotacz 2.0', 300, 'Blok Ostrzału'),
(10, 'Nillious', 1700, 0.21, 700, 'Zament Darkusa', 300, 'Poziom Zero', 300, 'Wyssanie Mocy', 400, 'Promień Mocy', 500, 'Cisza Grozy', 600, 'Burza Darkusa', 100, 'Cichy Mrok', 200, 'Tarcza Kosmosu'),
(11, 'Sairus', 1400, 0.16, 600, 'Atak Światła Chaosu', 400, 'Trójząb Zniszczenia', 300, 'Siła Zniszczenia', -2, 'Trójząb Żaru', 400, 'Ekstremalny Błysk', 300, 'Trójząb Zagłady', 300, 'Koszmar Indygo', 100, 'Mroczna Blokada'),
(12, 'Viloch', 1800, 0.32, 200, 'Fala Exodusu', 300, 'Podmuch Zła', 800, 'Szczytowa Fala', 600, 'Otchłań Ciemności', 800, 'Sonda Ognia', 400, 'Błysk Ciemności', 100, 'Osłona Ciemności', 100, 'Mroczny Jeździec'),
(13, 'Hydranoid', 1300, 0.23, 300, 'Szaleństwo Mirażu', 200, 'Duo Komandos', 500, 'Dysza Mirażu', 200, 'Cios Aurory', 600, 'Złudzenie', 400, 'Aleja Pięści', 400, 'Pięść Valkyrii', 400, 'Światło Wsparcia'),
(14, 'Mantonoid', 1200, 0.28, 500, 'Magiczny Maniatus', 400, 'Pierścienie Magii', 200, 'Klatka Duchów', -2, 'Kosa Haosu', 200, 'Bariera Moczarów', 400, 'Wymiar Aurory', 100, 'Ryk Mocy Haosu', 300, 'Łzy Haosu'),
(15, 'Mutasect', 1500, 0.16, 500, 'Miecz Arkadii', 300, 'Kieł Mocy', 500, 'Spiralne Ostrze', 200, 'Złudzenie Ostrza', 200, 'Skowyt Wilka', 400, 'Kieł Skolla', 200, 'Wierzchołek Błysku', 100, 'Tarcza Garma'),
(16, 'Nobilious', 1800, 0.25, 200, 'Spirala Hyentu', 200, 'Wichrowa Burza', 600, 'Niebiański Podmuch', 100, 'Fala Światłości', 700, 'Zew Wolności', 300, 'Światłość', 500, 'Cyklon Jasności', 400, 'Podniebna Tarcza'),
(17, 'Phaedrus', 1500, 0.31, 300, 'Prędkość Kła', 200, 'Elektryczny Kieł', 500, 'Błysk Szabli', 400, 'Metalowy Kieł', 300, 'Tornado Światła', 400, 'Hiper Prędkość Kła', 400, 'Oblicze Haosu', 400, 'Tarcza Błyskawic'),
(18, 'Sairus', 1600, 0.22, 400, 'Flanka Goliata', 200, 'Armata Urazy', 600, 'Flanka Fausta', 200, 'Zmiana Torsena', 600, 'Wzmocnienie Haosu', 500, 'Anarchia', 100, 'Tarcza Mocy', 100, 'Promienie Pomocy'),
(19, 'Dragonoid', 1700, 0.32, 400, 'Czarownik Mocy', 700, 'Ostatni Czarownik', 200, 'Młot Mgławicy', 300, 'Czarodziej Grawitonu', 600, 'Potęga Pyrusa', 100, 'Anarchia Płomieni', 0, 'Zwątpienie', 100, 'Zasłona Ognia'),
(20, 'Fangzor', 1400, 0.24, 500, 'Maksymalny Pyrus', 500, 'Neo Value', 200, 'Redukcja Saiam', 200, 'Siła Rozproszenia', -2, 'Duma Węża', 600, 'Eksplozja Nieskończoności', 500, 'Maksymalna Rewolucja', 100, 'Węża Skóra'),
(21, 'Garganoid', 1300, 0.19, 200, 'Kapelusz Hammera', 100, 'Wojownik Karli', 200, 'Armia Metalu', 400, 'Skrętocios', 600, 'Podwójny Pazur', 700, 'Dominacja Pyrusa', 300, 'Pazur Ognia', 200, 'Ognista Zasłona'),
(22, 'Serpenteze', 1600, 0.23, 300, 'Kieł Korundu', 500, 'Inwazja ', 500, 'Pole Złudzenia', 500, 'Rubinowy Zabójca', 400, 'Szkarłatna Tafla', 600, 'Czerwona Głębina', 100, 'Smocza Jaskinia', 200, 'Szkarłatna Obrona'),
(23, 'Viperagon', 1400, 0.3, 200, 'Pojedynczy Smok', 100, 'Podwójny Smok', 500, 'Rdzeń Elementu', 300, 'Skuteczny Podział', 400, 'Płomienna Otchłań', 200, 'Smocza Pycha', 500, 'Wsparcie Pyrusa', 500, 'Osłona Pożogi'),
(24, 'Hydranoid', 1600, 0.28, 300, 'Szaleństwo Mirażu', 400, 'Duo Komandos', 500, 'Dysza Mirażu', 200, 'Żarzący Cios', 300, 'Złudzenie', 400, 'Aleja Pięści', 200, 'Pięść Valkyrii', 400, 'Znak Wsparcia'),
(25, 'Auxillataur', 1700, 0.29, 400, 'Wielki Herkules', 200, 'Okrzyk Bitewny', 700, 'Elektryczny Łańcuch', 500, 'Działo Ifryta', 600, 'Elektryczny Szok', 200, 'Aleja Pięści', 200, 'Pancerna Skorupa', 100, 'Znak Wsparcia'),
(26, 'Mantanoid', 1300, 0.22, 100, 'Magiczny Maniatus', 300, 'Pierścienie Magii', 200, 'Klatka Duchów', -2, 'Kosa Subterry', 500, 'Bariera Moczarów', 400, 'Wymiar Aurory', 100, 'Ryk Mocy Subterry', 300, 'Łzy Gai'),
(27, 'Nillious', 1600, 0.24, 600, 'Zament', 300, 'Poziom Zero', 300, 'Wyssanie Mocy', 400, 'Promień Mocy', 500, 'Cisza Grozy', 600, 'Burza Gai', 400, 'Cichy Mrok', 200, 'Tarcza Kosmosu'),
(28, 'Phaedrus', 1600, 0.21, 300, 'Prędkość Kła', 200, 'Elektryczny Kieł', 500, 'Błysk Szabli', 400, 'Metalowy Kieł', 500, 'Tornado Światła', 400, 'Hiper Prędkość Kła', 400, 'Oblicze Subterry', 400, 'Tarcza Błyskawic'),
(29, 'Pincitaur', 1200, 0.15, 300, 'Wybuch Atomowej Ziemi', -2, 'Ziemskie Oblicze', 400, 'Granat Mocy', 300, 'Przedwczesny Wybuch', 200, 'Podziemny Wybuch', 400, 'Ziemny Rewolwer', 300, 'Moc Granitu', 100, 'Wsparcie Subterry'),
(30, 'Skorporos', 1400, 0.27, 400, 'Wibrowiatr', 300, 'Tytanowa Pięść', 500, 'Uderzenie świdra', 600, 'Żądło Śmierci', 300, 'Hiper Zderzenie', 200, 'Ożywienie', 200, 'Wielka Egida', 100, 'Więzienie Subterry'),
(31, 'Auxillataur', 1600, 0.32, 400, 'Wielki Herkules', 300, 'Okrzyk Bitewny', 600, 'Elektryczny Łańcuch', 500, 'Działo Ifryta', 600, 'Elektryczny Szok', 400, 'Pancerna Skorupa', 200, 'Zbroja Ofensywy', 400, 'Skowyt Wiatru'),
(32, 'Serpillious', 1600, 0.23, 700, 'Postrach Wiatru', 400, 'Lustrzane Kopie', 300, 'Rozszczepiająca Toksyna', 400, 'Słuszny Pośpiech', 500, 'Metalowa Armia Śmierci', 400, 'Metalowy Pazur', 300, 'Kleszcze Ventusa', 200, 'Piorunujące Pnącza'),
(33, 'Viperagon', 1500, 0.21, 200, 'Pojedynczy Smok', 100, 'Podwójny Smok', 500, 'Rdzeń Elementu', 300, 'Skuteczny Podział', 400, 'Płomienna Otchłań', 500, 'Smocza Pycha', 500, 'Wsparcie Ventusa', 300, 'Osłona Pożogi'),
(34, 'Viloch', 1700, 0.26, 300, 'Fala Exodusu', 300, 'Podmuch Zła', 700, 'Szczytowa Fala', 500, 'Otchłań Ventusa', 800, 'Sonda Ognia', 400, 'Błysk Zniszczenia', 200, 'Osłona Ventusa', 300, 'Burzowy Jeździec'),
(35, 'Viloch', 1600, 0.17, 200, 'Błysk Pioruna', 300, 'Ogień  Piorunów', 400, 'Wirujący Spodek', 600, 'Działo Szoku', 700, 'Błysk Ognia', 400, 'Blask Pioruna', 300, 'Mega Tarcza', 100, 'Detonator Pioruna'),
(36, 'Webam', 1400, 0.21, 400, 'Wiedza Feniksa', 500, 'Uderzenie Pioruna', 300, 'Zdmuchnięcie', 300, 'Niszczący Deszcz Meteorów', -2, 'Wiatr Wściekłośći', 500, 'Destrukcyjny Delta Deszcz', 400, 'Wściekła Burza', 300, 'Vivat Ventusa');

--
-- Indeksy dla zrzutów tabel
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
