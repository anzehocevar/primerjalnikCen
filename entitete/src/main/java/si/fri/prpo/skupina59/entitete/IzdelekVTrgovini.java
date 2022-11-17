package si.fri.prpo.skupina59.entitete;

import javax.persistence.*;

@Entity(name = "izdelekvtrgovini")
public class IzdelekVTrgovini {

    @Id
    @ManyToOne
    @JoinColumn(name = "izdelek_id")
    private Izdelek izdelek;

    @Id
    @ManyToOne
    @JoinColumn(name = "trgovina_id")
    private Trgovina trgovina;

    @Column(precision = 6, scale = 2)
    private double cena;

    private Integer zaloga;


}
