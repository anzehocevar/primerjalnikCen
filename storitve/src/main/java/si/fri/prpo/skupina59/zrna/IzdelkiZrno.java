package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.entitete.Izdelek;

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
public class IzdelkiZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(IzdelkiZrno.class.getName());

    @PostConstruct
    private void logConstruction(){
        logger.info("IzdelkiZrno je bilo ustvarjeno");
    }

    @PreDestroy
    private void logDestruct(){
        logger.info("IzdelkiZrno je bilo uniceno");
    }


    public List<Izdelek> pridobiVseIzdelke() {

        // implementacija
        Query q = em.createNamedQuery("Izdelek.getAll");
        return q.getResultList();
    }

    public Izdelek pridobiIzdelek(Integer id){
        return em.find(Izdelek.class, id);
    }

    @Transactional
    public Izdelek dodajIzdelek(Izdelek izdelek){
        if(izdelek != null)
            em.persist(izdelek);
        return izdelek;
    }

    @Transactional
    public Izdelek posodobiIzdelek(Izdelek izdelek){
        if(izdelek != null){
            em.merge(izdelek);
        }
        return izdelek;
    }

    @Transactional
    public boolean izbrisiIzdelek(Integer id){
        Izdelek izdelek = pridobiIzdelek(id);
        if (izdelek != null){
            em.remove(izdelek);
            return true;
        }
        return false;
    }


}
