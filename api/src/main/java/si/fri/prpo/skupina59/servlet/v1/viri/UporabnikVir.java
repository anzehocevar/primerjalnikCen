package si.fri.prpo.skupina59.servlet.v1.viri;


import si.fri.prpo.skupina59.entitete.Uporabnik;
import si.fri.prpo.skupina59.zrna.UporabnikZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("uporabnik")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UporabnikVir {
    @Inject
    private UporabnikZrno UporabnikZrno;

    @GET
    public Response vrniUporabnike(){

        List<Uporabnik> uporabniki = UporabnikZrno.pridobiVseUporabninke();

        return Response.status(Response.Status.OK).entity(uporabniki).build();
    }

    @GET
    @Path("{id}")
    public Response vrniUporabnike(@PathParam("id") Integer id){

        Uporabnik uporabnik = UporabnikZrno.pridobiUporabnika(id);

        return Response.status(Response.Status.OK).entity(uporabnik).build();
    }

    @POST
    public Response dodajUporabnika(Uporabnik u){
        return Response.status(Response.Status.CREATED).entity(UporabnikZrno.dodajUporabnik(u)).build();
    }

    @DELETE
    public Response odstraniUporabnika(Uporabnik u){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.izbrisiUporabnika(u.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.izbrisiUporabnika(id)).build();
    }

    @PUT
    public Response posodobiUporabnika(Uporabnik u){
        return Response.status(Response.Status.OK).entity(UporabnikZrno.posodobiUporabnika(u)).build();
    }

}