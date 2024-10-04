import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class GeisternetzController {

    @PersistenceContext
    private EntityManager em;

    // Felder für Formular-Eingaben
    private String gpsKoordinaten;
    private String groesse;
    private boolean anonym; // Ob die Meldung anonym ist
    private String telefonnummer;
    private Person meldendePerson;

    // Listen für Status und Personen
    private List<String> statusListe;
    private List<Person> personenListe;

    // Aktuelle Geisternetz-Entität (für Bearbeitung)
    private Geisternetz geisternetz;
    private List<Geisternetz> geisternetzListe;
    private int index;  // Für die Navigation in der Geisternetz-Liste

    @PostConstruct
    public void init() {
        // Initialisiere die Status-Liste
        statusListe = Arrays.asList("Gemeldet", "Bergung bevorstehend", "Geborgen", "Verschollen");

        // Initialisiere die Personen-Liste mit Beispieldaten
        personenListe = Arrays.asList(
            new Person("Max Mustermann", "01234-56789"),
            new Person("Erika Musterfrau", "98765-43210")
        );

        // Beispiel-Daten für Geisternetze
        geisternetzListe = Arrays.asList(
            new Geisternetz("48.123, 11.456", "Groß", "Gemeldet", null, null, null),
            new Geisternetz("47.789, 10.123", "Mittel", "Bergung bevorstehend", personenListe.get(0), null, null)
        );

        // Standardmäßiges Geisternetz initialisieren
        geisternetz = geisternetzListe.get(0);
        index = 0;
    }

    // Getter und Setter für die Formularfelder
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

    public boolean isAnonym() {
        return anonym;
    }

    public void setAnonym(boolean anonym) {
        this.anonym = anonym;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Person getMeldendePerson() {
        return meldendePerson;
    }

    public void setMeldendePerson(Person meldendePerson) {
        this.meldendePerson = meldendePerson;
    }

    public Geisternetz getGeisternetz() {
        return geisternetz;
    }

    public void setGeisternetz(Geisternetz geisternetz) {
        this.geisternetz = geisternetz;
    }

    public List<Geisternetz> getGeisternetzListe() {
        return geisternetzListe;
    }

    public List<String> getStatusListe() {
        return statusListe;
    }

    public void setStatusListe(List<String> statusListe) {
        this.statusListe = statusListe;
    }

    public List<Person> getPersonenListe() {
        return personenListe;
    }

    public void setPersonenListe(List<Person> personenListe) {
        this.personenListe = personenListe;
    }

    // Methode zum Speichern eines Geisternetzes
    public void speichern() {
        Geisternetz netz = new Geisternetz();
        netz.setGpsKoordinaten(gpsKoordinaten);
        netz.setGroesse(groesse);

        if (anonym) {
            // Anonyme Meldung (setzt die meldende Person auf null)
            netz.meldeAnonym(gpsKoordinaten, groesse);
        } else {
            // Nicht-anonyme Meldung (Person wird benötigt)
            if (meldendePerson == null) {
                meldendePerson = new Person("Anonyme Person", telefonnummer);
            }
            netz.meldeDurchPerson(gpsKoordinaten, groesse, meldendePerson);
        }

        // Speichere das Geisternetz (wenn EntityManager konfiguriert ist)
        if (em != null) {
            em.persist(netz);
        }

        // Aktualisiere die Liste (für Demonstrationszwecke)
        geisternetzListe.add(netz);
    }

    // Navigation nach dem Speichern
    public String speichernNavigation() {
        try {
            speichern();
            return "erfolg";  // Navigiert zu "erfolg.xhtml"
        } catch (Exception e) {
            e.printStackTrace();
            return "fehler";  // Navigiert zu "fehler.xhtml" im Fehlerfall
        }
    }

    // Navigation (vor/zurück)
    public void vor() {
        if (index < geisternetzListe.size() - 1) {
            index++;
            geisternetz = geisternetzListe.get(index);
        }
    }

    public void zurueck() {
        if (index > 0) {
            index--;
            geisternetz = geisternetzListe.get(index);
        }
    }
}
