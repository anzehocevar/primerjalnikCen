package si.fri.prpo.skupina59.DTO;

import java.io.Serializable;
import java.util.List;

public class KategorijaDTO implements Serializable {
    private Integer id;
    private String ime;
    private String opis;
    private List<Integer> izdelkiId;

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

    public List<Integer> getIzdelkiId() {
        return izdelkiId;
    }

    public void setIzdelkiId(List<Integer> izdelkiId) {
        this.izdelkiId = izdelkiId;
    }
}
