package etterem;

public class Etel {
    private String nev;
    private int ar;
    
    public Etel(String nev, int ar){
        this.nev = nev;
        this.ar = ar;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    @Override
    public String toString() {
        return "%-20s%5d%2s".formatted(nev, ar, Etterem.HUF);
    }    
}
