package si.fri.prpo.skupina59.prestrezniki;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.izjeme.NeveljavnaTrgovinaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ValidirajTrgovinoInterceptor {

    @AroundInvoke
    public Object validirajTrgovino(InvocationContext context) throws Exception{
        if(context.getParameters().length != 1)
            throw new NeveljavnaTrgovinaIzjema("Napacno stevilo parametrov");
        if(!(context.getParameters()[0] instanceof Trgovina)){
            throw new NeveljavnaTrgovinaIzjema("Napacna vrsta parametra");
        }
        Trgovina t = (Trgovina) context.getParameters()[0];
        if(t.getIme() == null || t.getKraj() == null) {
            throw new NeveljavnaTrgovinaIzjema("Eden izmed podatkov manjka");
        }
        return context.proceed();
    }
}
