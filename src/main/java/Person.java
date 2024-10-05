import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String telefonnummer;

    public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String rolle;

    // Konstruktor
    public Person(String name, String telefonnummer) {
        this.name = name;
        this.telefonnummer = telefonnummer;
    }

    @OneToMany(mappedBy = "bergendePerson")
    private List<Geisternetz> geisternetze;

    public List<Geisternetz> getGeisternetze() {
		return geisternetze;
	}

	public void setGeisternetze(List<Geisternetz> geisternetze) {
		this.geisternetze = geisternetze;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

	public Object getId() {
		return null;
	}
}
