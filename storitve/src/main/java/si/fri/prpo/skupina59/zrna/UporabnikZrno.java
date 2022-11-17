package si.fri.prpo.skupina59.zrna;

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

    @PostConstruct
    private void logConstruction(){
        logger.info("UporabnikZrno je bilo ustvarjeno");
    }

    @PreDestroy
    private void logDestruct(){
        logger.info("UporabnikZrno je bilo uniceno");
    }

    public List<Uporabnik> pridobiVseUporabninke() {

        // implementacija
        Query q = em.createNamedQuery("Uporabnik.getAll");
        return q.getResultList();
    }

    public Uporabnik pridobiUporabnika(Integer id){
        return em.find(Uporabnik.class, id);
    }

    @Transactional
    public Uporabnik dodajUporabnik(Uporabnik uporabnik){
        if(uporabnik != null)
            em.persist(uporabnik);
        return uporabnik;
    }

    @Transactional
    public Uporabnik posodobiUporabnika(Integer id){
        Uporabnik uporabnik = pridobiUporabnika(id);
        if(uporabnik != null)
            em.merge(uporabnik);
        return uporabnik;
    }

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
