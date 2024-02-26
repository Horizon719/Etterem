package etterem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Etterem {
    public static final String HUF = "Ft";
    
    private ArrayList<Asztal> asztalok;
    private ArrayList<Etel> etlap;
    
    public Etterem() throws IOException{
        this.etlap = new ArrayList<>();
        etlapotFajlbolFeltolt();
        this.asztalok = new ArrayList<>();
        rendelesekFajlbolFeltolt();
    }

    public ArrayList<Asztal> getAsztalok() {
        return asztalok;
    }
    
    public void etlapotFajlbolFeltolt() throws IOException{
        ArrayList<String> etelekFile = (ArrayList<String>) Files.readAllLines(Path.of("etelek.txt"));
        for (String sor : etelekFile) {
            String sorElemek[] = sor.split("\\|");
            Etel etel = new Etel(sorElemek[0], Integer.parseInt(sorElemek[1]));
            etlap.add(etel);
        }
    }
    
    public void rendelesekFajlbolFeltolt() throws IOException{
        ArrayList<String> rendelesekFile = (ArrayList<String>) Files.readAllLines(Path.of("rendeles.txt"));
        boolean asztalE = true;
        int asztalSzamlalo = 0;
        for (int i = 0; i < rendelesekFile.size(); i++) {
            
            if (asztalE) {
                asztalok.add(new Asztal(rendelesekFile.get(i)));
                asztalE = false;
            } else if( rendelesekFile.get(i).isBlank()){
                asztalE = true;
                asztalSzamlalo++;
            } else {
                asztalok.get(asztalSzamlalo).ujEtel(rajtaAzEtlapon(rendelesekFile.get(i)));
            }
        }
    }

    public Etel rajtaAzEtlapon(String etelNev){
        for (Etel etel : etlap) {
            if (etel.getNev().equals(etelNev)) {
                return etel;
            }
        }
        return null;
    }
}
