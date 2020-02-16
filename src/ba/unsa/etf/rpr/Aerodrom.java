package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Aerodrom implements Serializable {
    private String nazivAerodroma;
    private String grad;
    private String sifra;
    private double sirina;
    private double duzina;

    private boolean dobraSifra(String string){
        if(string.length()!=3){
            return false;
        }
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)<'A' || string.charAt(i)>'Z'){
                return false;
            }
        }
        return true;
    }

    private boolean engleskiAlfabet(String string){
        if(string.length()!=3){
            return false;
        }
        for(int i=0; i<string.length(); i++){
            if((string.charAt(i)<'A' || string.charAt(i)>'Z') && (string.charAt(i)<'a' || string.charAt(i)>'z')){
                return false;
            }
        }
        return true;
    }

    public Aerodrom() {
    }

    public Aerodrom(String nazivAerodroma, String grad, String sifra, double sirina, double duzina) throws IlegalnaSifraAerodroma {
        if(dobraSifra(sifra)) {
            this.nazivAerodroma = nazivAerodroma;
            this.grad = grad;
            this.sifra = sifra;
            this.sirina = sirina;
            this.duzina = duzina;
        }
        else{
            String predlozena="";
            if(engleskiAlfabet(sifra)){
                for(int i=0; i<sifra.length(); i++){
                    if(sifra.charAt(i)>='a' && sifra.charAt(i)<'z'){
                        predlozena+=sifra.charAt(i)-32;
                    }
                    else{
                        predlozena+=sifra.charAt(i);
                    }
                }
            }
            else{
                for(int i=0; i<3; i++){
                    if((grad.charAt(i)>='A' && grad.charAt(i)<='Z') || (grad.charAt(i)>='a' && grad.charAt(i)<='z')){
                        predlozena+=Character.toUpperCase(grad.charAt(i));
                    }
                }
            }
            throw new IlegalnaSifraAerodroma("Ilegalna sifra "+ sifra +", probajte " + predlozena);
        }
    }

    public String getNazivAerodroma() {
        return nazivAerodroma;
    }

    public void setNazivAerodroma(String nazivAerodroma) {
        this.nazivAerodroma = nazivAerodroma;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) throws IlegalnaSifraAerodroma {
        if(dobraSifra(sifra)) {
            this.sifra = sifra;
        }
        else{
            String predlozena="";
            if(sifra.length()==3 && engleskiAlfabet(sifra)){
                for(int i=0; i<sifra.length(); i++){
                    if(sifra.charAt(i)>='a' && sifra.charAt(i)<'z'){
                        predlozena+=sifra.charAt(i)-32;
                    }
                    else{
                        predlozena+=sifra.charAt(i);
                    }
                }
            }
            else{
                for(int i=0; i<3; i++){
                    if((grad.charAt(i)>='A' && grad.charAt(i)<='Z') || (grad.charAt(i)>='a' && grad.charAt(i)<'z')){
                        predlozena+=Character.toUpperCase(grad.charAt(i));
                    }
                }
            }
            throw new IlegalnaSifraAerodroma("Ilegalna sifra "+ sifra +", probajte " + predlozena);
        }
    }

    public double getSirina() {
        return sirina;
    }

    public void setSirina(double sirina) {
        this.sirina = sirina;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(double duzina) {
        this.duzina = duzina;
    }

}
