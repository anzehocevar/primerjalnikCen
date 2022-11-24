package si.fri.prpo.skupina59.servlet;

import org.eclipse.jetty.server.ResponseWriter;
import si.fri.prpo.skupina59.DTO.KategorijaDTO;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.poslovnaZrna.UpravljanjeKategorijeZrno;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;
import si.fri.prpo.skupina59.zrna.KategorijaZrno;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {
    @Inject
    private IzdelkiZrno izdelkiZrno;

    @Inject
    UpravljanjeKategorijeZrno zrno;

    private int stevec;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Dodajmo kategorijo in nato vse kategorije izpisimo
        ++stevec;
        KategorijaDTO k = new KategorijaDTO();
        k.setIme("Kategorija " + stevec);
        k.setOpis("To kategorijo sem ustvaril ker nekaj");
        zrno.dodajKategorijo(k);

        resp.getWriter().println(k.getIme());
    }
}
