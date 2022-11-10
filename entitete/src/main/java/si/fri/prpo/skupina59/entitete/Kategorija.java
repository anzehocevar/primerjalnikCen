package si.fri.prpo.skupina59.entitete;

import javax.persistence.*;
import java.util.List;

@Entity(name = "izdelek")
@NamedQueries(value =
        {
                @NamedQuery(name = "Kategorija.getAll", query = "SELECT o FROM kategorija o")
        })
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    @OneToMany(mappedBy = "izdelek", cascade = CascadeType.ALL)
    private List<Izdelek> izdelki;

}
