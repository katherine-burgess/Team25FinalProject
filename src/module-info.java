module Team25FinalProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens application to javafx.graphics, javafx.fxml;
}
