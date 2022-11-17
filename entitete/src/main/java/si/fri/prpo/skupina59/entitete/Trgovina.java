package si.fri.prpo.skupina59.entitete;

import javax.persistence.*;
import java.util.List;

@Entity(name = "trgovina")
public class Trgovina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    private String kraj;

    @Column(nullable = true)
    private String spletna_stran;

    @OneToMany(mappedBy = "trgovina")
    List<IzdelekVTrgovini> izdelkiVTrgovini;
}
