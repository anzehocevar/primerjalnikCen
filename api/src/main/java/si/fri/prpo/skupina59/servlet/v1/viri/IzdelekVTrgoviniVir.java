package si.fri.prpo.skupina59.servlet.v1.viri;


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
    @Path("{id}")
    public Response vrniIzdelekVTrgovini(@PathParam("id") Integer id){

        IzdelekVTrgovini ivt = IzdelkiVTrgoviniZrno.pridobiIzdelekVTrgovini(id);
        return Response.status(Response.Status.OK).entity(ivt).build();
    }

    @POST
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response dodajIzdelekVTrgovini(IzdelekVTrgovini ivt){
            return Response.status(Response.Status.CREATED).entity(IzdelkiVTrgoviniZrno.dodajIzdelekVTrgovini(ivt)).build();
    }

    @DELETE
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response odstraniIzdelekVTrgovini(IzdelekVTrgovini ivt){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.izbrisiIzdelekVTrgovini(ivt.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniIzdelekVTrgovini(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.izbrisiIzdelekVTrgovini(id)).build();
    }

    @PUT
    @Interceptors(ValidirajIzdelekVTrgoviniInterceptor.class)
    public Response posodobiIzdelekVTrgovini(IzdelekVTrgovini ivt){
        return Response.status(Response.Status.OK).entity(IzdelkiVTrgoviniZrno.posodobiIzdelekVTrgovini(ivt)).build();
    }

}