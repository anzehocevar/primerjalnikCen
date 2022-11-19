package si.fri.prpo.skupina59.entitete;

import javax.persistence.*;
import java.util.List;

@Entity(name = "izdelek")
@NamedQueries(value =
    {
        @NamedQuery(name = "Izdelek.getAll", query = "SELECT o FROM izdelek o"),
        @NamedQuery(name = "Izdelek.getById", query = "SELECT o FROM izdelek o WHERE o.id = :id"),
        @NamedQuery(name = "Izdelek.getByName", query = "SELECT o FROM izdelek o WHERE o.ime = :ime"),
            @NamedQuery(name = "Izdelek.getByLike", query = "SELECT o FROM izdelek o WHERE o.ime LIKE CONCAT('%',:ime,'%')")    })
public class Izdelek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    private String opis;

    private Integer teza_v_gramih;

    @ManyToOne
    @JoinColumn(name = "kategorija_id")
    private Kategorija kategorija;

    @OneToMany(mappedBy = "izdelek")
    List<IzdelekVTrgovini> izdelkiVTrgovini;

    // getter in setter metode

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

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}