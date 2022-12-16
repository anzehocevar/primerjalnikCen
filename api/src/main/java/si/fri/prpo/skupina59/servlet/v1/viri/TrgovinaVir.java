package si.fri.prpo.skupina59.servlet.v1.viri;

import com.kumuluz.ee.rest.beans.QueryParameters;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.prestrezniki.ValidirajKategorijoInterceptor;
import si.fri.prpo.skupina59.prestrezniki.ValidirajTrgovinoInterceptor;
import si.fri.prpo.skupina59.zrna.TrgovinaZrno;

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
    @Operation(summary = "Pridobi vse trgovine", description = "Vrne vse trgovine.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    public Response vrniTrgovine(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Trgovina> trgovine = TrgovinaZrno.pridobiTrgovine(query);// pridobi izdelke

        return Response.status(Response.Status.OK).entity(trgovine).build();
    }

    @GET
    @Operation(summary = "Pridobi trgovino", description = "Vrne trgovino z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    @Path("{id}")
    public Response vrniTrgovino(@PathParam("id") Integer id){

        Trgovina trgovina = TrgovinaZrno.pridobiTrgovino(id);

        return Response.status(Response.Status.OK).entity(trgovina).build();
    }

    @POST
    @Operation(summary = "Dodaj trgovino", description = "Doda trgovino podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    @Interceptors(ValidirajTrgovinoInterceptor.class)
    public Response dodajTrgovino(Trgovina t){
        return Response.status(Response.Status.CREATED).entity(TrgovinaZrno.dodajTrgovino(t)).build();
    }

    @DELETE
    @Operation(summary = "Izbrise trgovino", description = "Izbrise trgovino podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    @Interceptors(ValidirajTrgovinoInterceptor.class)
    public Response odstraniTrgovino(Trgovina t){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.izbrisiTrgovino(t.getId())).build();
    }

    @DELETE
    @Operation(summary = "Izbrise trgovino", description = "Izbrise trgovino z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    @Path("{id}")
    public Response odstraniTrgovino(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.izbrisiTrgovino(id)).build();
    }

    @PUT
    @Operation(summary = "Posodobi trgovino", description = "Posodobi trgovino podano kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Trgovina.class)))
    })
    @Interceptors(ValidirajTrgovinoInterceptor.class)
    public Response posodobiTrgovino(Trgovina t){
        return Response.status(Response.Status.OK).entity(TrgovinaZrno.posodobiTrgovino(t)).build();
    }

}