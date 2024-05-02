package pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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


	public static HBox email = new HBox(emailPrompt, e);
	public static HBox pass = new HBox(passwordPrompt, p);


	public static Button login=new Button("Login");
	
	public static VBox loginBox = new VBox();

	public static String emailInput;
	public static String passInput;
	
	public static void settings(Stage primaryStage) {
		
		email.setAlignment(Pos.CENTER);
		email.setSpacing(20);
		
		pass.setAlignment(Pos.CENTER);
		pass.setSpacing(20);

		login.setAlignment(Pos.CENTER);
		loginBox.getChildren().addAll(title, email, pass, login);
		loginBox.setAlignment(Pos.CENTER);
		loginBox.setSpacing(20);
	}
}
/*
 * Scanner scan=new Scanner(System.in);
 * try{
Connection con=database.getConnection(“databaseFilePath”, “student_email”, “password”);
String emailInput=getInputFromTextField;
String emailCheck=”SELECT * FROM students WHERE emailInput=””+usernameinput+””;
Statement isFound=con.createStatement();
ResultSet result=isFound.executeQuery(emailCheck);
if(isFound.next()){
	//login
	Else
	//page saying the user must enroll first
}
}catch(Exception e){
	System.out.println("ERROR: "+e.getMessage());
}
 */