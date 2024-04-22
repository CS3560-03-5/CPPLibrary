import java.beans.EventHandler;

import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) {
           /* Button btn = new Button();
            btn.setText("Say 'HelloWorld'");
            btn.setOnAction(event -> {
                
                
                System.out.println("Hello World!");
                
            });

            StackPane root = new StackPane();
            root.getChildren().add(btn);

            Scene scene = new Scene(root, 300, 250);*/
            BorderPane bp = new BorderPane();
            bp.setPadding(new Insets(20));
            
            

            //fitting borderpane to window
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            bp.setMaxWidth(bounds.getMinX());
            bp.setMaxHeight(bounds.getMinY());
           
            //menu items
            MenuButton studentOptions = new MenuButton("Students");
            MenuItem borrowedBooks = new MenuItem("Borrowed Books");
            MenuItem fees = new MenuItem("Fees");
            MenuItem requests = new MenuItem("Requests");
            MenuItem logIn = new MenuItem("Log In");
            
            studentOptions.getItems().addAll(borrowedBooks, requests, fees, logIn);

            VBox studentOptionsBox = new VBox(studentOptions);
            studentOptionsBox.setPadding(new Insets(0, 0, 0, 100));

            Label home = new Label("Home");
            VBox homeBox = new VBox(home);
            homeBox.setAlignment(Pos.CENTER_RIGHT);
            homeBox.setPadding(new Insets(0, 100, 0, 0));

            
            Label books = new Label("Books");
           
            MenuButton librarian = new MenuButton("Librarians");
            MenuItem chat = new MenuItem("24/7 Chat");
            MenuItem guides = new MenuItem("Guides");
            librarian.getItems().addAll(chat, guides);

            Label studyRooms = new Label("StudyRooms");

            HBox middleOptions = new HBox(books, librarian, studyRooms);
            middleOptions.setSpacing(50);
           

            HBox topOfPane = new HBox(homeBox, middleOptions, studentOptionsBox);
            topOfPane.setAlignment(Pos.CENTER);
           
            bp.setTop(topOfPane);

            Label searchPrompt = new Label("Search");
            TextField searchField = new TextField("Enter a Book, Author, or Publisher");
            HBox search = new HBox(searchPrompt, searchField);
            search.setSpacing(10);
            search.setAlignment(Pos.CENTER);

            Button libraryChat = new Button("Chat with a Librarian");
            Button studyRoom = new Button("Reserve a Study Room");
            
            VBox frontPage = new VBox(search, libraryChat, studyRoom);
            frontPage.setSpacing(50);
            frontPage.setPadding(new Insets(0,0,0,0));
            frontPage.setAlignment(Pos.CENTER);

            bp.setCenter(frontPage);

            primaryStage.setTitle("CPP Library");
            primaryStage.setScene(new Scene(bp));
            primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args); 
    }
}

