public class Geisternetz {
    private Long id;
    private String gpsKoordinaten;
    private String groesse;
    private String status;  // "Gemeldet", "Bergung bevorstehend", "Geborgen", "Verschollen"
    private Person meldendePerson;
    private Person bergendePerson;
    private String bild;


    public Geisternetz() {
	}
    
    //  Konstruktor
    public Geisternetz(String gpsKoordinaten, String groesse, String status, Person meldendePerson, Person bergendePerson, String bild) {
        this.gpsKoordinaten = gpsKoordinaten;
        this.groesse = groesse;
        this.status = status;
        this.meldendePerson = meldendePerson;
        this.bergendePerson = bergendePerson;
        this.bild = bild;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpsKoordinaten() {
        return gpsKoordinaten;
    }

    public void setGpsKoordinaten(String gpsKoordinaten) {
        this.gpsKoordinaten = gpsKoordinaten;
    }

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getMeldendePerson() {
        return meldendePerson;
    }

    public void setMeldendePerson(Person meldendePerson) {
        this.meldendePerson = meldendePerson;
    }

    public Person getBergendePerson() {
        return bergendePerson;
    }

    public void setBergendePerson(Person bergendePerson) {
        this.bergendePerson = bergendePerson;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

	public void meldeAnonym(String gpsKoordinaten2, String groesse2) {
		// TODO Auto-generated method stub
		
	}

	public void meldeDurchPerson(String gpsKoordinaten2, String groesse2, Person meldendePerson2) {
		// TODO Auto-generated method stub
		
	}
}
