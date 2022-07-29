package fr.fs.sdbm;

import fr.fs.sdbm.metier.Article;
import fr.fs.sdbm.metier.Marque;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AjoutModifArticleController {

    private  MenuApp menuApp;
    Article article;
    @FXML
    private TextField biereTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField titrageTextField;
    @FXML
    private TextField marqueTextField;
    @FXML
    private TextField fabricantTextField;
    @FXML
    private TextField prixDAchatTextField;
    @FXML
    private TextField stockInitalTextField;



    @FXML
    private ComboBox typeComboBox;
    @FXML
    private ComboBox volumeComboBox;
    @FXML
    private ComboBox marqueComboBox;
    @FXML
    private ComboBox fabricantComboBox;
    @FXML
    private ComboBox paysComboBox;
    @FXML
    private ComboBox couleurComboBox;

    
    
    public void setArticle(Article article){
        if (article != null){
            this.article = article;
            biereTextField.setText(article.getLibelle());
            typeTextField.setText(article.getTypeBiere().getLibelle());
            titrageTextField.setText(String.valueOf(article.getTitrage().floatValue()));
            marqueTextField.setText(article.getMarque().getLibelle());
            fabricantTextField.setText(article.getMarque().getFabricant().getLibelle());
            prixDAchatTextField.setText(String.valueOf(article.getPrixAchat().floatValue()));
            stockInitalTextField.setText(String.valueOf(article.getStock()));
        }
        else
            System.out.println("Article is null");
    }

    public void ValiderModifArticle(){
        article.setAll(biereTextField.getText(),typeTextField.getText(),titrageTextField.getText(),marqueTextField.getText()
            ,fabricantTextField.getText(),prixDAchatTextField.getText(),stockInitalTextField.getText());
        Close();
                //TODO : verifier bon ordre et format
    }
    public void Close(){
        menuApp.getDialogueStage().close();
    }


    public void setMenuApp(MenuApp menuApp){
        this.menuApp = menuApp;
    }
    
    
    
    
}
