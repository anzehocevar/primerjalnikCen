package si.fri.prpo.skupina59.servlet.v1.viri;


import com.kumuluz.ee.rest.beans.QueryParameters;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.prestrezniki.ValidirajIzdelekInterceptor;
import si.fri.prpo.skupina59.prestrezniki.ValidirajKategorijoInterceptor;
import si.fri.prpo.skupina59.zrna.KategorijaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
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
    @Operation(summary = "Pridobi vse kategorije", description = "Vrne vse izdelke.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    public Response vrniKategorije(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Kategorija> kategorije = KategorijaZrno.pridobiKategorije(query);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(kategorije).build();
    }

    @GET
    @Operation(summary = "Pridobi doloceno kategorijo", description = "Vrne kategorijo z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    @Path("{id}")
    public Response vrniKategorijo(@PathParam("id") Integer id){

        Kategorija kategorija = KategorijaZrno.pridobiKategorijo(id);

        return Response.status(Response.Status.OK).entity(kategorija).build();
    }

    @POST
    @Operation(summary = "Dodaj kategorijo", description = "Doda kategorijo podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    @Interceptors(ValidirajKategorijoInterceptor.class)
    public Response dodajKategorijo(Kategorija k){
        return Response.status(Response.Status.CREATED).entity(KategorijaZrno.dodajKategorijo(k)).build();
    }

    @DELETE
    @Operation(summary = "Izbrise kategorijo", description = "Izbrise kategorijo podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    @Interceptors(ValidirajKategorijoInterceptor.class)
    public Response odstraniKategorijo(Kategorija k){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.izbrisiKategorijo(k.getId())).build();
    }

    @DELETE
    @Operation(summary = "Izbrise kategorijo", description = "Izbrise kategorijo z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    @Path("{id}")
    public Response odstraniKategorijo(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.izbrisiKategorijo(id)).build();
    }

    @PUT
    @Operation(summary = "Posodobi kategorijo", description = "Posodobi kategorijo podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o kategoriji", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Kategorija.class)))
    })
    @Interceptors(ValidirajKategorijoInterceptor.class)
    public Response posodobiKategorijo(Kategorija k){
        return Response.status(Response.Status.OK).entity(KategorijaZrno.posodobiKategorijo(k)).build();
    }

}