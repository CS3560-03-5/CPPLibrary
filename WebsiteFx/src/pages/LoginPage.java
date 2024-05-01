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
	public static Label passwordPrompt = new Label("Password:");

	

	public static TextField u =new TextField();
	public static TextField p =new TextField();


	public static HBox user = new HBox(usernamePrompt, u);
	public static HBox pass = new HBox(passwordPrompt, p);


	public static Button login=new Button("Login");
	
	public static VBox loginBox = new VBox();
	public static void settings(Stage primaryStage) {
		//s.setTitle("Login Page");
		/*login.setText("login");
		login.setTranslateX(333);
		login.setTranslateY(254);
		u.setTranslateX(196);
		u.setTranslateY(167);
		p.setTranslateX(196);
		p.setTranslateY(212);
		usernamePrompt.setTranslateX(122);
		usernamePrompt.setTranslateY(171);
		passwordPrompt.setTranslateX(122);
		passwordPrompt.setTranslateY(208);
		title.setTranslateX(178);
		title.setTranslateY(59);*/

		loginBox.getChildren().addAll(title, user, pass, login);
	}
}