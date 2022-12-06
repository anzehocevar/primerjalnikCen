package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Uporabnik;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UporabnikZrno {
    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(UporabnikZrno.class.getName());

    @BeleziKlice
    @PostConstruct
    private void logConstruction(){
        logger.info("UporabnikZrno je bilo ustvarjeno");
    }

    @BeleziKlice
    @PreDestroy
    private void logDestruct(){
        logger.info("UporabnikZrno je bilo uniceno");
    }

    @BeleziKlice
    public List<Uporabnik> pridobiVseUporabninke() {

        // implementacija
        Query q = em.createNamedQuery("Uporabnik.getAll");
        return q.getResultList();
    }

    @BeleziKlice
    public Uporabnik pridobiUporabnika(Integer id){
        return em.find(Uporabnik.class, id);
    }

    @BeleziKlice
    @Transactional
    public Uporabnik dodajUporabnik(Uporabnik uporabnik){
        if(uporabnik != null)
            em.persist(uporabnik);
        return uporabnik;
    }

    @BeleziKlice
    @Transactional
    public Uporabnik posodobiUporabnika(Uporabnik u){
        if(u != null)
            em.merge(u);
        return u;
    }

    @BeleziKlice
    @Transactional
    public boolean izbrisiUporabnika(Integer id){
        Uporabnik uporabnik = pridobiUporabnika(id);
        if (uporabnik != null){
            em.remove(uporabnik);
            return true;
        }
        return false;
    }


}
