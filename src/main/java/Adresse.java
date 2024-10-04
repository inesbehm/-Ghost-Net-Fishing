import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Adresse {

    private String name;
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;

    // Konstruktor
    public Adresse() {
        this.name = "Shea Sepherd";
        this.strasse = "Panoramastraße";
        this.hausnummer = "1";
        this.plz = "12345";
        this.ort = "Berlin";
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
