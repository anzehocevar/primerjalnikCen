package si.fri.prpo.skupina59.servlet.v1.viri;

import si.fri.prpo.skupina59.DTO.IzdelekDTO;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.poslovnaZrna.UpravljanjeIzdelkovZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("izdelki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class IzdelkiVir {
    @Inject
    private UpravljanjeIzdelkovZrno IzdelkiZrno;

    @GET
    public Response vrniIzdelke(){

        List<IzdelekDTO> izdelki = IzdelkiZrno.pridobiVseIzdelke();// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @GET
    @Path("{id}")
    public Response vrniIzdelek(@PathParam("id") Integer id){

        IzdelekDTO izdelek = IzdelkiZrno.pridobiIzdelek(id);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelek).build();
    }

}