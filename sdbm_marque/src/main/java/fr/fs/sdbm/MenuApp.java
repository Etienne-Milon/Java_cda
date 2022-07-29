package fr.fs.sdbm;


import fr.fs.sdbm.metier.Article;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuApp extends Application {
    private Stage primaryStage;
    private Stage dialogueStage;

    public Stage getDialogueStage(){
        return dialogueStage;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion des Marques");
        showMarque();
    }

    private void showMarque() {
        try {
            // Chargement du fichier fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuApp.class.getResource("GestionArticle.fxml"));
            AnchorPane menuLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(menuLayout);
            primaryStage.setScene(scene);

            GestionArticleController controller = loader.getController();
            controller.setMenuApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAjoutModifArticle(Article articleSelected){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuApp.class.getResource("AjoutModifArticle.fxml"));
            AnchorPane AjoutModifContactOverview = loader.load();
            dialogueStage = new Stage();
            dialogueStage.setTitle("Ajouter/modifier article");
            dialogueStage.initModality(Modality.WINDOW_MODAL);
            dialogueStage.initOwner(primaryStage);
            Scene scene = new Scene(AjoutModifContactOverview);
            AjoutModifArticleController ajoutModifArticleController = loader.getController();
            ajoutModifArticleController.setArticle(articleSelected);
            ajoutModifArticleController.setMenuApp(this);
            dialogueStage.setScene(scene);
            dialogueStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }
}
