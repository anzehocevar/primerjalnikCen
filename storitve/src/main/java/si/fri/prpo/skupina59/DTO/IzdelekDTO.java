package si.fri.prpo.skupina59.DTO;

import si.fri.prpo.skupina59.entitete.Kategorija;

import java.io.Serializable;
import java.util.List;

public class IzdelekDTO implements Serializable {
    private Integer id;
    private String ime;
    private String opis;
    private Integer teza_v_gramih;
    private Integer kategorijaId;
    private List<Integer> izdelekVTrgoviniId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getTeza_v_gramih() {
        return teza_v_gramih;
    }

    public void setTeza_v_gramih(Integer teza_v_gramih) {
        this.teza_v_gramih = teza_v_gramih;
    }

    public Integer getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Integer kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public List<Integer> getIzdelekVTrgoviniId() {
        return izdelekVTrgoviniId;
    }

    public void setIzdelekVTrgoviniId(List<Integer> izdelekVTrgoviniId) {
        this.izdelekVTrgoviniId = izdelekVTrgoviniId;
    }
}
