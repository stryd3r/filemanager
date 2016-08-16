-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-08-15 16:17:44.021

-- tables
-- Table: calendar
CREATE TABLE calendar (
    id int NOT NULL,
    id_doctor int NOT NULL,
    CONSTRAINT calendar_pk PRIMARY KEY (id)
) ENGINE InnoDB;

-- Table: chestionare
CREATE TABLE chestionare (
    id int NOT NULL,
    id_intrebare int NOT NULL,
    intrebare varchar(300) NOT NULL,
    CONSTRAINT chestionare_pk PRIMARY KEY (id,id_intrebare)
) ENGINE InnoDB;

-- Table: consultatii
CREATE TABLE consultatii (
    id int NOT NULL,
    id_pacient int NOT NULL,
    id_doctor int NOT NULL,
    diagnostic varchar(300) NULL,
    observatii varchar(500) NULL,
    pret varchar(100) NULL,
    CONSTRAINT consultatii_pk PRIMARY KEY (id,id_pacient,id_doctor)
) ENGINE InnoDB;

-- Table: detalii_pacient
CREATE TABLE detalii_pacient (
    id_pacient int NOT NULL,
    adresa varchar(300) NOT NULL,
    CONSTRAINT detalii_pacient_pk PRIMARY KEY (id_pacient)
) ENGINE InnoDB;

-- Table: doctori
CREATE TABLE doctori (
    id int NOT NULL,
    username varchar(100) NOT NULL,
    parola varchar(50) NOT NULL,
    CONSTRAINT doctori_pk PRIMARY KEY (id)
) ENGINE InnoDB;

-- Table: events
CREATE TABLE events (
    id int NOT NULL,
    calendar_id int NOT NULL,
    observatie varchar(300) NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    all_day bool NOT NULL,
    CONSTRAINT events_pk PRIMARY KEY (id)
) ENGINE InnoDB;

-- Table: pacienti
CREATE TABLE pacienti (
    id int NOT NULL,
    nume varchar(20) NOT NULL,
    prenume varchar(20) NOT NULL,
    CONSTRAINT pacienti_pk PRIMARY KEY (id)
) ENGINE InnoDB;

-- Table: raspuns_chestionar
CREATE TABLE raspuns_chestionar (
    id_pacient int NOT NULL,
    id_chestionar int NOT NULL,
    id_intrebare int NOT NULL,
    raspuns int NULL,
    CONSTRAINT raspuns_chestionar_pk PRIMARY KEY (id_pacient,id_chestionar,id_intrebare)
) ENGINE InnoDB;

-- foreign keys
-- Reference: Calendar_utilizatori (table: calendar)
ALTER TABLE calendar ADD CONSTRAINT Calendar_utilizatori FOREIGN KEY Calendar_utilizatori (id_doctor)
    REFERENCES doctori (id);

-- Reference: Events_Calendar (table: events)
ALTER TABLE events ADD CONSTRAINT Events_Calendar FOREIGN KEY Events_Calendar (calendar_id)
    REFERENCES calendar (id);

-- Reference: Vizite_clienti (table: consultatii)
ALTER TABLE consultatii ADD CONSTRAINT Vizite_clienti FOREIGN KEY Vizite_clienti (id_pacient)
    REFERENCES pacienti (id);

-- Reference: detalii_client_clienti (table: detalii_pacient)
ALTER TABLE detalii_pacient ADD CONSTRAINT detalii_client_clienti FOREIGN KEY detalii_client_clienti (id_pacient)
    REFERENCES pacienti (id);

-- Reference: doctori_Vizite (table: consultatii)
ALTER TABLE consultatii ADD CONSTRAINT doctori_Vizite FOREIGN KEY doctori_Vizite (id_doctor)
    REFERENCES doctori (id);

-- Reference: raspuns_chestionar_chestionare (table: raspuns_chestionar)
ALTER TABLE raspuns_chestionar ADD CONSTRAINT raspuns_chestionar_chestionare FOREIGN KEY raspuns_chestionar_chestionare (id_chestionar,id_intrebare)
    REFERENCES chestionare (id,id_intrebare);

-- Reference: raspuns_chestionar_clienti (table: raspuns_chestionar)
ALTER TABLE raspuns_chestionar ADD CONSTRAINT raspuns_chestionar_clienti FOREIGN KEY raspuns_chestionar_clienti (id_pacient)
    REFERENCES pacienti (id);

-- End of file.

