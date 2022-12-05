package si.fri.prpo.skupina59.zrna;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.AroundInvoke;
import java.util.HashMap;

@ApplicationScoped
public class BelezenjeKlicevZrno {

    private int vseMetode;
    private HashMap<String, Integer> specStevec;

    public BelezenjeKlicevZrno(){
        vseMetode = 0;
        specStevec = new HashMap<>();
    }

    public void povecajStevce(String funName){
        ++vseMetode;
        int value = 1;
        if(specStevec.containsKey(funName)){
            value = specStevec.get(funName) + 1;
        }
        specStevec.put(funName, value);

    }

    public int getGlobalniStevec() { return vseMetode; }

    public int getSpecStevec(String funName){
        return specStevec.get(funName);
    }
}
