package si.fri.prpo.skupina59.servlet.v1.exceptionMapper;

import si.fri.prpo.skupina59.izjeme.NeveljavnaKategorijaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavnaTrgovinaIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavnaKategorijaExceptionMapper implements ExceptionMapper<NeveljavnaKategorijaIzjema> {

    @Override
    public Response toResponse(NeveljavnaKategorijaIzjema e){
        return Response.status(Response.Status.BAD_REQUEST).entity("NAPAKA: " + e.getMessage()).build();
    }

}