package pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BooksPage extends Application {
    int n = 12;//placeholder number of books
    
    public static Label book1 = new Label("Dune / Frank Herbert\n(1965)");
    public static ImageView book1_img = new ImageView(new Image("dune.jpg"));
    public static HBox option1 = new HBox(book1_img, book1); 

    public static Label book2 = new Label("Dune Messiah / Frank Herbert\n(1969)");
    public static ImageView book2_img = new ImageView(new Image("dunemessiah.jpg"));
    public static HBox option2 = new HBox(book2_img, book2);

    public static Label book3 = new Label("Senlin Ascends / Josiah Bancroft\n(2013)");
    public static ImageView book3_img = new ImageView(new Image("senlinascends.jpg"));
    public static HBox option3 = new HBox(book3_img, book3);

    public static Label book4 = new Label("Arm of the Sphinx by Josiah Bancroft\n(2015)");
    public static ImageView book4_img = new ImageView(new Image("armofthesphinx.jpg"));
    public static HBox option4 = new HBox(book4_img, book4);

    public static Label book5 = new Label("Red Rising / Pierce Brown\n(2014)");
    public static ImageView book5_img = new ImageView(new Image("redrising.jpg"));
    public static HBox option5 = new HBox(book5_img, book5);

    public static Label book6 = new Label("The Hod King by Josiah Bancroft\n(2019)");
    public static ImageView book6_img = new ImageView(new Image("thehodking.jpg"));
    public static HBox option6 = new HBox(book6_img, book6);

    public static HBox[] options = {option1, option2, option3, option4, option5, option6};
    
    public static VBox booksPage = new VBox(new Separator(Orientation.HORIZONTAL));

    
    
    public static void settings1(Stage primaryStage) {

        book1_img.setFitHeight(100); book1_img.setPreserveRatio(true);
        book2_img.setFitHeight(100); book2_img.setPreserveRatio(true);
        book3_img.setFitHeight(100); book3_img.setPreserveRatio(true);
        book4_img.setFitHeight(100); book4_img.setPreserveRatio(true);
        book5_img.setFitHeight(100); book5_img.setPreserveRatio(true);
        book6_img.setFitHeight(100); book6_img.setPreserveRatio(true);

        option1.setSpacing(20);
        option2.setSpacing(20);
        option3.setSpacing(20);
        option4.setSpacing(20);
        option5.setSpacing(20);
        option6.setSpacing(20);

      for (HBox v : options) {
                    booksPage.getChildren().add(v);
                    booksPage.getChildren().add(new Separator(Orientation.HORIZONTAL));
        } 
        
        booksPage.setSpacing(50);
        booksPage.setPadding(new Insets(20, 20, 20, 20));

    }
}
