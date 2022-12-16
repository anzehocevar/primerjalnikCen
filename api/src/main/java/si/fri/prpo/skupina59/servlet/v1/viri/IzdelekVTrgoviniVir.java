package si.fri.prpo.skupina59.servlet.v1.viri;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;
import si.fri.prpo.skupina59.prestrezniki.ValidirajIzdelekVTrgoviniInterceptor;
import si.fri.prpo.skupina59.servlet.v1.exceptionMapper.NeveljavniIzdelekVTrgoviniExceptionMapper;
import si.fri.prpo.skupina59.zrna.IzdelkiVTrgoviniZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("izdelekvtrgovini")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class IzdelekVTrgoviniVir {
    @Inject
    private IzdelkiVTrgoviniZrno IzdelkiVTrgoviniZrno;

    @GET
    @Operation(summary = "Vrni izdelek v trgovini", description = "Vrne izdelek v trgovini z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih v trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    IzdelekVTrgovini.class)))
    })
    @Path("{id}")
    public Response vrniIzdelekVTrgovini(@PathParam("id") Integer id){

        IzdelekVTrgovini ivt = IzdelkiVTrgoviniZrno.pridobiIzdelekVTrgovini(id);
        return Response.status(Response.Status.OK).entity(ivt).build();
    }

    @POST
    @Operation(summary = "Dodaj izdelek v trgovini", description = "Doda izdelek v trgovino podan kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih v trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    IzdelekVTrgovini.class)))
    })
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response dodajIzdelekVTrgovini(IzdelekVTrgovini ivt){
            return Response.status(Response.Status.CREATED).entity(IzdelkiVTrgoviniZrno.dodajIzdelekVTrgovini(ivt)).build();
    }

    @DELETE
    @Operation(summary = "Izbrise izdelek v trgovini", description = "Izbriše izdelek v trgovini podan kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih v trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    IzdelekVTrgovini.class)))
    })
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response odstraniIzdelekVTrgovini(IzdelekVTrgovini ivt){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.izbrisiIzdelekVTrgovini(ivt.getId())).build();
    }

    @DELETE
    @Operation(summary = "Izbriši izdelek v trgovini", description = "Izbriše izdelek v trgovini z dolocenim ID-jem.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih v trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    IzdelekVTrgovini.class)))
    })
    @Path("{id}")
    public Response odstraniIzdelekVTrgovini(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.izbrisiIzdelekVTrgovini(id)).build();
    }

    @PUT
    @Operation(summary = "Posodobi izdelek v trgovini", description = "Posodobi izdelek v trgovino podan kot parameter.")
    @APIResponses({
            @APIResponse(description = "Podatki o izdelkih v trgovini", responseCode = "200", content = @Content(schema = @Schema(implementation =
                    IzdelekVTrgovini.class)))
    })
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response posodobiIzdelekVTrgovini(IzdelekVTrgovini ivt){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.posodobiIzdelekVTrgovini(ivt)).build();
    }

}