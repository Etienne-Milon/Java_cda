package fr.fs;

import java.util.ArrayList;

public class Menu {

    String nomMenu;
    ArrayList<String> options = new ArrayList<>();

    public Menu(String nomMenu) {
        super();
        this.nomMenu = nomMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public void afficherMenu() {
        System.out.println();
        System.out.println("--------- " + nomMenu + " ----------");
        System.out.println();
        for(int i = 1; i < options.size(); i++) {
            System.out.println("[" + i + "] - " + options.get(i));
        }
        System.out.println("[0] - Quitter");
        System.out.println();
        System.out.printf("Saisissez une option : ");
    }
}


