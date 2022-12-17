package si.fri.prpo.skupina59.zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
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

    @BeleziKlice
    @PostConstruct
    private void logConstruction(){
        logger.info("KategorijaZrno je bilo ustvarjeno");
    }

    @BeleziKlice
    @PreDestroy
    private void logDestruct(){
        logger.info("KategorijaZrno je bilo uniceno");
    }

    @BeleziKlice
    public List<Kategorija> pridobiVseKategorije() {

        // implementacija
        Query q = em.createNamedQuery("Kategorija.getAll");
        return q.getResultList();
    }

    @BeleziKlice
    public List<Kategorija> pridobiKategorije(QueryParameters q){
        return JPAUtils.queryEntities(em, Kategorija.class, q);
    }

    @BeleziKlice
    public Kategorija pridobiKategorijo(Integer id){
        return em.find(Kategorija.class, id);
    }

    @BeleziKlice
    @Transactional
    public Kategorija dodajKategorijo(Kategorija kategorija){
        //Pri ApplicationScoped je vedno isti pri RequestScoped pa se spreminja
        logger.info("Zrno ima UUID " + uuid.toString() );
        if(kategorija != null)
            em.persist(kategorija);
        return kategorija;
    }

    @BeleziKlice
    @Transactional
    public Kategorija posodobiKategorijo(Kategorija k){
        if(k != null){
            em.merge(k);
        }
        return k;
    }

    @BeleziKlice
    @Transactional
    public boolean izbrisiKategorijo(Integer id){
        Kategorija kategorija = pridobiKategorijo(id);
        if (kategorija != null){
            em.remove(kategorija);
            return true;
        }
        return false;
    }


    public long pridobiKategorijeCount(QueryParameters query){
        return JPAUtils.queryEntitiesCount(em, Kategorija.class, query);
    }

}
