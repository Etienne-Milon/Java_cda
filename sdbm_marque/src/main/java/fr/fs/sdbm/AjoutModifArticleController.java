package fr.fs.sdbm;

import fr.fs.sdbm.metier.*;
import fr.fs.sdbm.service.ServiceArticle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.SearchableComboBox;

import java.math.BigDecimal;


public class AjoutModifArticleController {

    private  MenuApp menuApp;
    Article article;
    private ServiceArticle serviceArticle;
    @FXML
    private TextField biereTextField;
    @FXML
    private TextField titrageTextField;
    @FXML
    private TextField prixDAchatTextField;
    @FXML
    private TextField stockInitalTextField;




    @FXML
    private SearchableComboBox typeBiereSCB;

    @FXML
    private SearchableComboBox volumeSCB;

    @FXML
    private SearchableComboBox marqueSCB;

    @FXML
    private SearchableComboBox couleurSCB;

    @FXML
    private SearchableComboBox fabricantSCB;

    @FXML
    private SearchableComboBox paysSCB;


    @FXML
    private void initialize() {
        serviceArticle = new ServiceArticle();
    // Initialisation de la vue
    // Initialisation des comboBox
        if(serviceArticle.getTypeBieresFiltre() != null)
            typeBiereSCB.setItems(FXCollections.observableArrayList(serviceArticle.getTypeBieresFiltre()));
        volumeSCB.setItems(FXCollections.observableArrayList(33,75));
        marqueSCB.setItems(FXCollections.observableArrayList(serviceArticle.getMarqueFiltre()));
        fabricantSCB.setItems((FXCollections.observableArrayList(serviceArticle.getFabricantFiltre())));
        paysSCB.setItems(FXCollections.observableArrayList(serviceArticle.getPaysFiltre()));
        couleurSCB.setItems(FXCollections.observableArrayList(serviceArticle.getCouleurFiltre()));
    }
    public void setArticle(Article article){
        if (article != null){
            //this.article = article;
            biereTextField.setText(article.getLibelle());
            titrageTextField.setText(String.valueOf(article.getTitrage().floatValue()));

            typeBiereSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getTypeBiere()));
            volumeSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getVolume()));
            marqueSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getMarque()));
            fabricantSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getMarque().getFabricant()));
            paysSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getMarque().getPays()));
            couleurSCB.getSelectionModel().select(FXCollections.observableArrayList(article.getCouleur()));
            prixDAchatTextField.setText(String.valueOf(article.getPrixAchat().floatValue()));
            stockInitalTextField.setText(String.valueOf(article.getStock()));
        }
        else {
            //System.out.println("Article is null");
            typeBiereSCB.getItems().add(0, new TypeBiere(0, "Choisir un type"));
            typeBiereSCB.getSelectionModel().select(0);
            volumeSCB.getItems().add(0, "Choisir un volume");
            volumeSCB.getSelectionModel().select(0);
            marqueSCB.getItems().add(0, new Marque(0, "Choisir une marque"));
            marqueSCB.getSelectionModel().select(0);
            fabricantSCB.getItems().add(0, new Fabricant(0, "Choisir un fabricant"));
            fabricantSCB.getSelectionModel().select(0);
            paysSCB.getItems().add(0, new Pays("", "Choisir un pays"));
            paysSCB.getSelectionModel().select(0);
            couleurSCB.getItems().add(0,new Couleur(0,"Choisir une couleur"));
            couleurSCB.getSelectionModel().select(0);
        }
    }


    public void ValiderArticle(){

        article.setAll(
                biereTextField.getText(),
                new BigDecimal(prixDAchatTextField.getText()),
                Integer.parseInt(volumeSCB.getAccessibleText()),
                Float.parseFloat(titrageTextField.getText()),
                marqueSCB.getId(),  //TODO : verifier si bon id
                couleurSCB.getId(),
                typeBiereSCB.getId(),
                Integer.parseInt(stockInitalTextField.getText()));
        serviceArticle.InsertArticle(article);
        Close();

    }

    public void Annuler(){
        Close();
    }

    public void Close(){
        menuApp.getDialogueStage().close();
    }


    public void setMenuApp(MenuApp menuApp){
        this.menuApp = menuApp;
    }
    
    
    
    
}
