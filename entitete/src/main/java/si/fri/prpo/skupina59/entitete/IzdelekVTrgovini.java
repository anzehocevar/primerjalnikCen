package si.fri.prpo.skupina59.entitete;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity(name = "izdelekvtrgovini")
@NamedQueries(value =
    {
        @NamedQuery(name = "IzdelekVTrgovini.getAll", query = "SELECT o FROM izdelekvtrgovini o")
    })
public class IzdelekVTrgovini {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "izdelek_id")
    private Izdelek izdelek;

    @ManyToOne
    @JoinColumn(name = "trgovina_id")
    private Trgovina trgovina;

    @Column(precision = 6, scale = 2)
    private double cena;

    private Integer zaloga;

    //getter in setter metode

    public Izdelek getIzdelek() {
        return izdelek;
    }

    public void setIzdelek(Izdelek izdelek) {
        this.izdelek = izdelek;
    }

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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
