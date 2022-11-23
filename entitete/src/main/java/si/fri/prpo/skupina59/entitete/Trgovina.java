package si.fri.prpo.skupina59.entitete;

import javax.persistence.*;
import java.util.List;

@Entity(name = "trgovina")
@NamedQueries(value =
        {
                @NamedQuery(name = "Trgovina.getAll", query = "SELECT o FROM trgovina o")
        })
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

    //getter in setter metode

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

    public List<IzdelekVTrgovini> getIzdelkiVTrgovini() {
        return izdelkiVTrgovini;
    }

    public void setIzdelkiVTrgovini(List<IzdelekVTrgovini> izdelkiVTrgovini) {
        this.izdelkiVTrgovini = izdelkiVTrgovini;
    }

}
