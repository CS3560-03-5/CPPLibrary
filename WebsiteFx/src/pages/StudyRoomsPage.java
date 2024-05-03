package pages;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudyRoomsPage {
    
    public static Label blockPrompt = new Label(" Select the length (# of hours) for the Reservation Block");
    public static ComboBox<Double> cb = new ComboBox<>();
    public static Double[] blockLengths = {3.0, 2.5, 2.0, 1.5, 1.0, .5};
    public static HBox blockSettings = new HBox(blockPrompt, cb);

    /*public static Region green = new Region();
    public static Region red = new Region();*/
    public static Label green = new Label("green");
    public static Label  red = new Label("red");
    public static HBox availableExample = new HBox(green, new Label("Available"));
    public static HBox reservedExample = new HBox(red, new Label("Reserved"));
    public static VBox colorDemo = new VBox(availableExample, reservedExample);









    
    public static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    public static String user = "root";
    public static String pwd = "root";
   

        

    
    
    public static Label[] rooms = {new Label("2nd Floor"), new Label("201"), new Label("202"),
                                    new Label("3rd Floor"), new Label("301"), new Label("302"),
                                    new Label("4th Floor"), new Label("401"), new Label("402")};

    public static VBox roomsBox = new VBox();

    public static GridPane blockTable = new GridPane();
    public static ScrollPane blockTableSP = new ScrollPane(blockTable); //might need to do the centering done in App.java
    public static String[] blockTimes = {"10:30am", "11:00am", "11:30am", "12:00pm", "12:30pm", "1:00pm", "1:30pm",
                                        "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm",
                                        "6:00pm", "6:30pm", "7:00pm", "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm",
                                        "10:00pm", "10:30pm"};

    
    public static GridPane reservationTable = new GridPane();
    













    public static VBox studyRoomsPage = new VBox(blockSettings, colorDemo, reservationTable);




    
    public static void settings(Stage primaryStage) {
        cb.getItems().addAll(blockLengths);
        blockSettings.setSpacing(20);
        blockSettings.setAlignment(Pos.CENTER);
        
        /*green.setPrefSize(30,30);
        green.setStyle("-fx-background-color: green");
        red.setPrefSize(30,30);
        red.setStyle("-fx-background-color: red");*/

        availableExample.setSpacing(20);
        availableExample.setAlignment(Pos.CENTER);
        reservedExample.setSpacing(20);
        reservedExample.setAlignment(Pos.CENTER);
        colorDemo.setSpacing(20);
        colorDemo.setAlignment(Pos.CENTER);

        roomsBox.getChildren().add(new Label("Rooms"));
        for(int i = 0; i < rooms.length; i++) {
            roomsBox.getChildren().addAll(rooms[i]/* , new Separator(Orientation.HORIZONTAL)*/);
        }
        //roomsBox.setAlignment(Pos.CENTER);// kill this later

        //reservationTable.add(new Label("Rooms"), 0, 0);
        reservationTable.add(new Label("Times"), 1, 0);
        reservationTable.add(roomsBox, 0, 1);
        reservationTable.add(blockTableSP, 1, 1);
       // reservationTable.setPrefHeight(blockTableSP.getHeight());

        for (int i = 0; i < blockTimes.length; i++) {
            blockTable.add(new Label(blockTimes[i]), i, 0);
        }
        blockTable.setHgap(2);
        blockTable.setVgap(1.25);
        blockTableSP.setPrefWidth(600);
        blockTableSP.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        blockTableSP.setPannable(false);
        //blockTableSP.setPrefViewportHeight(blockTable.getHeight()+50);
        //blockTableSP.setPrefHeight(roomsBox.getHeight()+15);

        System.out.println("number of rows needed for gridpane: "+ roomsBox.getChildren().size());
        System.out.println("number of elements for blockTimes: "+ blockTimes.length);
        Rectangle r1 = new Rectangle(50, 15.5);
        blockTable.add(r1, 0, 1);
        for(int j = 1; j < rooms.length+2; j++) {
            for (int i = 0 ; i < blockTable.getColumnCount(); i++) {
                if(j == rooms.length + 1) {
                    blockTable.add(new Label(" "), i, j);
                }
                else {
                    Rectangle r = new Rectangle(50, 15.5);
                    r.setId("r"+i+j);
                    r.setFill(Color.GREEN);
                    blockTable.add(r, i, j);
                }
            
            }
        }

        reservationTable.setAlignment(Pos.CENTER);


        
        /*try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pwd);
            String sql = "select availability_slots.*, studyroom.*"
                        +"from availability_slots"
                        +"join  studyroom on studyroom.studyRoom_id = availability_slots.studyRoom_id;";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while( resultSet.next()) {
                String studyRoom = resultSet.getString("studyRoom_Number");
                String timeslot = resultSet.getString("start_time");
                Boolean available = resultSet.getBoolean("is_available");
                System.out.println("Room #: "+studyRoom+", Timeslot: "+timeslot+", Available?: "+available);
            } 
            resultSet.close();
            ps.close();
            c.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }*//*catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


        
        studyRoomsPage.setSpacing(40);
        studyRoomsPage.setPadding(new Insets(20, 20, 20, 20));
        





    }
    

}
