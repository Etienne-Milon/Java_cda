package fr.em.maquette.maquette;

import fr.fs.metier.Personne;
import fr.fs.metier.Repertoire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactsController {

    @FXML
    private TableView<Personne> contactsTable;
    @FXML
    private TableColumn<Personne,String> nomColumn;
    @FXML
    private TableColumn<Personne,String> prenomColumn;
    @FXML
    private TableColumn<Personne,String>numeroColumn;
    @FXML
    private TextField textFieldrecherche;
    @FXML
    private Label nomDetail;
    @FXML
    private Label prenomDetail;
    @FXML
    private Label telDetail;

    private Personne personneSelected;

    private Main mainApp;

    @FXML
    private void initialize(){
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getprenomProperty());
        numeroColumn.setCellValueFactory(cellData -> cellData.getValue().getTelephoneProperty());

        contactsTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> afficherDetailContact(newValue));
        textFieldrecherche.textProperty().addListener((observable,oldValue,newValue) ->  mainApp.getRepertoire().filtrerContact(newValue));
        detailVisible(false);


    }

    public void AjouterContact(){
        Personne personne = new Personne("","","");
        personneSelected = personne;
        ModifierContact();
        mainApp.getRepertoire().ajouter(personneSelected);
    }

    public void SupprimerContact(){
        mainApp.getRepertoire().supprimer(personneSelected);
    }


    public void ModifierContact(){
        if(personneSelected != null){
            mainApp.showModifContact(personneSelected);
            String newValue = textFieldrecherche.getText();
            mainApp.getRepertoire().filtrerContact(newValue);
            afficherDetailContact(personneSelected);
        }
    }

    private void detailVisible(boolean b) {
    }

    private void afficherDetailContact(Personne personne) {
        personneSelected = personne;
        nomDetail.setText(personne.getNom());
        prenomDetail.setText(personne.getPrenom());
        telDetail.setText(personne.getTelephone());
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        contactsTable.setItems(mainApp.getRepertoire().getContacts());
        mainApp.getRepertoire().getContacts().comparatorProperty().bind(contactsTable.comparatorProperty());
    }



}
