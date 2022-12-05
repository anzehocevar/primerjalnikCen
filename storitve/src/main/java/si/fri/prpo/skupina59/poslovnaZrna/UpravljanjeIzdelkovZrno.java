package si.fri.prpo.skupina59.poslovnaZrna;

import si.fri.prpo.skupina59.DTO.IzdelekDTO;
import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.zrna.IzdelkiVTrgoviniZrno;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;
import si.fri.prpo.skupina59.zrna.KategorijaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UpravljanjeIzdelkovZrno {

    @Inject
    private IzdelkiZrno zrnoIzdelek;

    @Inject
    private KategorijaZrno zrnoKategorija;

    @Inject
    private IzdelkiVTrgoviniZrno zrnoIzdelekVTrgovini;

    @BeleziKlice
    public List<IzdelekDTO> pridobiVseIzdelke(){
        List<Izdelek> seznam = zrnoIzdelek.pridobiVseIzdelke();
        List<IzdelekDTO> builder = new ArrayList<>();

        for(Izdelek i : seznam){
            IzdelekDTO b = new IzdelekDTO();
            b.setId(i.getId());
            b.setIme(i.getIme());
            b.setTeza_v_gramih(i.getTeza_v_gramih());
            b.setOpis(i.getOpis());
            builder.add(b);
        }

        return builder;
    }

    @BeleziKlice
    public IzdelekDTO pridobiIzdelek(Integer id){
        Izdelek i = zrnoIzdelek.pridobiIzdelek(id);
        IzdelekDTO b = new IzdelekDTO();

        b.setId(i.getId());
        b.setIme(i.getIme());
        b.setTeza_v_gramih(i.getTeza_v_gramih());
        b.setOpis(i.getOpis());

        return b;
    }

    @BeleziKlice
    public Izdelek dodajIzdelek(IzdelekDTO i){
        Izdelek novIzdelek = new Izdelek();
        novIzdelek.setIme(i.getIme());
        novIzdelek.setTeza_v_gramih(i.getTeza_v_gramih());
        novIzdelek.setOpis(i.getOpis());
        novIzdelek.setIzdelkiVTrgovini(new ArrayList<>());

        Integer kategorijaId = i.getKategorijaId();
        Kategorija k = zrnoKategorija.pridobiKategorijo(kategorijaId);

        novIzdelek.setKategorija(k);
        k.getIzdelki().add(novIzdelek);

        zrnoIzdelek.dodajIzdelek(novIzdelek);

        return novIzdelek;
    }

    @BeleziKlice
    public void odstraniIzdelek(IzdelekDTO i){
        Izdelek izbrisanIzdelek = zrnoIzdelek.pridobiIzdelek(i.getId());
        Kategorija k = zrnoKategorija.pridobiKategorijo(i.getKategorijaId());
        k.getIzdelki().remove(izbrisanIzdelek);

        for(IzdelekVTrgovini ivt : izbrisanIzdelek.getIzdelkiVTrgovini()){
            zrnoIzdelekVTrgovini.izbrisiIzdelekVTrgovini(ivt.getId());
        }

        zrnoIzdelek.izbrisiIzdelek(izbrisanIzdelek.getId());

    }

    @BeleziKlice
    public Izdelek spremeniIzdelek(IzdelekDTO i){
        Izdelek updateIzdelek = zrnoIzdelek.pridobiIzdelek(i.getId());
        updateIzdelek.setIme(i.getIme());
        updateIzdelek.setOpis(i.getOpis());
        updateIzdelek.setTeza_v_gramih(i.getTeza_v_gramih());

        Kategorija staraKategorija = updateIzdelek.getKategorija();
        Kategorija novaKategorija = zrnoKategorija.pridobiKategorijo(i.getKategorijaId());
        staraKategorija.getIzdelki().remove(updateIzdelek);
        novaKategorija.getIzdelki().add(updateIzdelek);
        updateIzdelek.setKategorija(novaKategorija);

        zrnoIzdelek.posodobiIzdelek(updateIzdelek);
        return updateIzdelek;
    }


}
