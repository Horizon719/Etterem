package etterem;

import java.util.ArrayList;

public class Asztal {
    private String szin;
    private ArrayList<Etel> rendelesek;
    
    public Asztal(String szin){
        this.szin = szin;
        this.rendelesek = new ArrayList<>();
    }

    public String getSzin() {
        return szin;
    }

    public void ujEtel(Etel etel){
        rendelesek.add(etel);
    }
    
    public ArrayList<Etel> getRendelesek() {
        return rendelesek;
    }
    
    public int getOsszAr(){
        int osszeg = 0;
        for (Etel etel : rendelesek) {
            osszeg += etel.getAr();
        }
        return osszeg;
    }
}
