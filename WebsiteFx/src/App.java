//import java.beans.EventHandler;
//import java.util.EventListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

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
import pages.ProductPage;
import pages.AccountNotFoundPage;
import pages.borrowedBooksPage;

public class App extends Application{

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;

        } catch (Exception e) {System.out.println(e);}
        
        return null;
    }


    public static double pos = 0;
    public static int selectedBookIndex = 0;

    boolean fillonce = false;

    @Override
    public void start(Stage primaryStage) {
            try {
                System.out.println("Connection: " + getConnection());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
            BorderPane bp = new BorderPane();
            bp.setPadding(new Insets(20));
           
            //opens website on Front Page by default 
            //bp.setTop(FrontPage.topOfPane);
            bp.setCenter(LoginPage.loginBox);

            //Populates the pages with content
            FrontPage.settings(primaryStage);
            BooksPage.settings(primaryStage);
            StudyRoomsPage.settings(primaryStage);
            LoginPage.settings(primaryStage);
            ProductPage.settings(primaryStage);
            
    
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


            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String user = "root";
            String pwd = "root";
           
            LoginPage.login.setOnAction( event -> {
                String email = LoginPage.e.getText();
                String password = LoginPage.p.getText();
                
                try  {
                    
                    //Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection(url, user, pwd);
                    Statement statement = c.createStatement();
                    statement.executeUpdate("USE CPP_Library");
                    
                    ResultSet  resultSet = statement.executeQuery("SELECT student_email,password,student_name FROM students WHERE student_email = '" + email + "';");
                    resultSet.next();

                    if (email.compareTo(resultSet.getString("student_email")) == 0 && password.compareTo(resultSet.getString("password")) == 0) {
                        FrontPage.studentOptions.setText(resultSet.getString("student_name"));
                        bp.setTop(FrontPage.topOfPane);
                        bp.setCenter(FrontPage.frontPage);
                        System.out.println("user: "+ FrontPage.studentOptions.getText());
                    }
                    else { System.out.println("No match bro");}
                
                    statement.close();
                    resultSet.close();
                    
                }catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e);
                } 
                
                try {
                    Connection c = DriverManager.getConnection(url, user, pwd);
                    Statement statement = c.createStatement();
                    statement.executeUpdate("USE CPP_Library");
                    
                    ResultSet  resultSet = statement.executeQuery("SELECT COUNT(*) FROM students;");
                    resultSet.next();
                    int columns = resultSet.getInt(1);
 
                    ResultSet resultSet1 = statement.executeQuery("SELECT COUNT(*) FROM books");
                    resultSet1.next();
                    int rows = resultSet1.getInt(1);
                    
                    BooksPage.borrowedBooks = new int[rows][columns];
                    BooksPage.users = new String[columns];
                    
                    ResultSet resultSet2 = statement.executeQuery("SELECT student_name FROM students");
                    int i = 0;
                    while(resultSet2.next()) {
                        BooksPage.users[i] = resultSet2.getString("student_name");
                        i++;
                    }

                    for(int x = 0; x < BooksPage.borrowedBooks[0].length; x++) {
                        System.out.println("This column is: "+ BooksPage.users[x]);
                    }

                    //Arrays.fill(BooksPage.borrowedBooks, -1);
                    if (fillonce == true) {
                        for (int row = 0; row < BooksPage.borrowedBooks.length; row++) {
                            for (int col = 0; col < BooksPage.borrowedBooks[0].length; col++) {
                                BooksPage.borrowedBooks[row][col] = -1;
                            }
                        }
                        fillonce = false;
                    }
                    
        
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e);
                }

                int account = BooksPage.findUserIndex(BooksPage.users, FrontPage.studentOptions.getText());
                System.out.println("account index: " + account);
                System.out.println("account at index" + BooksPage.authors[account]);

                /*for(int i = 0; i < BooksPage.borrowedBooks.length; i++) {
            
                    
                    if (BooksPage.borrowedBooks[i][account] != -1) {
                        Label l = new Label(BooksPage.titles[BooksPage.borrowedBooks[i][account]]);
                        l.setPadding(new Insets(20, 20, 20, 0));
                        borrowedBooksPage.borrowedBooksPage.getChildren().addAll(l /*BooksPage.options[ BooksPage.borrowedBooks[i][user] ]*//*, new Separator(Orientation.HORIZONTAL));
                    }
                    
                }*/

            });
            FrontPage.logOut.setOnAction(event -> {
                bp.setTop(null);
                bp.setCenter(LoginPage.loginBox);
                borrowedBooksPage.borrowedBooksPage.getChildren().clear();
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
                    //int index = 0;
                    for(int i = 0; i < BooksPage.booksPage.getChildren().size(); i++) {
                        if(h == BooksPage.booksPage.getChildren().get(i)) {
                            selectedBookIndex = i/2;//index = i/2;
                        }
                    }
                    ProductPage.productImage.setImage(BooksPage.images[selectedBookIndex/*index*/]);
                    ProductPage.title.setText(BooksPage.titles[selectedBookIndex/*index*/]);
                    ProductPage.author.setText(BooksPage.authors[selectedBookIndex/*index*/]);
                    ProductPage.blurb.setText(BooksPage.blurbs[selectedBookIndex/*index*/]);
                    ProductPage.genre.setText(BooksPage.subjects[selectedBookIndex/*index*/]);
                    ProductPage.publishedDate.setText("This Edition Published: " + BooksPage.dates[selectedBookIndex/*index*/]);
                    pos = sp.getVvalue();
                    System.out.println("Vertical position in the scroll pane: "+pos);
                    bp.setCenter(ProductPage.productPage);
                    
                });
            }

            ProductPage.back.setOnMouseEntered(event -> {
                ProductPage.back.setStyle("-fx-text-fill: blue; -fx-underline: true;");
            });
            ProductPage.back.setOnMouseExited(event -> {
                ProductPage.back.setStyle("-fx-text-fill: black; -fx-underline: false;");
            });
            ProductPage.back.setOnMouseClicked(event -> {
                bp.setCenter(BooksPage.booksPage);
                sp.layout();
                sp.setVvalue(pos+0.00954519909);
            });
            ProductPage.checkoutBtn.setOnMouseClicked(event -> {
                ProductPage.checkoutBtn.setStyle("-fx-background-radius: 20; -fx-background-color:blue; -fx-text-fill: white; -fx-font-weight: bold;");
            }
            
            )
            
            ProductPage.checkoutBtn.setOnMouseEntered(event -> {
                ProductPage.checkoutBtn.setStyle("-fx-background-radius: 20; -fx-background-color: darkgreen; -fx-text-fill: white; -fx-font-weight: bold; /*-fx-background-insets: -5, 0, -5, 0;*/ ");
            });
            ProductPage.checkoutBtn.setOnMouseExited(event -> {
                ProductPage.checkoutBtn.setStyle("-fx-background-radius: 20; -fx-background-color:green; -fx-text-fill: white; -fx-font-weight: bold;");
            });
            ProductPage.checkoutBtn.setOnMouseClicked(event-> {
                //if (BooksPage.copies[selectedBookIndex] > 0) {
                    //BooksPage.addBook(BooksPage.users, BooksPage.borrowedBooks, FrontPage.studentOptions.getText(), selectedBookIndex ); /*BooksPage.titles[selectedBookIndex]*/
                    System.out.println("copies now: "+BooksPage.copies[selectedBookIndex]);
                    BooksPage.copies[selectedBookIndex] = BooksPage.copies[selectedBookIndex] - 1;
                    System.out.println("copies later: "+BooksPage.copies[selectedBookIndex]);
                    try  {
                        
                        //Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection c = DriverManager.getConnection(url, user, pwd); 
                        PreparedStatement statement = c.prepareStatement("UPDATE books SET available_copies = ? WHERE title = + ? ;");
                        //PreparedStatement statement = c.prepareStatement("UPDATE books SET available_copies = available_copies - 1  WHERE title = 'Dune Messiah';");
                        
                        statement.setInt(1, BooksPage.copies[selectedBookIndex] - 1); // Decrementing the available_copies
                        statement.setString(2, BooksPage.titles[selectedBookIndex]);
                        statement.executeUpdate("USE CPP_Library");

                        /*statement.executeUpdate("USE CPP_Library");
                        
                    
                        ResultSet  resultSet = statement.executeQuery("UPDATE books SET available_copies = '"+BooksPage.copies[selectedBookIndex]+"' WHERE title = '"+ BooksPage.titles[selectedBookIndex]+"';");     
                        resultSet.next();*/
                        
                }catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        System.out.println(e);
                    } 
                //}
                BooksPage.addBook(BooksPage.users, BooksPage.borrowedBooks, FrontPage.studentOptions.getText(), selectedBookIndex ); /*BooksPage.titles[selectedBookIndex]*/
                
                int u = BooksPage.findUserIndex(BooksPage.users, FrontPage.studentOptions.getText());
                
                Label l = new Label(BooksPage.titles[BooksPage.borrowedBooks[selectedBookIndex][u]]);
                l.setPadding(new Insets(20, 20, 20, 0));
                borrowedBooksPage.borrowedBooksPage.getChildren().addAll(l , new Separator(Orientation.HORIZONTAL));

                
            });
            AccountNotFoundPage.backToLogin.setOnMouseEntered(event -> {
                AccountNotFoundPage.backToLogin.setStyle("-fx-text-fill: blue; -fx-underline: true;");
            });
            AccountNotFoundPage.backToLogin.setOnMouseExited(event -> {
                AccountNotFoundPage.backToLogin.setStyle("-fx-text-fill: black; -fx-underline: false;");
            });
            AccountNotFoundPage.backToLogin.setOnMouseClicked(event -> {
                bp.setCenter(LoginPage.loginBox);
                
            });
            
            FrontPage.borrowedBooks.setOnAction(event -> {
                //borrowedBooksPage.settings(primaryStage);
                bp.setCenter(borrowedBooksPage.borrowedBooksPage);
            });

            
            
            
    }
    public static void main(String[] args) {
        launch(args); 
    }
}