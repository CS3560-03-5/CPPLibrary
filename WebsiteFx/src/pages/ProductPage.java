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
    public static Label title = new Label("Dune");
    public static Label author = new Label("Frank Herbert");
    public static Label blurb = new Label("Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a"
                                            +" noble family tasked with ruling an inhospitable world where the only thing of value is"
                                            +" the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted"
                                            +" across the known universe, melange is a prize worth killing for...\r\n" + "\r\n" 
                                            + //
                                            "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a "
                                            +"journey toward a destiny greater than he could ever have imagined. And as he evolves into"
                                            +" the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most ancient"
                                            +" and unattainable dream.");
    public static Label genre = new Label("Science Fiction");
    public static Label publishedDate = new Label("A Date in Time");
   
    
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

        title.setStyle("-fx-font-family: Georgia; -fx-font-size: 32px;");
        author.setStyle("-fx-font-family: Georgia; -fx-font-size: 22px;");
        blurb.setStyle("-fx-font-family: Montserrat; -fx-font-size: 20px; -fx-text-fill: gray;");
        genre.setStyle("-fx-font-size: 15px;");
        publishedDate.setStyle("-fx-font-size: 15px;");

        description.setPrefWidth(600);
        description.setSpacing(10);
        blurb.setWrapText(true);

        product.setAlignment(Pos.CENTER);
        product.setSpacing(20);
        
        productPage.setSpacing(5);
        productPage.setPadding(new Insets(20,20,0,0));
        
        
        
    }
}
