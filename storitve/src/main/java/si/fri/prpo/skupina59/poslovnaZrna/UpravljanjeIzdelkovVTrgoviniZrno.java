package si.fri.prpo.skupina59.poslovnaZrna;

import si.fri.prpo.skupina59.DTO.IzdelekVTrgoviniDTO;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.zrna.IzdelkiVTrgoviniZrno;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;
import si.fri.prpo.skupina59.zrna.TrgovinaZrno;

import javax.inject.Inject;

public class UpravljanjeIzdelkovVTrgoviniZrno {

    @Inject
    private IzdelkiVTrgoviniZrno zrnoIzdelekVTrgovini;

    @Inject
    private IzdelkiZrno zrnoIzdelek;

    @Inject
    private TrgovinaZrno zrnoTrgovina;


    public IzdelekVTrgovini dodajIzdelekVTrgovino(IzdelekVTrgoviniDTO ivt){
        IzdelekVTrgovini novIzdelekVTrgovini = new IzdelekVTrgovini();
        Izdelek izdelek = zrnoIzdelek.pridobiIzdelek(ivt.getIzdelekId());
        Trgovina trgovina = zrnoTrgovina.pridobiTrgovino(ivt.getTrgovinaId());

        novIzdelekVTrgovini.setIzdelek(izdelek);
        izdelek.getIzdelkiVTrgovini().add(novIzdelekVTrgovini);

        novIzdelekVTrgovini.setTrgovina(trgovina);
        trgovina.getIzdelkiVTrgovini().add(novIzdelekVTrgovini);

        novIzdelekVTrgovini.setCena(ivt.getCena());
        novIzdelekVTrgovini.setZaloga(ivt.getZaloga());

        zrnoIzdelekVTrgovini.dodajIzdelekVTrgovini(novIzdelekVTrgovini);
        return novIzdelekVTrgovini;

    }
}
