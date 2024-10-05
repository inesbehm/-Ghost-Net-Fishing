-- Tabelle für Personen (meldende und bergende Personen)
CREATE TABLE person (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    telefonnummer VARCHAR(50),
    rolle VARCHAR(20) NOT NULL -- 'MELDENDE_PERSON' oder 'BERGENDE_PERSON'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabelle für Geisternetze
CREATE TABLE geisternetz (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    standort VARCHAR(255) NOT NULL,
    groesse VARCHAR(50),
    status VARCHAR(30) NOT NULL, -- 'GEMELDET', 'BERGUNG_BEVORSTEHEND', 'GEBORGEN', 'VERSCHOLLEN'
    meldende_person_id BIGINT, -- Fremdschlüssel für meldende Person (optional)
    bergende_person_id BIGINT, -- Fremdschlüssel für bergende Person (optional)
    FOREIGN KEY (meldende_person_id) REFERENCES person(id) ON DELETE SET NULL,
    FOREIGN KEY (bergende_person_id) REFERENCES person(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--Zeichensatz auf utf8mb4 setzen
ALTER DATABASE ghostnetdb CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
