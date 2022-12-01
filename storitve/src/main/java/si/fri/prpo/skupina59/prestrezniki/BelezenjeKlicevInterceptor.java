package si.fri.prpo.skupina59.prestrezniki;

import si.fri.prpo.skupina59.anotacije.BeleziKlice;
import si.fri.prpo.skupina59.zrna.BelezenjeKlicevZrno;
import si.fri.prpo.skupina59.zrna.IzdelkiVTrgoviniZrno;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@BeleziKlice
public class BelezenjeKlicevInterceptor {

    private static final Logger logger = Logger.getLogger(BelezenjeKlicevZrno.class.getName());

    @Inject
    private BelezenjeKlicevZrno zrno;

    @AroundInvoke
    public Object povecajGlobalniStevec(InvocationContext context) throws Exception{
        zrno.povecajGlobalniStevec();
        logger.info("Globalni stevec metod je trenutno " + zrno.getGlobalniStevec());

        return context.proceed();

    }
}
