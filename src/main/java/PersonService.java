import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Stateless
public class PersonService {

    @Inject
    private EntityManager em;

    /**
     * Findet eine Person anhand von Name und Telefonnummer.
     * 
     * @param name Der Name der Person
     * @param telefonnummer Die Telefonnummer der Person
     * @return Die gefundene Person oder null, wenn keine Person gefunden wurde
     */
    public Person findByNameAndTelefonnummer(String name, String telefonnummer) {
        try {
            return em.createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.telefonnummer = :telefonnummer", Person.class)
                    .setParameter("name", name)
                    .setParameter("telefonnummer", telefonnummer)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Rückgabe von null, wenn keine Person gefunden wird
        }
    }

    /**
     * Speichert oder aktualisiert eine Person in der Datenbank.
     * 
     * @param person Die Person, die gespeichert oder aktualisiert werden soll
     */
    public void speichern(Person person) {
        if (person.getId() == null) {
            em.persist(person);  // Neue Person speichern
        } else {
            em.merge(person);  // Vorhandene Person aktualisieren
        }
    }
}
