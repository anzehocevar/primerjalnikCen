package si.fri.prpo.skupina59.prestrezniki;

import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ValidirajIzdelekVTrgoviniInterceptor {

    @AroundInvoke
    public Object validirajIzdelekVTrgovini(InvocationContext context) throws Exception{
        if(context.getParameters().length != 1)
            throw new NeveljavniIzdelekVTrgoviniIzjema("Napacno stevilo parametrov");
        if(!(context.getParameters()[0] instanceof IzdelekVTrgovini)){
            throw new NeveljavniIzdelekVTrgoviniIzjema("Napacna vrsta parametra");
        }
        IzdelekVTrgovini ivt = (IzdelekVTrgovini)context.getParameters()[0];
        if(ivt.getTrgovina() == null || ivt.getIzdelek() == null || ivt.getZaloga() == null) {
            throw new NeveljavniIzdelekVTrgoviniIzjema("Eden izmed podatkov manjka");
        }

        return context.proceed();
    }
}
