package fr.em.maquette.maquette;

import fr.fs.dao.ParametreDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.util.*;

public class MainController {
    @FXML
    MenuItem enregistrer;
    @FXML
    MenuItem enregistrerSous;
    @FXML
    MenuItem fermer;
    @FXML
    MenuItem nouveau;
    @FXML
    MenuItem quitter;

    @FXML
    Menu recent;

    Boolean fichierOuvert = false;

    private Main mainApp;
    private ParametreDAO recents;

    @FXML
    private void initialize (){
        menuItemsDisable(true);
    }
    @FXML
    private void menuItemsDisable(boolean b) {
        enregistrer.setDisable(b);
        enregistrerSous.setDisable(b);
        fermer.setDisable(b);
    }
    @FXML
    public void fichierOuvrir(){
        if (Boolean.TRUE.equals(fichierOuvert))
        fichierFermer();
        mainApp.repertoireChanged();
        //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.getButtonTypes().clear();
        //alert.getButtonTypes().add(ButtonType.YES);
        //alert.getButtonTypes().add(ButtonType.CANCEL); // ???
        //Optional<ButtonType> result = alert.showAndWait();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner fichier");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files","*.txt"));
        fileChooser.setInitialDirectory(new File("C:\\Java\\dataSet"));
        File selectedFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (selectedFile != null){
            mainApp.getPrimaryStage().setTitle(Main.APP_NAME + " - " + selectedFile.getName());
            mainApp.setRepertoire(selectedFile);
            mainApp.getRepertoire().charger();
            mainApp.showGestionContact();
            menuItemsDisable(false);
            fichierOuvert = true;
        }
        recents.Sauver(); // todo : renvoi NullPointerException


    }
    @FXML
    private void fichierRecent(){
        List<String> lignes = new ArrayList<>();
        recents.getParametres().forEach((k,v)-> lignes.add(k+"="+v));
        lignes.sort(null);
        int i = 0;
        for (String ligne : lignes){
            i++;
            recent.getItems().add(i,new MenuItem(ligne));
        }
    }

    @FXML
    private void fichierFermer() {
        menuItemsDisable(true);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.setHeaderText("Enregistrer");
        alert.getButtonTypes().add(ButtonType.YES);
        alert.getButtonTypes().add(ButtonType.NO); // ???
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES)
            Enregistrer();
        mainApp.fermer();
        fichierOuvert = false;
    }
    @FXML
    private void fichierNouveau(){
        if (Boolean.TRUE.equals(fichierOuvert))
        fichierFermer();
        mainApp.repertoireChanged();
        //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.getButtonTypes().clear();
        //alert.getButtonTypes().add(ButtonType.YES);
        //alert.getButtonTypes().add(ButtonType.CANCEL); // ???
        //Optional<ButtonType> result = alert.showAndWait();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Creer nouveau");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files","*.txt"));
        fileChooser.setInitialDirectory(new File("C:\\Java\\dataSet"));
        File selectedFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (selectedFile != null){
            mainApp.getPrimaryStage().setTitle(Main.APP_NAME + " - " + selectedFile.getName());
            mainApp.setRepertoire(selectedFile);
            mainApp.getRepertoire().charger();
            mainApp.showGestionContact();
            menuItemsDisable(false);
            fichierOuvert = true;
    }
    }

    @FXML
    private void fichierQuitter(){
        Platform.exit();
    }

    @FXML
    private void Enregistrer(){
        mainApp.getRepertoire().enregistrer();
        recents.Sauver();
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }
}