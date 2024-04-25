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
    
    static MenuButton studentOptions = new MenuButton("Students");
    static MenuItem borrowedBooks = new MenuItem("Borrowed Books");
    static MenuItem fees = new MenuItem("Fees");
    static MenuItem requests = new MenuItem("Requests");
    static MenuItem logIn = new MenuItem("Log In");
    
    static VBox studentOptionsBox = new VBox(studentOptions);

    static Label home = new Label("Home");
    static VBox homeBox = new VBox(home);

    static Label books = new Label("Books");
    
    static MenuButton librarian = new MenuButton("Librarians");
    static MenuItem chat = new MenuItem("24/7 Chat");
    static MenuItem guides = new MenuItem("Guides");

    static Label studyRooms = new Label("StudyRooms");

    static HBox middleOptions = new HBox(books, librarian, studyRooms);

    public static HBox topOfPane = new HBox(homeBox, middleOptions, studentOptionsBox);

    static Label searchPrompt = new Label("Search");
    static TextField searchField = new TextField("Enter a Book, Author, or Publisher");
    static HBox search = new HBox(searchPrompt, searchField);

    static Button libraryChat = new Button("Chat with a Librarian");
    static Button studyRoom = new Button("Reserve a Study Room");

    public static VBox frontPage = new VBox(search, libraryChat, studyRoom);

    
    public static void settings(Stage primaryStage) {

        studentOptions.getItems().addAll(borrowedBooks, requests, fees, logIn);

        studentOptionsBox.setPadding(new Insets(0, 0, 0, 200));

        homeBox.setAlignment(Pos.CENTER_RIGHT);
        homeBox.setPadding(new Insets(0, 200, 0, 0));
        
        librarian.getItems().addAll(chat, guides);

        middleOptions.setSpacing(50);
    
        topOfPane.setAlignment(Pos.CENTER);
                
        search.setSpacing(10);
        search.setAlignment(Pos.CENTER);

        frontPage.setSpacing(50); //spacing between front page elements
        frontPage.setPadding(new Insets(75,0,0,0)); // spacing on top of frontpage (away from bp's top)
        //frontPage.setAlignment(Pos.CENTER);
        frontPage.setAlignment(Pos.TOP_CENTER);
        
    }
}
