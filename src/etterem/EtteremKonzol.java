package etterem;

import java.io.IOException;
import java.util.ArrayList;


public class EtteremKonzol {
    public static void main(String[] args) throws IOException {
        new EtteremKonzol().program();
    }

    private void program() throws IOException {
        String separator = System.lineSeparator();
        Etterem  etterem = new Etterem();
        ArrayList<Asztal> asztalok = etterem.getAsztalok();
        for (Asztal asztal : asztalok) {
            asztalKiir(asztal.getSzin());
            konzolraIr(separator);
            vonalIr("-");
            konzolraIr(separator);
            for (int i = 0; i < asztal.getRendelesek().size(); i++) {
                if(i == asztal.getRendelesek().size()-1){
                    konzolraIr(asztal.getRendelesek().get(i).toString());
                } else {
                    konzolraIr(asztal.getRendelesek().get(i).toString());
                    konzolraIr(separator);
                }
            }
            konzolraIr(separator);
            vonalIr("=");
            konzolraIr(separator);
            konzolraIr("%-20s%5d%2s".formatted("Összesen:", asztal.getOsszAr(), Etterem.HUF));
            konzolraIr(separator);
            vonalIr("_");
            konzolraIr(separator);
        }
    }
    
    private void asztalKiir(String szin){
        konzolraIr(szin + " asztal:");
    }
    
    private void konzolraIr(String s){
        System.out.print(s);
    }
    
    private void vonalIr(String karakter){
        for (int i = 0; i < 27; i++) {
            konzolraIr(karakter);
        }
    }
}
