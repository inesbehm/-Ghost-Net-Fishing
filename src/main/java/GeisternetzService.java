import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class GeisternetzService {

    @Inject
    private EntityManager em;

    public Geisternetz findById(Long id) {
        return em.find(Geisternetz.class, id);
    }

    public void update(Geisternetz geisternetz) {
        em.merge(geisternetz);  // Aktualisiert ein bestehendes Geisternetz
    }

    public void speichern(Geisternetz geisternetz) {
        if (geisternetz.getId() == null) {
            em.persist(geisternetz);  // Speichert ein neues Geisternetz
        } else {
            update(geisternetz);  // Aktualisiert ein bestehendes Geisternetz
        }
    }
}
