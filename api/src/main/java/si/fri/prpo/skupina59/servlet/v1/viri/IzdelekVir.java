package si.fri.prpo.skupina59.servlet.v1.viri;

import si.fri.prpo.skupina59.DTO.IzdelekDTO;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.poslovnaZrna.UpravljanjeIzdelkovZrno;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("izdelek")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class IzdelekVir {
    @Inject
    private IzdelkiZrno IzdelkiZrno;

    @GET
    public Response vrniIzdelke(){

        List<Izdelek> izdelki = IzdelkiZrno.pridobiVseIzdelke();// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @GET
    @Path("{id}")
    public Response vrniIzdelek(@PathParam("id") Integer id){

        Izdelek izdelek = IzdelkiZrno.pridobiIzdelek(id);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelek).build();
    }

    @POST
    public Response dodajIzdelek(Izdelek i){
        return Response.status(Response.Status.CREATED).entity(IzdelkiZrno.dodajIzdelek(i)).build();
    }

    @DELETE
    public Response odstraniIzdelek(Izdelek i){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.izbrisiIzdelek(i.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniIzdelek(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.izbrisiIzdelek(id)).build();
    }

    @PUT
    public Response posodobiIzdelek(Izdelek i){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.posodobiIzdelek(i)).build();
    }

}