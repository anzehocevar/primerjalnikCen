package si.fri.prpo.skupina59.poslovnaZrna;

import si.fri.prpo.skupina59.DTO.TrgovinaDTO;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.zrna.TrgovinaZrno;

import javax.inject.Inject;
import java.util.ArrayList;

public class UpravljanjeTrgovineZrno {

    @Inject
    private TrgovinaZrno zrnoTrgovina;

    @BeleziKlice
    public Trgovina dodajTrgovino(TrgovinaDTO t){
        Trgovina newTrgovina = new Trgovina();
        newTrgovina.setIme(t.getIme());
        newTrgovina.setKraj(t.getKraj());
        newTrgovina.setSpletna_stran(t.getSpletna_stran());
        newTrgovina.setIzdelkiVTrgovini(new ArrayList<>());

        zrnoTrgovina.dodajTrgovino(newTrgovina);
        return newTrgovina;
    }
}
