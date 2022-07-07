module testFx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens fr.em.application to javafx.graphics, javafx.fxml;
}
