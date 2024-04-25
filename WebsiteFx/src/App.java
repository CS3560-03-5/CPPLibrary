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

import pages.FrontPage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) {
           
            BorderPane bp = new BorderPane();
            bp.setPadding(new Insets(20));

            //fitting borderpane to window
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            bp.setMaxWidth(bounds.getMinX());
            bp.setMaxHeight(bounds.getMinY());
           
            //opens website on Front Page by default 
            bp.setTop(FrontPage.topOfPane);
            bp.setCenter(FrontPage.frontPage);
            FrontPage.settings(primaryStage);

            primaryStage.setTitle("CPP Library");
            primaryStage.setScene(new Scene(bp));
            primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args); 
    }
}

