package si.fri.prpo.skupina59.servlet;

import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // izpis izdelkov na spletno stran
        resp.getWriter().println("IZPIS Z NAMED QUERY:");
        List<Izdelek> izdelki = izdelkiZrno.getIzdelki();
        for(Izdelek i : izdelki) {
            resp.getWriter().println(i.getIme());
            resp.getWriter().println(i.getOpis());
            resp.getWriter().println(i.getKategorija().getIme());
        }

        resp.getWriter().println();
        resp.getWriter().println("IZPIS IZDELKOV Z CRITERIA API:");
        izdelki = izdelkiZrno.getIzdelkiCriteriaAPI();
        for(Izdelek i : izdelki) {
            resp.getWriter().println(i.getIme());
            resp.getWriter().println(i.getOpis());
            resp.getWriter().println(i.getKategorija().getIme());
        }


    }
}
