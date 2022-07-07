module fr.em.secusocialtextfield {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.em.secusocialtextfield to javafx.fxml;
    exports fr.em.secusocialtextfield;
}