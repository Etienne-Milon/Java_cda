package fr.fs.sdbm;

import fr.fs.sdbm.metier.*;
import fr.fs.sdbm.service.ArticleSearch;
import fr.fs.sdbm.service.ServiceArticle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.RangeSlider;


public class GestionArticleController {
    // Description de la table
    @FXML
    private TableView<Article> articleTable;
    @FXML
    private TableColumn<Article, Integer> idColumn;
    @FXML
    private TableColumn<Article, String> nomColumn;
    @FXML
    private TableColumn<Article,Integer> volumeColumn;
    @FXML
    private TableColumn<Article,String> titrageColumn;



    // description des champs de recherche
    @FXML
    private TextField libelleSearch;
    @FXML
    private ComboBox<Fabricant> fabricantSearch;
    @FXML
    private ComboBox<Pays> paysSearch;
    @FXML
    private ComboBox<Couleur> couleurSearch;
    @FXML
    private ComboBox<TypeBiere> typeBiereSearch;
    @FXML
    private ComboBox<Continent> continentSearch;
    @FXML
    private ComboBox<Marque> marqueSearch;

    // description des selecteurs

    @FXML
    private RadioButton volume33;
    @FXML
    private RadioButton volume75;
    @FXML
    private RangeSlider titrageRangeSlider;
    @FXML
    private RangeSlider prixRangeSlider;

    //labels
    @FXML
    private Label biereLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label couleurLabel;
    @FXML
    private Label titrageLabel;
    @FXML
    private Label volumeLabel;
    @FXML
    private Label marqueLabel;
    @FXML
    private Label fabricantLabel;
    @FXML
    private Label paysLabel;
    @FXML
    private Label continentLabel;


    @FXML
    private MenuApp menuApp;

    private ServiceArticle serviceArticle;
    private Article selectedArticle;

    public GestionArticleController() {
    }


    // Initialisation de la vue
    @FXML
    private void initialize() {

        serviceArticle = new ServiceArticle();
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().libelleProperty());
        volumeColumn.setCellValueFactory(cellData -> cellData.getValue().volumeProperty().asObject());
        titrageColumn.setCellValueFactory(cellData -> cellData.getValue().titrageProperty().asString());

        // Initialisation des comboBox
        continentSearch.setItems(FXCollections.observableArrayList(serviceArticle.getContinentFiltre()));
        continentSearch.getItems().add(0, new Continent(0, "Choisir un continent"));
        continentSearch.valueProperty().addListener(observable -> filterContinent());


        paysSearch.setItems(FXCollections.observableArrayList(serviceArticle.getPaysFiltre()));
        paysSearch.getItems().add(0, new Pays("", "Choisir un pays"));
        paysSearch.valueProperty().addListener(observable -> filterArticle());

        fabricantSearch.setItems(FXCollections.observableArrayList(serviceArticle.getFabricantFiltre()));
        fabricantSearch.getItems().add(0, new Fabricant(0, "Choisir un fabricant"));
        fabricantSearch.valueProperty().addListener(observable -> filterArticle());

        couleurSearch.setItems(FXCollections.observableArrayList(serviceArticle.getCouleurFiltre()));
        couleurSearch.getItems().add(0, new Couleur(0, "Choisir une couleur"));
        couleurSearch.valueProperty().addListener(observable -> filterArticle());

        typeBiereSearch.setItems(FXCollections.observableArrayList(serviceArticle.getTypeBieresFiltre()));
        typeBiereSearch.getItems().add(0, new TypeBiere(0, "Choisir un type de biere"));
        typeBiereSearch.valueProperty().addListener(observable -> filterArticle());

        // Initialisation des RangeSliders
        titrageRangeSlider.setMin(0);
        titrageRangeSlider.setMax(26);
        titrageRangeSlider.setHighValue(26);
        titrageRangeSlider.setBlockIncrement(1);
        titrageRangeSlider.highValueProperty().addListener(observable -> filterArticle());
        titrageRangeSlider.lowValueProperty().addListener(observable -> filterArticle());

