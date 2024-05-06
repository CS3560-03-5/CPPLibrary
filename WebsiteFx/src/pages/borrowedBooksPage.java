package pages;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class borrowedBooksPage {
    public static VBox borrowedBooksPage = new VBox();
    public static int user = BooksPage.findUserIndex(BooksPage.users, FrontPage.studentOptions.getText());

    public static void settings(Stage primaryStage) {
       
        
        for(int i = 0; i < BooksPage.borrowedBooks.length; i++) {
            
           
            if (BooksPage.borrowedBooks[i][user] != -1) {
                /*Label l = new Label(BooksPage.titles[BooksPage.borrowedBooks[i][user]]);
                l.setPadding(new Insets(20, 20, 20, 0));
                borrowedBooksPage.getChildren().addAll(l /*BooksPage.options[ BooksPage.borrowedBooks[i][user] ],*//* new Separator(Orientation.HORIZONTAL));*/
            }
            
        }
    }
}
