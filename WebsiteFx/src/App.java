//import java.beans.EventHandler;
//import java.util.EventListener;

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
            StudyRoomsPage.settings(primaryStage);
    
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
                    h.setStyle("-fx-background: red");
                    
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