import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "geisternetz")
public class Geisternetz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String standort;

    private String groesse;

    private String status;

    @ManyToOne
    @JoinColumn(name = "meldende_person_id")
    private Person meldendePerson;

    @ManyToOne
    @JoinColumn(name = "bergende_person_id")
    private Person bergendePerson;

    @Inject
    private GeisternetzService geisternetzService;

    @Inject
    private PersonService personService;

	private String gpsKoordinaten;

	private String bild;

	private String name;

	private String telefonnummer;

    // Standardkonstruktor
    public Geisternetz() {}

    // Konstruktor
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

	public String getName() {
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefonnummer() {
		return getTelefonnummer();
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
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

	public String getBild() {
		return bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
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

	public GeisternetzService getGeisternetzService() {
		return geisternetzService;
	}

	public void setGeisternetzService(GeisternetzService geisternetzService) {
		this.geisternetzService = geisternetzService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void zuordnen() {
        Person bergendePerson = personService.findByNameAndTelefonnummer(name, telefonnummer);
        Geisternetz geisternetz = geisternetzService.findById(id);

        if (geisternetz.getBergendePerson() == null) {
            geisternetz.setBergendePerson(bergendePerson);
            geisternetzService.update(geisternetz);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dieses Netz wird bereits geborgen."));
        }
    }

	public String getStandort() {
		return standort;
	}

	public void setStandort(String standort) {
		this.standort = standort;
	}

	public void meldeAnonym(String gpsKoordinaten2, String groesse2) {
		// TODO Auto-generated method stub
		
	}

	public void meldeDurchPerson(String gpsKoordinaten2, String groesse2, Person meldendePerson2) {
		// TODO Auto-generated method stub
		
	}
    
}
