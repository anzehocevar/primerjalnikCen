package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.entitete.Izdelek;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<Izdelek> getIzdelkiCriteriaAPI() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Izdelek> q = cb.createQuery(Izdelek.class);
        Root<Izdelek> root = q.from(Izdelek.class);
        q.select(root);

        Query query = em.createQuery(q);
        return query.getResultList();
    }
}
