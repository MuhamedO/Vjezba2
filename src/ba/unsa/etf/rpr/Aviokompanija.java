package ba.unsa.etf.rpr;

import javax.naming.SizeLimitExceededException;
import java.time.LocalTime;
import java.util.*;

public class Aviokompanija {
    private int kapacitet;
    private List<Let> letovi = new ArrayList<>();
    private int brojLetova=0;

    public Aviokompanija(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int brojLetova(){
        return brojLetova;
    }

    public void registrujLet(Aerodrom polazniAerodrom, Aerodrom dolazniAerodrom, LocalTime polaznoVrijeme, LocalTime dolaznoVrijeme, boolean brzi) throws SizeLimitExceededException {
        if(brojLetova==kapacitet){
            throw new SizeLimitExceededException("Prekoračen broj maksimalnih letova");
        }
        if(brzi){
            BrziLet noviLet = new BrziLet(polazniAerodrom, dolazniAerodrom, polaznoVrijeme, dolaznoVrijeme);
            letovi.add(noviLet);
            brojLetova++;
        }
        else{
            Let noviLet = new Let(polazniAerodrom, dolazniAerodrom, polaznoVrijeme, dolaznoVrijeme);
            letovi.add(noviLet);
            brojLetova++;
        }
    }

    public Map<String, List<Let>> dolazniLetovi() {
        Map<String, List<Let>> mapa = new HashMap<>();
        for(Let l : letovi){
            List<Let> letoviPoGradu;
            letoviPoGradu=mapa.get(l.getDolazniAerodrom().getGrad());
            if(letoviPoGradu.size()==0){
                letoviPoGradu.add(l);
                mapa.put(l.getDolazniAerodrom().getGrad(), letoviPoGradu);
            }
            else{
                mapa.get(l.getDolazniAerodrom().getGrad()).add(l);
            }
        }
        return mapa;
    }

    public Set<Let> uZraku(LocalTime vrijeme) {
        Set<Let> skup = new TreeSet<>();
        for(Let l: letovi){
            if(vrijeme.isAfter(l.getVrijemePolaska()) && vrijeme.isBefore(l.getVrijemeDolaska())){
                skup.add(l);
            }
        }
        return skup;
    }
}
