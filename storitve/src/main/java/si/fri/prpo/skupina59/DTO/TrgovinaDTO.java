package si.fri.prpo.skupina59.DTO;

import java.io.Serializable;
import java.util.List;

public class TrgovinaDTO implements Serializable {
    private Integer id;
    private String ime;
    private String kraj;
    private String spletna_stran;
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

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getSpletna_stran() {
        return spletna_stran;
    }

    public void setSpletna_stran(String spletna_stran) {
        this.spletna_stran = spletna_stran;
    }

    public List<Integer> getIzdelekVTrgoviniId() {
        return izdelekVTrgoviniId;
    }

    public void setIzdelekVTrgoviniId(List<Integer> izdelekVTrgoviniId) {
        this.izdelekVTrgoviniId = izdelekVTrgoviniId;
    }
}
