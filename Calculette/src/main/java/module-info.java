module fr.em.calculette.calculette {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.em.calculette.calculette to javafx.fxml;
    exports fr.em.calculette.calculette;
}