package si.fri.prpo.skupina59.DTO;

import si.fri.prpo.skupina59.entitete.Trgovina;

public class TrgovineIzdelkaDTO {
    private Trgovina trgovina;
    private double cena;
    private Integer zaloga;

    public Trgovina getTrgovina() {
        return trgovina;
    }

    public void setTrgovina(Trgovina trgovina) {
        this.trgovina = trgovina;
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
