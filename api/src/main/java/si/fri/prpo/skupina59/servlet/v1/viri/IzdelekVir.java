package si.fri.prpo.skupina59.servlet.v1.viri;

import com.kumuluz.ee.rest.beans.QueryParameters;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.prpo.skupina59.DTO.IzdelekDTO;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.poslovnaZrna.UpravljanjeIzdelkovZrno;
import si.fri.prpo.skupina59.prestrezniki.ValidirajIzdelekInterceptor;
import si.fri.prpo.skupina59.prestrezniki.ValidirajIzdelekVTrgoviniInterceptor;
import si.fri.prpo.skupina59.zrna.IzdelkiZrno;

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

@Path("izdelek")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class IzdelekVir {
    @Inject
    private IzdelkiZrno IzdelkiZrno;

    @Context
    protected UriInfo uriInfo;

    @GET
    @Operation(summary = "Pridobi vse izdelke", description = "Vrne vse izdelke. Omogoča uporabo ostranjevanja, filtriranja in sortiranja")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Izdelek.class)))
    })
    public Response vrniIzdelke(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Izdelek> izdelki = IzdelkiZrno.pridobiIzdelke(query);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @GET
    @Path("{id}")
    public Response vrniIzdelek(@PathParam("id") Integer id){

        Izdelek izdelek = IzdelkiZrno.pridobiIzdelek(id);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(izdelek).build();
    }


    @POST
    @Interceptors(ValidirajIzdelekInterceptor.class)
    public Response dodajIzdelek(Izdelek i){
        return Response.status(Response.Status.CREATED).entity(IzdelkiZrno.dodajIzdelek(i)).build();
    }

    @DELETE
    @Interceptors(ValidirajIzdelekInterceptor.class)
    public Response odstraniIzdelek(Izdelek i){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.izbrisiIzdelek(i.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniIzdelek(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.izbrisiIzdelek(id)).build();
    }

    @PUT
    @Interceptors(ValidirajIzdelekInterceptor.class)
    public Response posodobiIzdelek(Izdelek i){
        return Response.status(Response.Status.OK).entity(IzdelkiZrno.posodobiIzdelek(i)).build();
    }

}