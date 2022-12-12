package si.fri.prpo.skupina59.servlet.v1.exceptionMapper;

import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavniIzdelekVTrgoviniExceptionMapper implements ExceptionMapper<NeveljavniIzdelekVTrgoviniIzjema> {

    @Override
    public Response toResponse(NeveljavniIzdelekVTrgoviniIzjema e){
        return Response.status(Response.Status.BAD_REQUEST).entity("NAPAKA: " + e.getMessage()).build();
    }

}
