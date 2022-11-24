package si.fri.prpo.skupina59.DTO;

import java.io.Serializable;

public class IzdelekVTrgoviniDTO implements Serializable {
    private Integer TrgovinaId;
    private Integer IzdelekId;
    private double cena;
    private Integer zaloga;

    public Integer getTrgovinaId() {
        return TrgovinaId;
    }

    public void setTrgovinaId(Integer trgovinaId) {
        TrgovinaId = trgovinaId;
    }

    public Integer getIzdelekId() {
        return IzdelekId;
    }

    public void setIzdelekId(Integer izdelekId) {
        IzdelekId = izdelekId;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Integer getZaloga() {
        return zaloga;
    }

    public void setZaloga(Integer zaloga) {
        this.zaloga = zaloga;
    }
}
