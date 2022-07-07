package fr.fs.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParametreDAO {
    private FichierTexte parametreFile;
    private HashMap<String,String> parametres;


    public ParametreDAO() {
        parametreFile = new FichierTexte(new File(System.getProperty("user.home")+"\\contactFX.ini"));
        List<String> lignes = parametreFile.lire();
        parametres = new HashMap<>();
        for (String ligne : lignes){
            String[] cleValeur = ligne.split("=");
            parametres.put(cleValeur[0],cleValeur[1]);
        }
    }

    public HashMap<String,String> getParametres(){
        return parametres;
    }

    public void Sauver(){
        List<String> lignes = new ArrayList<>();
        parametres.forEach((k,v)-> lignes.add(k+"="+v));
        lignes.sort(null);
        parametreFile.ecrire(lignes);
    }

}
