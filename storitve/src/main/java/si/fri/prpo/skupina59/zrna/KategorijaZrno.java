package si.fri.prpo.skupina59.zrna;

import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.entitete.Trgovina;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RequestScoped
public class KategorijaZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(KategorijaZrno.class.getName());

    UUID uuid = UUID.randomUUID();


    @PostConstruct
    private void logConstruction(){
        logger.info("KategorijaZrno je bilo ustvarjeno");
    }

    @PreDestroy
    private void logDestruct(){
        logger.info("KategorijaZrno je bilo uniceno");
    }

    public List<Kategorija> pridobiVseKategorije() {

        // implementacija
        Query q = em.createNamedQuery("Kategorija.getAll");
        return q.getResultList();
    }

    public Kategorija pridobiKategorijo(Integer id){
        return em.find(Kategorija.class, id);
    }

    @Transactional
    public Kategorija dodajKategorijo(Kategorija kategorija){
        //Pri ApplicationScoped je vedno isti pri RequestScoped pa se spreminja
        logger.info("Zrno ima UUID " + uuid.toString() );
        if(kategorija != null)
            em.persist(kategorija);
        return kategorija;
    }

    @Transactional
    public Kategorija posodobiKategorijo(Kategorija k){
        if(k != null){
            em.merge(k);
        }
        return k;
    }

    @Transactional
    public boolean izbrisiKategorijo(Integer id){
        Kategorija kategorija = pridobiKategorijo(id);
        if (kategorija != null){
            em.remove(kategorija);
            return true;
        }
        return false;
    }


}
