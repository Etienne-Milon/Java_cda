module fr.em.selectiontable {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.kordamp.ikonli.javafx;

    opens fr.em.controller to javafx.fxml;
    exports fr.em.controller;
}