package si.fri.prpo.skupina59.zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
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

    @BeleziKlice
    @PostConstruct
    private void logConstruction(){
        logger.info("Trgovina je bilo ustvarjeno");
    }

    @BeleziKlice
    @PreDestroy
    private void logDestruct(){
        logger.info("Trgovina je bilo uniceno");
    }

    @BeleziKlice
    public List<Trgovina> pridobiTrgovine(QueryParameters q){
        return JPAUtils.queryEntities(em, Trgovina.class, q);
    }

    @BeleziKlice
    public List<Trgovina> pridobiVseTrgovine() {

        // implementacija
        Query q = em.createNamedQuery("Trgovina.getAll");
        return q.getResultList();
    }

    @BeleziKlice
    public Trgovina pridobiTrgovino(Integer id){
        return em.find(Trgovina.class, id);
    }

    @BeleziKlice
    @Transactional
    public Trgovina dodajTrgovino(Trgovina trgovina){
        if(trgovina != null)
            em.persist(trgovina);
        return trgovina;
    }

    @BeleziKlice
    @Transactional
    public Trgovina posodobiTrgovino(Trgovina t){
        if(t != null)
            em.merge(t);
        return t;
    }

    @BeleziKlice
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
