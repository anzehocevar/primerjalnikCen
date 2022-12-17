package si.fri.prpo.skupina59.servlet.v1.viri;


import com.kumuluz.ee.rest.beans.QueryParameters;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.entitete.Uporabnik;
import si.fri.prpo.skupina59.prestrezniki.ValidirajUporabnikaInterceptor;
import si.fri.prpo.skupina59.zrna.UporabnikZrno;

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

@Path("uporabnik")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UporabnikVir {
    @Inject
    private UporabnikZrno UporabnikZrno;

    @Context
    protected UriInfo uriInfo;

    @GET
    @Operation(summary = "Pridobi vse uporabnike", description = "Vrne vse uporabnike.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    public Response vrniUporabnike(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Uporabnik> uporabniki = UporabnikZrno.pridobiUporabnike(query);// pridobi izdelke
        Long uporabnikiCount = UporabnikZrno.pridobiUporabnikeCount(query);

        return Response
                .ok(UporabnikZrno.pridobiUporabnike(query))
                .header("X-Total-Count", uporabnikiCount)
                .build();
        //return Response.status(Response.Status.OK).entity(uporabniki).build();
    }

    @GET
    @Operation(summary = "Pridobi uporabnika", description = "Vrne uporabnika z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    @Path("{id}")
    public Response vrniUporabnika(@PathParam("id") Integer id){

        Uporabnik uporabnik = UporabnikZrno.pridobiUporabnika(id);

        return Response.status(Response.Status.OK).entity(uporabnik).build();
    }

    @POST
    @Operation(summary = "Dodaj uporabnika", description = "Doda uporabnika podanega kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    @Interceptors(ValidirajUporabnikaInterceptor.class)
    public Response dodajUporabnika(Uporabnik u){
        return Response.status(Response.Status.CREATED).entity(UporabnikZrno.dodajUporabnik(u)).build();
    }

    @DELETE
    @Operation(summary = "Odstrani uporabnika", description = "Odstrani uporabnika podanega kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    @Interceptors(ValidirajUporabnikaInterceptor.class)
    public Response odstraniUporabnika(Uporabnik u){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.izbrisiUporabnika(u.getId())).build();
    }

    @DELETE
    @Operation(summary = "Odstrani uporabnika", description = "Odstrani uporabnika z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.izbrisiUporabnika(id)).build();
    }

    @PUT
    @Operation(summary = "Posodobi uporabnika", description = "Posodobi uporabnika podanega kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    Uporabnik.class)))
    })
    @Interceptors(ValidirajUporabnikaInterceptor.class)
    public Response posodobiUporabnika(Uporabnik u){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.posodobiUporabnika(u)).build();
    }

}