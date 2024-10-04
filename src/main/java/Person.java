public class Person {
    private String name;
    private String telefonnummer;

    // Konstruktor
    public Person(String name, String telefonnummer) {
        this.name = name;
        this.telefonnummer = telefonnummer;
    }

    // Getter und Setter

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
}
