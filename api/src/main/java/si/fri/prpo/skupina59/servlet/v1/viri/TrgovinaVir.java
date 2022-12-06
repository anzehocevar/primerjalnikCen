package si.fri.prpo.skupina59.servlet.v1.viri;

import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.zrna.TrgovinaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("trgovina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TrgovinaVir {
    @Inject
    private TrgovinaZrno TrgovinaZrno;

    @GET
    public Response vrniTrgovine(){

        List<Trgovina> trgovine = TrgovinaZrno.pridobiVseTrgovine();

        return Response.status(Response.Status.OK).entity(trgovine).build();
    }

    @GET
    @Path("{id}")
    public Response vrniTrgovino(@PathParam("id") Integer id){

        Trgovina trgovina = TrgovinaZrno.pridobiTrgovino(id);

        return Response.status(Response.Status.OK).entity(trgovina).build();
    }

    @POST
    public Response dodajTrgovino(Trgovina t){
        return Response.status(Response.Status.CREATED).entity(TrgovinaZrno.dodajTrgovino(t)).build();
    }

    @DELETE
    public Response odstraniTrgovino(Trgovina t){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.izbrisiTrgovino(t.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniIzdelek(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.izbrisiTrgovino(id)).build();
    }

    @PUT
    public Response posodobiIzdelek(Trgovina t){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.posodobiTrgovino(t)).build();
    }

}