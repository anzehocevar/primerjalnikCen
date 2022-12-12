package si.fri.prpo.skupina59.servlet.v1.exceptionMapper;

import si.fri.prpo.skupina59.izjeme.NeveljavnaTrgovinaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavnaTrgovinaExceptionMapper implements ExceptionMapper<NeveljavnaTrgovinaIzjema> {

    @Override
    public Response toResponse(NeveljavnaTrgovinaIzjema e){
        return Response.status(Response.Status.BAD_REQUEST).entity("NAPAKA: " + e.getMessage()).build();
    }

}
