package si.fri.prpo.skupina59.zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.prpo.skupina59.DTO.TrgovineIzdelkaDTO;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Trgovina;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class IzdelkiZrno {

    @PersistenceContext(unitName = "primerjalnik-cen-jpa")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(IzdelkiZrno.class.getName());

    @BeleziKlice
    @PostConstruct
    private void logConstruction(){
        logger.info("IzdelkiZrno je bilo ustvarjeno");
    }

    @BeleziKlice
    @PreDestroy
    private void logDestruct(){
        logger.info("IzdelkiZrno je bilo uniceno");
    }

    @BeleziKlice
    public List<TrgovineIzdelkaDTO> pridobiTrgovine(Integer id){
        Query q = em.createNamedQuery("Izdelek.getTrgovine");
        Izdelek i = pridobiIzdelek(id);
        q.setParameter("id", i);

        List<Object[]> podrobnosti = q.getResultList();
        List<TrgovineIzdelkaDTO> seznam = new ArrayList<>();
        for(Object[] a : podrobnosti){
            Trgovina t = (Trgovina)a[0];
            IzdelekVTrgovini ivt = (IzdelekVTrgovini)a[1];

            TrgovineIzdelkaDTO d = new TrgovineIzdelkaDTO();
            d.setTrgovina(t);
            d.setCena(ivt.getCena());
            d.setZaloga(ivt.getZaloga());

            seznam.add(d);
        }

        return seznam;
    }

    @BeleziKlice
    public List<Izdelek> pridobiVseIzdelke() {

        // implementacija
        Query q = em.createNamedQuery("Izdelek.getAll");
        return q.getResultList();
    }

    @BeleziKlice
    public List<Izdelek> pridobiIzdelke(QueryParameters q){
        return JPAUtils.queryEntities(em, Izdelek.class, q);
    }

    @BeleziKlice
    public Izdelek pridobiIzdelek(Integer id){
        return em.find(Izdelek.class, id);
    }

    @BeleziKlice
    @Transactional
    public Izdelek dodajIzdelek(Izdelek izdelek){
        if(izdelek != null)
            em.persist(izdelek);
        return izdelek;
    }

    @BeleziKlice
    @Transactional
    public Izdelek posodobiIzdelek(Izdelek izdelek){
        if(izdelek != null){
            em.merge(izdelek);
        }
        return izdelek;
    }

    @BeleziKlice
    @Transactional
    public boolean izbrisiIzdelek(Integer id){
        Izdelek izdelek = pridobiIzdelek(id);
        if (izdelek != null){
            em.remove(izdelek);
            return true;
        }
        return false;
    }

    public long pridobiIzdelkeCount(QueryParameters query){
        return JPAUtils.queryEntitiesCount(em, Izdelek.class, query);
    }


}
