package pages;
import com.sun.prism.paint.Color;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductPage {

    public static Label back = new Label("< Go back to Books");
    public static ImageView productImage= new ImageView(new Image("\\images\\dune.jpg"));
    public static Label title = new Label("");
    public static Label author = new Label("");
    public static Label blurb = new Label("");
    public static Label genre = new Label("");
    public static Label publishedDate = new Label("");
   
    
    public static Button checkoutBtn = new Button("Borrow");
    //public static Button requestBtn = new Button("Request");

    public static VBox productOptions = new VBox(productImage, checkoutBtn);
    public static VBox description = new VBox(title, author, blurb, genre, publishedDate);

    public static HBox product = new HBox(productOptions,description);

    public static VBox productPage = new VBox(back,new Separator(Orientation.HORIZONTAL), product);
    
    public static void settings(Stage primaryStage) {
        
        productImage.setFitWidth(280); productImage.setPreserveRatio(true);
        checkoutBtn.setStyle("-fx-background-radius: 20; -fx-background-color:green; -fx-text-fill: white; -fx-font-weight: bold;");
        productOptions.setAlignment(Pos.TOP_CENTER);
        productOptions.setSpacing(20);

        title.setStyle("-fx-font-family: Georgia; -fx-font-size: 32px;"); title.setWrapText(true);
        author.setStyle("-fx-font-family: Georgia; -fx-font-size: 22px;");
        blurb.setStyle("-fx-font-family: Montserrat; -fx-font-size: 20px; -fx-text-fill: gray;");
        genre.setStyle("-fx-font-size: 15px;");
        publishedDate.setStyle("-fx-font-size: 15px;");

        description.minWidth(600);
        description.setPrefWidth(1000);
        description.setSpacing(10);
        blurb.setWrapText(true);

        product.setAlignment(Pos.CENTER);
        product.setSpacing(20);
        
        productPage.setSpacing(5);
        productPage.setPadding(new Insets(20,20,0,0));
        
        
        
    }
}
