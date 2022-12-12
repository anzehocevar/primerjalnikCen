package si.fri.prpo.skupina59.prestrezniki;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ValidirajIzdelekInterceptor {

    @AroundInvoke
    public Object validirajIzdelek(InvocationContext context) throws Exception{
        if(context.getParameters().length != 1)
            throw new NeveljavniIzdelekIzjema("Napacno stevilo parametrov");
        if(!(context.getParameters()[0] instanceof Izdelek)){
            throw new NeveljavniIzdelekIzjema("Napacna vrsta parametra");
        }
        Izdelek i = (Izdelek)context.getParameters()[0];
        if(i.getIme() == null || i.getOpis() == null || i.getTeza_v_gramih() == null) {
            throw new NeveljavniIzdelekIzjema("Eden izmed podatkov manjka");
        }

        return context.proceed();
    }
}
