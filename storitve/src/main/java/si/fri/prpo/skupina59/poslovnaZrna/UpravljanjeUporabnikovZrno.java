package si.fri.prpo.skupina59.poslovnaZrna;

import si.fri.prpo.skupina59.DTO.UporabnikDTO;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Uporabnik;
import si.fri.prpo.skupina59.zrna.UporabnikZrno;

import javax.inject.Inject;

public class UpravljanjeUporabnikovZrno {

    @Inject
    private UporabnikZrno zrnoUporabnik;

    @BeleziKlice
    private Uporabnik dodajUporabnika(UporabnikDTO u){
        Uporabnik novUporabnik = new Uporabnik();
        novUporabnik.setIme(u.getIme());
        novUporabnik.setPriimek(u.getPriimek());
        novUporabnik.setUporabnisko_ime(u.getUporabnisko_ime());
        novUporabnik.setEmail(u.getEmail());

        zrnoUporabnik.dodajUporabnik(novUporabnik);
        return novUporabnik;
    }
}
