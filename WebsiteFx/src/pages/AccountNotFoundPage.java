package pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountNotFoundPage {
	public static VBox messageBox = new VBox();
	public static Label message = new Label("This account does not exist.");
	public static Label backToLogin = new Label("< Go back to Log in");

	public static void settings(Stage primaryStage) {
		messageBox.getChildren().addAll(message, new Separator(Orientation.HORIZONTAL), backToLogin);
		messageBox.setAlignment(Pos.CENTER);
	}

}
