package ba.unsa.etf.rpr;

import java.time.LocalTime;

public class BrziLet extends Let {
    public BrziLet(Aerodrom polazniAerodrom, Aerodrom dolazniAerodrom, LocalTime polaznoVrijeme, LocalTime dolaznoVrijeme) {
        super(polazniAerodrom, dolazniAerodrom, polaznoVrijeme, dolaznoVrijeme);
    }

    @Override
    public double duzinaLeta() {
        return super.duzinaLeta()/2;
    }
}
