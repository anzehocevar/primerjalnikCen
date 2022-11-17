package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.entitete.Trgovina;

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
public class TrgovinaZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(Trgovina.class.getName());

    @PostConstruct
    private void logConstruction(){
        logger.info("Trgovina je bilo ustvarjeno");
    }

    @PreDestroy
    private void logDestruct(){
        logger.info("Trgovina je bilo uniceno");
    }

    public List<Trgovina> pridobiVseTrgovine() {

        // implementacija
        Query q = em.createNamedQuery("Trgovina.getAll");
        return q.getResultList();
    }

    public Trgovina pridobiTrgovino(Integer id){
        return em.find(Trgovina.class, id);
    }

    @Transactional
    public Trgovina dodajTrgovino(Trgovina trgovina){
        if(trgovina != null)
            em.persist(trgovina);
        return trgovina;
    }

    @Transactional
    public Trgovina posodobiTrgovino(Integer id){
        Trgovina trgovina = pridobiTrgovino(id);
        if(trgovina != null)
            em.merge(trgovina);
        return trgovina;
    }

    @Transactional
    public boolean izbrisiTrgovino(Integer id){
        Trgovina trgovina = pridobiTrgovino(id);
        if (trgovina != null){
            em.remove(trgovina);
            return true;
        }
        return false;
    }


}
