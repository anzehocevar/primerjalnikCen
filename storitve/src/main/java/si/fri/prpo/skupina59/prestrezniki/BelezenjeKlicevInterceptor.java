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


    @Inject
    private BelezenjeKlicevZrno zrno;

    @AroundInvoke
    public Object povecajGlobalniStevec(InvocationContext context) throws Exception{
        String klicanaFunckija = context.getMethod().toString();
        zrno.povecajStevce(klicanaFunckija);


        return context.proceed();

    }
}
