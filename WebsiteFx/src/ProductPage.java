import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProductPage {

    public static Label back = new Label(""
    public static ImageView productImage = new ImageView(new Image("dune.jpg"));
    public static Label Title = new Label("Dune");
    public static Label Author = new Label("Frank Frank Herbert");
    public static Label blurb = new Label("Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a"
                                            +" noble family tasked with ruling an inhospitable world where the only thing of value is"
                                            +" the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted"
                                            +" across the known universe, melange is a prize worth killing for...\r\n" + "\r\n" 
                                            + //
                                            "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a "
                                            +"journey toward a destiny greater than he could ever have imagined. And as he evolves into"
                                            +" the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most ancient"
                                            +" and unattainable dream.");
    
    // set wrapt text for blurb maybe??????

    public static Button borrowBtn = new Button("Borrow");
    public static Button requestBtn = new Button("Request");
    
    public static void settings(Stage primaryStage) {

    }
}
