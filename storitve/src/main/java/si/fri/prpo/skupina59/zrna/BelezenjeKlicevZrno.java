package si.fri.prpo.skupina59.zrna;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.AroundInvoke;
import java.util.HashMap;
import java.util.logging.Logger;

@ApplicationScoped
public class BelezenjeKlicevZrno {

    private int vseMetode;
    private HashMap<String, Integer> specStevec;
    private static final Logger logger = Logger.getLogger(BelezenjeKlicevZrno.class.getName());


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
        logger.info("Globalni stevec metod je trenutno " + vseMetode);
        logger.info("Stevec za metodo " + funName + " je trenutno " + value);

    }

}
