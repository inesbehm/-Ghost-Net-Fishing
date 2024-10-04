-- Tabelle für Personen (meldende und bergende Personen)
CREATE TABLE Person (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Telefonnummer VARCHAR(50),
    Rolle ENUM('MELDENDE_PERSON', 'BERGENDE_PERSON') NOT NULL -- Enum für Rolle
);

-- Tabelle für Geisternetze
CREATE TABLE Geisternetz (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Standort VARCHAR(255) NOT NULL,
    Größe VARCHAR(50),
    Status ENUM('GEMELDET', 'BERGUNG_BEVORSTEHEND', 'GEBORGEN', 'VERSCHOLLEN') NOT NULL, -- Enum für Status
    MeldendePersonID INT, -- Fremdschlüssel für meldende Person (optional)
    BergendePersonID INT, -- Fremdschlüssel für bergende Person (optional)
    FOREIGN KEY (MeldendePersonID) REFERENCES Person(ID) ON DELETE SET NULL, -- Optional, da anonyme Meldung möglich
    FOREIGN KEY (BergendePersonID) REFERENCES Person(ID) ON DELETE SET NULL -- Optional, da Bergung noch ausstehen kann
);
