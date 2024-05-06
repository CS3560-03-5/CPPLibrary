package pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FrontPage extends Application {
    
    public static MenuButton studentOptions = new MenuButton("Students");
    public static MenuItem borrowedBooks = new MenuItem("Borrowed Books");
    public static MenuItem fees = new MenuItem("Fees");
    public static MenuItem requests = new MenuItem("Requests");
    public static MenuItem logIn = new MenuItem("Log In");
    public static MenuItem logOut = new MenuItem("Log out");
    
    public static VBox studentOptionsBox = new VBox(studentOptions);

    public static Label home = new Label("Home");
    public static VBox homeBox = new VBox(home);

    public static Label books = new Label("Books");
    
    public static MenuButton librarian = new MenuButton("Librarians");
    public static MenuItem chat = new MenuItem("24/7 Chat");
    public static MenuItem guides = new MenuItem("Guides");

    public static Label studyRooms = new Label("StudyRooms");

    public static HBox middleOptions = new HBox(books, librarian, studyRooms);

    public static HBox topOfPane = new HBox(homeBox, middleOptions, studentOptionsBox);

    public static Label searchPrompt = new Label("Search");
    public static TextField searchField = new TextField();
    public static HBox search = new HBox(searchPrompt, searchField);

    public static Button libraryChat = new Button("Chat with a Librarian");
    public static Button studyRoom = new Button("Reserve a Study Room");

    public static VBox frontPage = new VBox(search, libraryChat, studyRoom);

    
    public static void settings(Stage primaryStage) {

        searchField.setPromptText("Enter Book or Author");
        studentOptions.getItems().addAll(borrowedBooks, requests, fees, /*logIn,*/ logOut);

        studentOptionsBox.setPadding(new Insets(0, 0, 0, 200));

        homeBox.setAlignment(Pos.CENTER_RIGHT);
        homeBox.setPadding(new Insets(0, 200, 0, 0));
        
        librarian.getItems().addAll(chat, guides);

        middleOptions.setSpacing(50);
    
        topOfPane.setAlignment(Pos.CENTER);
        topOfPane.setPadding(new Insets(0, 0, 20, 0));
                
        search.setSpacing(10);
        search.setAlignment(Pos.CENTER);

        frontPage.setSpacing(50); //spacing between front page elements
        frontPage.setPadding(new Insets(75,0,0,0)); // spacing on top of frontpage (away from bp's top)
        frontPage.setAlignment(Pos.TOP_CENTER);
        
    }
}
