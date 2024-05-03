//import java.beans.EventHandler;
//import java.util.EventListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pages.BooksPage;
import pages.FrontPage;
import pages.StudyRoomsPage;
import pages.LoginPage;

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
            //bp.setTop(FrontPage.topOfPane);
            bp.setCenter(LoginPage.loginBox);

            //Populates the pages with content
            FrontPage.settings(primaryStage);
            BooksPage.settings1(primaryStage);
            StudyRoomsPage.settings(primaryStage);
            LoginPage.settings(primaryStage);
    
            ScrollPane sp = new ScrollPane();
            sp.setContent(bp);
            sp.setFitToWidth(true);
            sp.setFitToHeight(true);

            primaryStage.setTitle("CPP Library");
            Scene w = new Scene(sp);
            //w.getStylesheets().add("styles.css");
            primaryStage.setScene(w);
            primaryStage.setMaximized(true);
            primaryStage.show();


            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";//"root@localhost:3306/CPP_Library";//"root@127.0.0.1:3306";//"jdbc:mysql://127.0.0.1:3306/?user=root";//"jdbc:mysql://localhost:3306/CPP_Library";
            String user = "root";
            String pwd = "root";
           
            LoginPage.login.setOnAction( event -> {
                String email = LoginPage.e.getText();
                String password = LoginPage.p.getText();
                
                try  {
                    
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection(url, user, pwd);
                    
                    String sql = "select * from students"
                                +"where student_emaill =" + email +" and password = "+password+";";
                    PreparedStatement ps = c.prepareStatement(sql);
                    ResultSet resultSet = ps.executeQuery();

                    System.out.println("proof: " + resultSet.getString("bronco_id"));

                    /*while( resultSet.next()) {
                        String id = resultSet.getString("bronco_id");
                        String email = resultSet.getString("student_email");
                        String name = resultSet.getString("student_name");
                        String password = resultSet.getString("password");
                        System.out.println("bronco id: "+id+", email: "+email+", name: "+ name+", password: "+ password);
                    } */
                    resultSet.close();
                    ps.close();
                    c.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e);
                }

                bp.setTop(FrontPage.topOfPane);
                bp.setCenter(FrontPage.frontPage);

            });
            FrontPage.books.setOnMouseClicked(event -> {
                bp.setCenter(BooksPage.booksPage);
            } );
            FrontPage.home.setOnMouseClicked( event -> {
                bp.setCenter(FrontPage.frontPage);
            });
            FrontPage.studyRooms.setOnMouseClicked(event -> {
                bp.setCenter(StudyRoomsPage.studyRoomsPage);

            });
            FrontPage.studyRoom.setOnMouseClicked(event -> {
                bp.setCenter(StudyRoomsPage.studyRoomsPage);
                w.getRoot().applyCss();
            });
            FrontPage.logIn.setOnAction(event -> {
                bp.setCenter(LoginPage.loginBox);
            });

            
            //myGridPane.getChildren().get(i*8+j)
            //assuming 8x8 gridpane
            for(Node n: StudyRoomsPage.blockTable.getChildren()) {
                if(GridPane.getRowIndex(n) > 0 && GridPane.getRowIndex(n) < StudyRoomsPage.roomsBox.getChildren().size() && GridPane.getColumnIndex(n) < StudyRoomsPage.blockTimes.length ) {
                    //might need to add declaration
                    Rectangle r = (Rectangle) n;
                    
                    r.setOnMouseEntered(e -> {
                        
                        r.setFill(Color.YELLOWGREEN);
                    });
                }
            }
            for(Node n: StudyRoomsPage.blockTable.getChildren()) {
                if(GridPane.getRowIndex(n) > 0 && GridPane.getRowIndex(n) < StudyRoomsPage.roomsBox.getChildren().size() && GridPane.getColumnIndex(n) < StudyRoomsPage.blockTimes.length ) {
                    //might need to add declaration
                    Rectangle r = (Rectangle) n;
                    
                    r.setOnMouseExited(e -> {
                        
                        r.setFill(Color.GREEN);
                    });
                }
            }

            int highlightNodes = 0;
            for(Node n: StudyRoomsPage.blockTable.getChildren()) {
                if(GridPane.getRowIndex(n) > 0 && GridPane.getRowIndex(n) < StudyRoomsPage.roomsBox.getChildren().size() && GridPane.getColumnIndex(n) < StudyRoomsPage.blockTimes.length ) {
                    Rectangle r = (Rectangle) n;
                    
                    /*r.setOnMouseClicked(e -> {
                        
                        
                    });*/
                    
                    r.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        private int highlightNodes;

                        @Override
                        public void handle(MouseEvent arg0) {
                            // TODO Auto-generated method stub
                            /*int i = GridPane.getColumnIndex(n);
                            for(int x = i; x < i+5; x++) {
                                StudyRoomsPage.blockTable()
                            }*/
                            this.highlightNodes = 5;
                            r.setFill(Color.YELLOW);
                            throw new UnsupportedOperationException("Unimplemented method 'handle'");
                        }
                    });
                }
            }

            for(HBox h: BooksPage.options) {
                h.setOnMouseEntered(e -> {
                    h.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
                    
                });
            }
            for(HBox h: BooksPage.options) {
                h.setOnMouseExited(e -> {
                    h.setBackground(new Background(new BackgroundFill(null, null, null)));
                    
                });
            }
            
            for(HBox h: BooksPage.options) {
                h.setOnMouseClicked(e -> {
                    bp.setCenter(FrontPage.frontPage);
                    
                });
            }
            
            
            
    }
    public static void main(String[] args) {
        launch(args); 
    }
}