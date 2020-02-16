package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Let implements Serializable, Comparable<Let> {
    private Aerodrom polazniAerodrom;
    private Aerodrom dolazniAerodrom;
    private LocalTime vrijemePolaska;
    private LocalTime vrijemeDolaska;

    public Let(Aerodrom polazniAerodrom, Aerodrom dolazniAerodrom, LocalTime vrijemePolaska, LocalTime vrijemeDolaska) {
        this.polazniAerodrom = polazniAerodrom;
        this.dolazniAerodrom = dolazniAerodrom;
        this.vrijemePolaska = vrijemePolaska;
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public Let() {
    }

    public Aerodrom getPolazniAerodrom() {
        return polazniAerodrom;
    }

    public void setPolazniAerodrom(Aerodrom polazniAerodrom) {
        this.polazniAerodrom = polazniAerodrom;
    }

    public Aerodrom getDolazniAerodrom() {
        return dolazniAerodrom;
    }

    public void setDolazniAerodrom(Aerodrom dolazniAerodrom) {
        this.dolazniAerodrom = dolazniAerodrom;
    }

    public LocalTime getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(LocalTime vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public LocalTime getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(LocalTime vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }


    public int trajanje() {
        double rezultat=MINUTES.between(vrijemePolaska, vrijemeDolaska);
        return (int) rezultat;
    }

    public double duzinaLeta() {
        //Znam da Zemlja nije ravna ploča, ali radi jednostavnosti ćemo koristiti euklidsku udaljenost.
        double rezultat=Math.sqrt(Math.pow(polazniAerodrom.getDuzina()-dolazniAerodrom.getDuzina(),2)+Math.pow(polazniAerodrom.getSirina()-dolazniAerodrom.getSirina(),2));
        return rezultat;
    }

    @Override
    public int compareTo(Let o) {
        if(vrijemePolaska.isBefore(o.vrijemePolaska)){
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Let) {
            Let l = (Let) obj;
            return (polazniAerodrom.equals(l.getPolazniAerodrom()) && dolazniAerodrom.equals(l.getDolazniAerodrom()) &&
                    vrijemePolaska.equals(l.getVrijemePolaska()) && vrijemeDolaska.equals(l.getVrijemeDolaska()));
        }
        return false;
    }
    @Override
    public int hashCode() {
        return (polazniAerodrom.getGrad().hashCode() * dolazniAerodrom.getGrad().hashCode()*vrijemePolaska.hashCode()*vrijemeDolaska.hashCode());
    }
}
