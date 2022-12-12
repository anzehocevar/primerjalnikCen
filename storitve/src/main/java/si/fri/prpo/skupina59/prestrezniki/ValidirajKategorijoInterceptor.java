package si.fri.prpo.skupina59.prestrezniki;
import si.fri.prpo.skupina59.entitete.Izdelek;
import si.fri.prpo.skupina59.entitete.IzdelekVTrgovini;
import si.fri.prpo.skupina59.entitete.Kategorija;
import si.fri.prpo.skupina59.entitete.Trgovina;
import si.fri.prpo.skupina59.izjeme.NeveljavnaKategorijaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavnaTrgovinaIzjema;
import si.fri.prpo.skupina59.izjeme.NeveljavniIzdelekVTrgoviniIzjema;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ValidirajKategorijoInterceptor {

    @AroundInvoke
    public Object validirajKategorijo(InvocationContext context) throws Exception{
        if(context.getParameters().length != 1)
            throw new NeveljavnaKategorijaIzjema("Napacno stevilo parametrov");
        if(!(context.getParameters()[0] instanceof Kategorija)){
            throw new NeveljavnaKategorijaIzjema("Napacna vrsta parametra");
        }
        Kategorija k = (Kategorija) context.getParameters()[0];
        if(k.getOpis() == null || k.getIme() == null) {
            throw new NeveljavnaKategorijaIzjema("Eden izmed podatkov manjka");
        }
        return context.proceed();
    }
}
