package si.fri.prpo.skupina59.servlet.v1.viri;

import com.kumuluz.ee.rest.beans.QueryParameters;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.zrna.TrgovinaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("trgovina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TrgovinaVir {
    @Inject
    private TrgovinaZrno TrgovinaZrno;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response vrniTrgovine(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Trgovina> trgovine = TrgovinaZrno.pridobiTrgovine(query);// pridobi izdelke

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