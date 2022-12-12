package si.fri.prpo.skupina59.servlet.v1.exceptionMapper;

import si.fri.prpo.skupina59.izjeme.NeveljavnaKategorijaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniUporabnikIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavniUporabnikExceptionMapper implements ExceptionMapper<NeveljavniUporabnikIzjema> {

    @Override
    public Response toResponse(NeveljavniUporabnikIzjema e){
        return Response.status(Response.Status.BAD_REQUEST).entity("NAPAKA: " + e.getMessage()).build();
    }

}