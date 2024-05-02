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
	public static Label emailPrompt = new Label("Email:");
	public static Label passwordPrompt = new Label("Password:");

	

	public static TextField e =new TextField();
	public static TextField p =new TextField();


	public static HBox email = new HBox(emailPrompt, u);
	public static HBox pass = new HBox(passwordPrompt, p);


	public static Button login=new Button("Login");
	
	public static VBox loginBox = new VBox();
	public static void settings(Stage primaryStage) {
		

		loginBox.getChildren().addAll(title, user, pass, login);
	}
}
/*
 * Scanner scan=new Scanner(System.in);
Connection con=database.getConnection(“databaseFilePath”, “student_email”, “password”);
String usernameInput=getInputFromTextField;
String usernameCheck=”SELECT * FROM students WHERE usernameInput=””+usernameinput+””;
Statement isFound=con.createStatement();
ResultSet result=isFound.executeQuery(usernameCheck);
if(isFound.next()){
	//login
	Else
	//page saying the user must enroll first
}
 */