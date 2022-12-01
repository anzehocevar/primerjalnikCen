package si.fri.prpo.skupina59.zrna;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.AroundInvoke;

@ApplicationScoped
public class BelezenjeKlicevZrno {

    private int vseMetode;

    public void povecajGlobalniStevec(){
        ++vseMetode;
    }

    public int getGlobalniStevec() { return vseMetode; }
}
