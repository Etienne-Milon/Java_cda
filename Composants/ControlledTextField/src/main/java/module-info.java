module fr.em.controlledtextfield {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.em.controlledtextfield to javafx.fxml;
    exports fr.em.controlledtextfield;
}