        prixRangeSlider.setMin(0);
        prixRangeSlider.setMax(5);
        prixRangeSlider.setHighValue(5);
        prixRangeSlider.setBlockIncrement(0.1);
        prixRangeSlider.highValueProperty().addListener(observable -> filterArticle());
        prixRangeSlider.lowValueProperty().addListener(observable -> filterArticle());


        // Initialisation des TextFields
        libelleSearch.textProperty().addListener(observable -> filterArticle());

        // Initialisation des RadioButtons
        volume33.setSelected(true);
        volume75.setSelected(true);

        //tableView
        articleTable.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)-> afficherArticle(newvalue));

        selectedArticle = articleTable.getSelectionModel().getSelectedItem();
    }

    private void afficherArticle(Article newvalue) {
        biereLabel.setText(newvalue.getLibelle());
        typeLabel.setText(newvalue.getTypeBiere().getLibelle());
        couleurLabel.setText(newvalue.getCouleur().getLibelle());
        titrageLabel.setText(String.valueOf(newvalue.getTitrage().floatValue()));
        volumeLabel.setText(String.valueOf(newvalue.getVolume().intValue()));
        marqueLabel.setText(newvalue.getMarque().getLibelle());
        fabricantLabel.setText(newvalue.getMarque().getFabricant().getLibelle());
        paysLabel.setText(newvalue.getMarque().getPays().getLibelle());
        continentLabel.setText(newvalue.getMarque().getPays().getContinent().getLibelle());
        selectedArticle = newvalue;
    }

    public void setMenuApp(MenuApp menuApp) {
        this.menuApp = menuApp;
        filterArticle();
    }

    private void filterContinent() {
        if (continentSearch.getSelectionModel().getSelectedItem() != null
                && (continentSearch.getSelectionModel().getSelectedItem()).getId() != 0) {
            paysSearch.setItems(FXCollections.observableArrayList(
                    (continentSearch.getSelectionModel().getSelectedItem()).getPays()));
        } else {
            paysSearch.setItems(FXCollections.observableArrayList(serviceArticle.getPaysFiltre()));
        }
        paysSearch.getItems().add(0, new Pays("", "Choisir un pays", new Continent()));
        paysSearch.getSelectionModel().select(0);
        filterArticle();
    }

    @FXML
    private void filterArticle() {
        ArticleSearch articleSearch = new ArticleSearch();
        articleSearch.setLibelle(libelleSearch.getText());
        if(volume33.isSelected()&&!volume75.isSelected())
            articleSearch.setVolume(33);
        if(!volume33.isSelected()&&volume75.isSelected())
            articleSearch.setVolume(75);
        if(volume33.isSelected()&&volume75.isSelected())
            articleSearch.setVolume(0);
        if(!volume33.isSelected()&&!volume75.isSelected())
            articleSearch.setVolume(1);
        if (paysSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setPays(paysSearch.getSelectionModel().getSelectedItem());
        if (continentSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setContinent(continentSearch.getSelectionModel().getSelectedItem());
        if (fabricantSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setFabricant(fabricantSearch.getSelectionModel().getSelectedItem());
        if (couleurSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setCouleur(couleurSearch.getSelectionModel().getSelectedItem());
        if (typeBiereSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setTypeBiere(typeBiereSearch.getSelectionModel().getSelectedItem());
        if (marqueSearch.getSelectionModel().getSelectedItem() != null)
            articleSearch.setMarque(marqueSearch.getSelectionModel().getSelectedItem());
        articleSearch.setTitrageMin(titrageRangeSlider.getLowValue());
        articleSearch.setTitrageMax(titrageRangeSlider.getHighValue());

        articleTable.setItems(FXCollections.observableArrayList(serviceArticle.getFilteredArticles(articleSearch)));
    }

    @FXML
    private void update(){
        menuApp.showAjoutModifArticle(selectedArticle);
    }


}
