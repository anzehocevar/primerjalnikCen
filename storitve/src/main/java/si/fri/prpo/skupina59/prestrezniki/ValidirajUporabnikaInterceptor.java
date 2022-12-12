package si.fri.prpo.skupina59.prestrezniki;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.entitete.Uporabnik;
import si.fri.prpo.skupina59.izjeme.NeveljavnaTrgovinaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniUporabnikIzjema;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ValidirajUporabnikaInterceptor {

    @AroundInvoke
    public Object validirajUporabnika(InvocationContext context) throws Exception{
        if(context.getParameters().length != 1)
            throw new NeveljavniUporabnikIzjema("Napacno stevilo parametrov");
        if(!(context.getParameters()[0] instanceof Uporabnik)){
            throw new NeveljavniUporabnikIzjema("Napacna vrsta parametra");
        }
        Uporabnik u = (Uporabnik) context.getParameters()[0];
        if(u.getIme() == null || u.getPriimek() == null || u.getUporabnisko_ime() == null || u.getEmail() == null) {
            throw new NeveljavniUporabnikIzjema("Eden izmed podatkov manjka");
        }
        return context.proceed();
    }
}
