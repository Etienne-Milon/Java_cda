module fr.em.maquette.maquette {
    requires javafx.controls;
    requires javafx.fxml;
    requires fr.em.controlledtextfield;
    requires fr.em.secusocialtextfield;

    opens fr.em.maquette.maquette to javafx.fxml;
    exports fr.em.maquette.maquette;
}