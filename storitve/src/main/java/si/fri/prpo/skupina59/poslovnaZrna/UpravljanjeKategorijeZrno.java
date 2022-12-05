package si.fri.prpo.skupina59.poslovnaZrna;

import si.fri.prpo.skupina59.DTO.KategorijaDTO;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;
import si.fri.prpo.skupina59.zrna.KategorijaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UpravljanjeKategorijeZrno {


    @Inject
    private KategorijaZrno zrnoKategorija;

    @BeleziKlice
    public void dodajKategorijo(KategorijaDTO kategorija){
        Kategorija k = new Kategorija();
        List<Izdelek> izdelki = new ArrayList<>();

        k.setIme(kategorija.getIme());
        k.setOpis(kategorija.getOpis());
        k.setIzdelki(izdelki);
        zrnoKategorija.dodajKategorijo(k);

    }
}
