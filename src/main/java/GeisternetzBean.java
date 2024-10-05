import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class GeisternetzBean implements Serializable {
    private String standort;
    private double groesse;
    private String telefonnummer;

    @Inject
    private GeisternetzService geisternetzService;

    public void speichern() {
        Geisternetz geisternetz = new Geisternetz(standort, groesse, telefonnummer);
        geisternetzService.speichern(geisternetz);
    }

	public String getStandort() {
		return standort;
	}

	public void setStandort(String standort) {
		this.standort = standort;
	}

	public double getGroesse() {
		return groesse;
	}

	public void setGroesse(double groesse) {
		this.groesse = groesse;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public GeisternetzService getGeisternetzService() {
		return geisternetzService;
	}

	public void setGeisternetzService(GeisternetzService geisternetzService) {
		this.geisternetzService = geisternetzService;
	}

   
}
