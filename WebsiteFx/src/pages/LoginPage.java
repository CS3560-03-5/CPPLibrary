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

public class LoginPage {
	public static Label title = new Label("Cal Poly Pomona Library");
	public static Label usernamePrompt = new Label("Username:");
	public static Label passwordPrmpt = new Label("Password:");

	

	public static TextField u =new TextField();
	public static TextField p =new TextField();

	public static Button login=new Button();
	
	public static VBox loginBox = new VBox();
	public static void settings(Stage primaryStage) {
		//s.setTitle("Login Page");
		login.setText("login");
		login.setTranslateX(333);
		login.setTranslateY(254);
	}
}