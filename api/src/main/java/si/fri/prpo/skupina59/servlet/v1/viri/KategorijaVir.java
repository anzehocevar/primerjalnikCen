package si.fri.prpo.skupina59.servlet.v1.viri;


import com.kumuluz.ee.rest.beans.QueryParameters;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.zrna.KategorijaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("kategorija")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class KategorijaVir {
    @Inject
    private KategorijaZrno KategorijaZrno;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response vrniKategorije(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Kategorija> kategorije = KategorijaZrno.pridobiKategorije(query);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(kategorije).build();
    }

    @GET
    @Path("{id}")
    public Response vrniKategorijo(@PathParam("id") Integer id){

        Kategorija kategorija = KategorijaZrno.pridobiKategorijo(id);

        return Response.status(Response.Status.OK).entity(kategorija).build();
    }

    @POST
    public Response dodajKategorijo(Kategorija k){
        return Response.status(Response.Status.CREATED).entity(KategorijaZrno.dodajKategorijo(k)).build();
    }

    @DELETE
    public Response odstraniKategorijo(Kategorija k){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.izbrisiKategorijo(k.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniKategorijo(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.izbrisiKategorijo(id)).build();
    }

    @PUT
    public Response posodobiKategorijo(Kategorija k){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.posodobiKategorijo(k)).build();
    }

}