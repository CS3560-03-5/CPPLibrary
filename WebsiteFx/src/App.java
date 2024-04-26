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
import javafx.scene.control.ScrollPane;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pages.BooksPage;
import pages.FrontPage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) {
           
            BorderPane bp = new BorderPane();
            bp.setPadding(new Insets(20));

            //fitting borderpane to window
            /*Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            bp.setMaxWidth(bounds.getMaxX());
            bp.setMaxHeight(bounds.getMaxY());*/
           
            //opens website on Front Page by default 
            bp.setTop(FrontPage.topOfPane);
            bp.setCenter(FrontPage.frontPage);

            //Populates the pages with content
            FrontPage.settings(primaryStage);
            BooksPage.settings1(primaryStage);

        
            ScrollPane sp = new ScrollPane();
            sp.setContent(bp);
            sp.setFitToWidth(true);
            sp.setFitToHeight(true);

            primaryStage.setTitle("CPP Library");
            primaryStage.setScene(new Scene(sp));
            primaryStage.setMaximized(true);
            primaryStage.show();

            
            FrontPage.books.setOnMouseClicked(event -> {
                bp.setCenter(BooksPage.booksPage);
            } );
            FrontPage.home.setOnMouseClicked( event -> {
                bp.setCenter(FrontPage.frontPage);
            });

    }
    public static void main(String[] args) {
        launch(args); 
    }
}

