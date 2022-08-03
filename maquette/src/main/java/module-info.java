module fr.em.maquette.maquette {
    requires javafx.controls;
    requires javafx.fxml;
    requires fr.em.controlledtextfield;
    requires fr.em.secusocialtextfield;

    opens controller to javafx.fxml;
    exports controller;
}