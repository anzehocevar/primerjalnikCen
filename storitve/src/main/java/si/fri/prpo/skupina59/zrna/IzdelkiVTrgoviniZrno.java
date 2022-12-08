package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;

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
public class IzdelkiVTrgoviniZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(IzdelkiVTrgoviniZrno.class.getName());

    @BeleziKlice
    @PostConstruct
    private void logConstruction(){
        logger.info("IzdelkiVTrgoviniZrno je bilo ustvarjeno");
    }

    @BeleziKlice
    @PreDestroy
    private void logDestruct(){
        logger.info("IzdelkiVTrgoviniZrno je bilo uniceno");
    }

    @BeleziKlice
    public IzdelekVTrgovini pridobiIzdelekVTrgovini(Integer id){
        return em.find(IzdelekVTrgovini.class, id);
    }


    @BeleziKlice
    @Transactional
    public IzdelekVTrgovini dodajIzdelekVTrgovini(IzdelekVTrgovini izdelekVTrgovini){
        if(izdelekVTrgovini != null)
            em.persist(izdelekVTrgovini);
        return izdelekVTrgovini;
    }

    @BeleziKlice
    @Transactional
    public IzdelekVTrgovini posodobiIzdelekVTrgovini(IzdelekVTrgovini ivt){
        if(ivt != null)
            em.merge(ivt);
        return ivt;
    }

    @BeleziKlice
    @Transactional
    public boolean izbrisiIzdelekVTrgovini(Integer id){
        IzdelekVTrgovini izdelekVTrgovini = pridobiIzdelekVTrgovini(id);
        if (izdelekVTrgovini != null){
            em.remove(izdelekVTrgovini);
            return true;
        }
        return false;
    }


}
