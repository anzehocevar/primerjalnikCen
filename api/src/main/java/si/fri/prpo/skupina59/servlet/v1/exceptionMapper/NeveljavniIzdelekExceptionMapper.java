package si.fri.prpo.skupina59.servlet.v1.exceptionMapper;

import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavniIzdelekExceptionMapper implements ExceptionMapper<NeveljavniIzdelekIzjema> {

    @Override
    public Response toResponse(NeveljavniIzdelekIzjema e){
        return Response.status(Response.Status.BAD_REQUEST).entity("NAPAKA: " + e.getMessage()).build();
    }

}
