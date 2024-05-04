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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BooksPage extends Application {
    //int n = 12;//placeholder number of books

    public static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    public static String user = "root";
    public static String pwd = "root";
    
    public static Image img1 = new Image("\\images\\introductiontothetheoryofcomputation.jpg");
    public static Image img2 = new Image("\\images\\artificialintelligenceamodernapproach.jpg");
    public static Image img3 = new Image("\\images\\dunemessiah.jpg");
    public static Image img4 = new Image("\\images\\senlinascends.jpg");
    public static Image img5 = new Image("\\images\\armofthesphinx.jpg");
    public static Image img6 = new Image("\\images\\redrising.jpg");
    public static Image img7 = new Image("\\images\\thehodking.jpg");
    public static Image img8 = new Image("\\images\\circadianalgorithms.jpg");
    public static Image img9 = new Image("\\images\\vicious.jpg");
    public static Image img10 = new Image("\\images\\vengeful.jpg");
    public static Image img11 = new Image("\\images\\thetalentedmrripley.jpg");
    public static Image img12 = new Image("\\images\\ripleyunderground.jpg");
    public static Image img13 = new Image("\\images\\dune.jpg");

    public static Image[] images = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13};

    /*public static ImageView[] images = {new ImageView(new Image("\\images\\introductiontothetheoryofcomputation.jpg")),
                                        new ImageView(new Image("\\images\\aritificialintelligencemodernapproach.jpg")),
                                        new ImageView(new Image("\\images\\dunemessiah.jpg")),
                                        new ImageView(new Image("\\images\\senlinascends.jpg")),
                                        new ImageView(new Image("\\images\\armofthesphinx.jpg")),
                                        new ImageView(new Image("\\images\\redrising.jpg")),
                                        new ImageView(new Image("\\images\\thehodking.jpg")),
                                        new ImageView(new Image("\\images\\circadianalgorithms.jpg")),
                                        new ImageView(new Image("\\images\\vicious.jpg")),
                                        new ImageView(new Image("\\images\\vengeful.jpg")),
                                        new ImageView(new Image("\\images\\thetalentedmrripley.jpg")),
                                        new ImageView(new Image("\\images\\ripleyunderground.jpg")),
                                        new ImageView(new Image("\\images\\dune"))};*/

    


    public static String[] titles;
    public static String[] authors;
    public static String[] dates;
    public static String[] isbns;
    public static int[] copies;
    public static String[] subjects;


    public static HBox[] options;

    public static VBox booksPage = new VBox();

    
    /*public static Label book1 = new Label("Dune / Frank Herbert\n(1965)");
    public static ImageView book1_img = new ImageView(new Image("/images/dune.jpg"));
    public static HBox option1 = new HBox(book1_img, book1); 

    public static Label book2 = new Label("Dune Messiah / Frank Herbert\n(1969)");
    public static ImageView book2_img = new ImageView(new Image("/images/dunemessiah.jpg"));
    public static HBox option2 = new HBox(book2_img, book2);

    public static Label book3 = new Label("Senlin Ascends / Josiah Bancroft\n(2013)");
    public static ImageView book3_img = new ImageView(new Image("/images/senlinascends.jpg"));
    public static HBox option3 = new HBox(book3_img, book3);

    public static Label book4 = new Label("Arm of the Sphinx by Josiah Bancroft\n(2015)");
    public static ImageView book4_img = new ImageView(new Image("/images/armofthesphinx.jpg"));
    public static HBox option4 = new HBox(book4_img, book4);

    public static Label book5 = new Label("Red Rising / Pierce Brown\n(2014)");
    public static ImageView book5_img = new ImageView(new Image("/images/redrising.jpg"));
    public static HBox option5 = new HBox(book5_img, book5);

    public static Label book6 = new Label("The Hod King by Josiah Bancroft\n(2019)");
    public static ImageView book6_img = new ImageView(new Image("/images/thehodking.jpg"));
    public static HBox option6 = new HBox(book6_img, book6);

    public static HBox[] options = {option1, option2, option3, option4, option5, option6};
    
    public static VBox booksPage = new VBox(new Separator(Orientation.HORIZONTAL));*/

    
    
    public static void settings(Stage primaryStage) {
        
        
        try {
            Connection c = DriverManager.getConnection(url, user, pwd);
            Statement statement = c.createStatement();
            statement.executeUpdate("USE CPP_Library");
            
            ResultSet  resultSet = statement.executeQuery("SELECT COUNT(*) FROM books;");
            resultSet.next();

            titles = new String[resultSet.getInt(1)];
            authors = new String[resultSet.getInt(1)];
            dates = new String[resultSet.getInt(1)];
            isbns = new String[resultSet.getInt(1)];
            copies = new int[resultSet.getInt(1)];
            subjects = new String[resultSet.getInt(1)];
            options = new HBox[resultSet.getInt(1)];
            

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connection c = DriverManager.getConnection(url, user, pwd);
            Statement statement = c.createStatement();
            statement.executeUpdate("USE CPP_Library");
            
            ResultSet  resultSet = statement.executeQuery("SELECT * FROM books;");
            int index = 0;
            while(resultSet.next()) {
                titles[index] = resultSet.getString("title");
                authors[index] = resultSet.getString("author");
                dates[index] = resultSet.getString("publication_date");
                isbns[index] = resultSet.getString("ISBN");
                copies[index] = resultSet.getInt("available_copies");
                subjects[index] = resultSet.getString("subject");
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }

        for(int i = 0; i < options.length; i++) {
            Font font = Font.font("Arial", FontWeight.BOLD, 20);
            Label l1 = new Label(titles[i]); l1.setFont(font);
            Label l2 = new Label(authors[i]);
            
            VBox vbox = new VBox(l1, l2);
            vbox.setSpacing(7);
            
            ImageView iv = new ImageView(images[i]);
            iv.setFitWidth(100); iv.setPreserveRatio(true);

            HBox hbox = new HBox(iv, vbox);
            hbox.setSpacing(20);
            hbox.setPadding(new Insets(20, 20, 20, 20));

            options[i] = hbox;

            booksPage.getChildren().addAll(hbox, new Separator(Orientation.HORIZONTAL));
            

            
        }
        





        /*book1_img.setFitHeight(100); book1_img.setPreserveRatio(true);
        book2_img.setFitHeight(100); book2_img.setPreserveRatio(true);
        book3_img.setFitHeight(100); book3_img.setPreserveRatio(true);
        book4_img.setFitHeight(100); book4_img.setPreserveRatio(true);
        book5_img.setFitHeight(100); book5_img.setPreserveRatio(true);
        book6_img.setFitHeight(100); book6_img.setPreserveRatio(true);

        option1.setSpacing(20); option1.setPadding(new Insets(20,0,20,20));
        option2.setSpacing(20); option2.setPadding(new Insets(20,0,20,20));
        option3.setSpacing(20); option3.setPadding(new Insets(20,0,20,20));
        option4.setSpacing(20); option4.setPadding(new Insets(20,0,20,20));
        option5.setSpacing(20); option5.setPadding(new Insets(20,0,20,20));
        option6.setSpacing(20); option6.setPadding(new Insets(20,0,20,20));

      for (HBox v : options) {
                    booksPage.getChildren().add(v);
                    booksPage.getChildren().add(new Separator(Orientation.HORIZONTAL));
        } 
        
        booksPage.setSpacing(50);
        booksPage.setPadding(new Insets(20, 20, 20, 20));*/
        
    }
}
