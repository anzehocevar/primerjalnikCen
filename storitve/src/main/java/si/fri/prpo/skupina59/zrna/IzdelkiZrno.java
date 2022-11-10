package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.entitete.Izdelek;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class IzdelkiZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    public List<Izdelek> getIzdelki() {

        // implementacija
        Query q = em.createNamedQuery("Izdelek.getAll");
        return q.getResultList();

    }
}
