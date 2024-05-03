package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

	public static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";//"root@localhost:3306/CPP_Library";//"root@127.0.0.1:3306";//"jdbc:mysql://127.0.0.1:3306/?user=root";//"jdbc:mysql://localhost:3306/CPP_Library";
    public static String user = "root";
    public static String pwd = "root";
	
	public static void settings(Stage primaryStage) {
		
		email.setAlignment(Pos.CENTER);
		email.setSpacing(20);
		
		pass.setAlignment(Pos.CENTER);
		pass.setSpacing(20);

		login.setAlignment(Pos.CENTER);
		loginBox.getChildren().addAll(title, email, pass, login);
		loginBox.setAlignment(Pos.CENTER);
		loginBox.setSpacing(20);


		
		/* try{
			Connection c = DriverManager.getConnection(url, user, pwd);
		
			
			String query = "SELECT *"
							+"FROM users"
							+"WHERE broncoID =" + emailInput + " AND password = " + passInput + ";";
			Statement isFound= c.createStatement();
			ResultSet result= isFound.executeQuery(query);
		if(result.next()){
			//login
			System.out.println("Match");
			//page saying the user must enroll first
		}
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
		} */
	}
}

  
