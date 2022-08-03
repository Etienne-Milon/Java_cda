package controller;

import metier.Personne;
import metier.Repertoire;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Main extends Application {


    public static final String APP_NAME ="Gestion des contacts" ;
    private Stage primaryStage;
    public Stage getDialogueStage() {
        return dialogueStage;
    }
    private Stage dialogueStage;
    private BorderPane menuLayout;
    private Repertoire repertoire;



    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BorderPane getMenuLayout() {
        return menuLayout;
    }

    public void setMenuLayout(BorderPane menuLayout) {
        this.menuLayout = menuLayout;
    }
    public Repertoire getRepertoire() {
        return repertoire;
    }
    public void setRepertoire(File repertoire) {
        this.repertoire = new Repertoire(repertoire);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_NAME);
        try {
            FXMLLoader myFXMLloader = new FXMLLoader(Main.class.getResource("mainVue.fxml"));
            menuLayout = myFXMLloader.load();
            Scene scene = new Scene(menuLayout);
            scene.getStylesheets().add(getClass().getResource("/css/Style.css").toExternalForm());
            primaryStage.setScene(scene);
            MainController menuController = myFXMLloader.getController();
            menuController.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }

    public void repertoireChanged() {
        if (repertoire != null && repertoire.isModified()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(ButtonType.YES);
            alert.getButtonTypes().add(ButtonType.NO);
            // proposer la sauvegarde
        }
    }
    public void showGestionContact() {
        try {FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ContactsVue.fxml"));
        BorderPane contactOverview = loader.load();
        menuLayout.setCenter(contactOverview);
        ContactsController contactsController = loader.getController();
        contactsController.setMainApp(this);
        }
        catch(IOException e){e.printStackTrace();}
    }

    public void showModifContact(Personne personneSelected) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("modifContact.fxml"));
            GridPane modifContactOverview = loader.load();
            dialogueStage = new Stage();
            dialogueStage.setTitle("Ajouter/Modifier contact");
            dialogueStage.initModality(Modality.WINDOW_MODAL);
            dialogueStage.initOwner(primaryStage);
            Scene scene = new Scene(modifContactOverview);
            ModifContactController modifContactController = loader.getController();
            modifContactController.setPerson(personneSelected);
            modifContactController.setMainapp(this);
            dialogueStage.setScene(scene);
            dialogueStage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public void fermer() {
            repertoireChanged();
            repertoire=null;
            menuLayout.setCenter(null);
    }
}


