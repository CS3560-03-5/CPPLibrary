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
    public static String[] users;
    public static int[][] borrowedBooks;


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
                titles[index] = resultSet.getString("title".trim());
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
            
            Label l1 = new Label(titles[i]);  l1.setStyle("-fx-font-family: Georgia; -fx-font-weight: bold; -fx-font-size: 20px;");
            Label l2 = new Label(authors[i]); l2.setStyle("-fx-font-family: Georgia;");
            
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

    /*public static void addBook(String[][] a, String name, String title ) {
        int user = 0;
        for(int i = 0; i < a[0].length; i++) {
            if(name.compareTo(a[0][user]) == 0 ) {
                user = i;
            }
        }
        boolean containsTitle = false;
        for(int j = 0; j < a.length; j++) {
            if(title.compareTo(a[0][user]) == 0) {
                containsTitle = true;
            }
            if(a[j][user] == null && containsTitle == false) {
                a[j][user] = title;
                break;
            }
        }
    }*/
    
    public static int findUserIndex(String[] arr, String userName) {
        for(int i = 0; i < arr.length; i++) {
            
            if(userName.compareTo((String) arr[i]) == 0 ) {
                System.out.println(arr[i] + " matches "+ userName);
                return i;
            }
        }
        return -1;
    }
    public static void addBook(String[] a, int[][] b, String name, int index) {
        int user = findUserIndex(a, name);
        boolean containsBook = false;
        for(int j = 0; j < a.length; j++) {
            //System.out.println(a[j][user] + " compared to " + index);
            if(index == b[j][user]) {
                
                containsBook = true;
            }
            if(b[j][user] == -1 && containsBook == false) {
                b[j][user] = index;
                break;
            }
            
        }
    }
    
    
    public static String[] blurbs = {
        "This highly anticipated revision builds upon the strengths of the previous edition. Sipser's candid, "+
        "crystal-clear style allows students at every level to understand and enjoy this field. His innovative "+
        "\"proof idea\" sections explain profound concepts in plain English. The new edition incorporates many "+
        "improvements students and professors have suggested over the years, and offers updated, "+
        "classroom-tested problem sets at the end of each chapter.",

        "For one or two-semester, undergraduate or graduate-level courses in Artificial Intelligence. The "+
        "long-anticipated revision of this best-selling text offers the most comprehensive, up-to-date "+
        "introduction to the theory and practice of artificial intelligence. *NEW-Nontechnical learning material-"+
        "Accompanies each part of the book. *NEW-The Internet as a sample application for intelligent "+
        "systems-Added in several places including logical agents, planning, and natural language. *NEW-"+
        "Increased coverage of material - Includes expanded coverage of: default reasoning and truth "+
        "maintenance systems, including multi-agent/distributed AI and game theory; probabilistic "+
        "approaches to learning including EM; more detailed descriptions of probabilistic inference "+
        "algorithms. *NEW-Updated and expanded exercises-75% of the exercises are revised, with 100 new "+
        "exercises. *NEW-On-line Java software. *Makes it easy for students to do projects on the web using "+
        "intelligent agents. *A unified, agent-based approach to AI-Organizes the material around the task of "+
        "building intelligent agents. *Comprehensive, up-to-date coverage-Includes a unified view of the field "+
        "organized around the rational decision making pa",

        "Dune Messiah continues the story of Paul Atreides, better known--and feared--as the man "+
        "christened Muad'Dib. As Emperor of the Known Universe, he possesses more power than a single "+
        "man was ever meant to wield. Worshipped as a religious icon by the fanatical Fremens, Paul faces "+
        "the enmity of the political houses he displaced when he assumed the throne--and a conspiracy "+
        "conducted within his own sphere of influence.\r\n" + //
        "\r\n" + //
        "And even as House Atreides begins to crumble around him from the machinations of his enemies, "+
        "the true threat to Paul comes to his lover, Chani, and the unborn heir to his family's dynasty...",

        "The Tower of Babel is the greatest marvel in the world. Immense as a mountain, the ancient Tower "+
        "holds unnumbered ringdoms, warring and peaceful, stacked one on the other like the layers of a "+
        "cake. It is a world of geniuses and tyrants, of airships and steam engines, of unusual animals and "+
        "mysterious machines.\r\n" + //
        "\r\n" + //
        "Soon after arriving for his honeymoon at the Tower, the mild-mannered headmaster of a small "+
        "village school, Thomas Senlin, gets separated from his wife, Marya, in the overwhelming swarm of "+
        "tourists, residents, and miscreants.\r\n" + //
        "\r\n" + //
        "Senlin is determined to find Marya, but to do so he'll have to navigate madhouses, ballrooms, and "+
        "burlesque theaters. He must survive betrayal, assassins, and the long guns of a flying fortress. But if "+
        "he hopes to find his wife, he will have to do more than just endure.\r\n" + //
        "\r\n" + //
        "This quiet man of letters must become a man of action.",

        "The Tower of Babel is proving to be as difficult to reenter as it was to break out of. Forced into a life "+
        "of piracy, Senlin and his eclectic crew are struggling to survive aboard their stolen airship as the "+
        "hunt to rescue Senlin's lost wife continues.\r\n" + //
        "\r\n" + //
        "Hopeless and desolate, they turn to a legend of the Tower, the mysterious Sphinx. But help from the "+
        "Sphinx never comes cheaply, and as Senlin knows, debts aren't always what they seem in the Tower "+
        "of Babel.\r\n" + //
        "\r\n" + //
        "Time is running out, and now Senlin must choose between his friends, his freedom, and his wife. "+
        "Does anyone truly escape the Tower?",

        "Darrow is a Red, a member of the lowest caste in the color-coded society of the future. Like his "+
        "fellow Reds, he works all day, believing that he and his people are making the surface of Mars "+
        "livable for future generations.\r\n" + //
        "\r\n" + //
        "Yet he spends his life willingly, knowing that his blood and sweat will one day result in a better world "+
        "for his children.\r\n" + //
        "\r\n" + //
        "But Darrow and his kind have been betrayed. Soon he discovers that humanity already reached the "+
        "surface generations ago. Vast cities and sprawling parks spread across the planet. Darrow—and "+
        "Reds like him—are nothing more than slaves to a decadent ruling class.\r\n" + //
        "\r\n" + //
        "Inspired by a longing for justice, and driven by the memory of lost love, Darrow sacrifices everything "+
        "to infiltrate the legendary Institute, a proving ground for the dominant Gold caste, where the next "+
        "generation of humanity's overlords struggle for power. He will be forced to compete for his life and "+
        "the very future of civilization against the best and most brutal of Society's ruling class. There, he will "+
        "stop at nothing to bring down his enemies... even if it means he has to become one of them to do "+
        "so.",

        "Fearing an uprising, the Sphinx sends Senlin to investigate a plot that has taken hold in the ringdom "+
        "of Pelphia. Alone in the city, Senlin infiltrates a bloody arena where hods battle for the public's "+
        "entertainment. But his investigation is quickly derailed by a gruesome crime and an unexpected "+
        "reunion.\r\n" + //
        "\r\n" + //
        "Posing as a noble lady and her handmaid, Voleta and Iren attempt to reach Marya, who is isolated "+
        "by her fame. While navigating the court, Voleta attracts the unwanted attention of a powerful prince "+
        "whose pursuit of her threatens their plan.\r\n" + //
        "\r\n" + //
        "Edith, now captain of the Sphinx's fierce flagship, joins forces with a fellow wakeman to investigate "+
        "the disappearance of a beloved friend. She must decide who to trust as her desperate search brings "+
        "her nearer to the Black Trail where the hods climb in darkness and whisper of the Hod King.\r\n" + //
        "\r\n" + //
        "As Senlin and his crew become further dragged in to the conspiracies of the Tower, everything falls "+
        "to one question: Who is The Hod King?",

        "Those who control dreams control reality.\r\n" + //
        "\r\n" + //
        "Madeline wants more time—for her career as a tech startup CEO, for herself, and for her family. "+
        "Lucky for her, a new and controversial procedure offers to give her just that by reducing how much "+
        "she needs to sleep. The data is promising, and she’s used to taking calculated risks. It seems like "+
        "the right decision at the time, even if she hides it from her husband.\r\n" + //
        "\r\n" + //
        "While Madeline scaled the corporate ladder and spent half her nights on the road, Darwin traded in "+
        "dreams of winning the Nobel Prize in neuroscience for the quiet fulfillment of staying home and "+
        "raising their two daughters. At least, that’s what he told himself.\r\n" + //
        "\r\n" + //
        "Initially Madeline excels to new heights. But after a bizarre encounter with a debonair man at the "+
        "luxurious Stasis Hotel, she starts losing touch with reality and acting increasingly erratic, including "+
        "filing for divorce. Other high achievers rumored to have undergone the same operation begin "+
        "disappearing or turning up dead.\r\n" + //
        "\r\n" + //
        "Darwin—who has his own troubled history with the procedure—suspects something nefarious is "+
        "afoot and that he’s among the few who can help. His life and sanity crumble as he uncovers a "+
        "chilling plot by a powerful group to harness humanity’s dreams for its endgame. Darwin and "+
        "Madeline must each survive bloodshot escapades through cityscapes and dreamscapes to try and "+
        "wake up from the nightmare before it consumes the entire planet—and maybe more than that.",

        "Victor and Eli started out as college roommates—brilliant, arrogant, lonely boys who recognized the "+
        "same sharpness and ambition in each other. In their senior year, a shared research interest in "+
        "adrenaline, near-death experiences, and seemingly supernatural events reveals an intriguing "+
        "possibility: that under the right conditions, someone could develop extraordinary abilities. But when "+
        "their thesis moves from the academic to the experimental, things go horribly wrong.\r\n" + //
        "\r\n" + //
        "Ten years later, Victor breaks out of prison, determined to catch up to his old friend (now foe), aided "+
        "by a young girl whose reserved nature obscures a stunning ability. Meanwhile, Eli is on a mission to "+
        "eradicate every other super-powered person that he can find—aside from his sidekick, an enigmatic "+
        "woman with an unbreakable will. Armed with terrible power on both sides, driven by the memory of "+
        "betrayal and loss, the archnemeses have set a course for revenge—but who will be left alive at the end?\r\n" + //
        "\r\n" + //
        "In Vicious, V. E. Schwab brings to life a gritty comic-book-style world in vivid prose: a world where "+
        "gaining superpowers doesn't automatically lead to heroism, and a time when allegiances are called "+
        "into question.",

        "Magneto and Professor X. Superman and Lex Luthor. Victor Vale and Eli Ever. Sydney and Serena "+
        "Clarke. Great partnerships, now soured on the vine.\r\n" + //
        "\r\n" + //
        "But Marcella Riggins needs no one. Flush from her brush with death, she’s finally gained the control "+
        "she’s always sought—and will use her new-found power to bring the city of Merit to its knees. She’ll "+
        "do whatever it takes, collecting her own sidekicks, and leveraging the two most infamous EOs, "+
        "Victor Vale and Eli Ever, against each other.\r\n" + //
        "\r\n" + //
        "With Marcella's rise, new enmities create opportunity--and the stage of Merit City will once again be "+
        "set for a final, terrible reckoning.",

        "It’s here, in the first volume of Patricia Highsmith’s five-book Ripley series, that we are introduced to "+
        "the suave Tom Ripley, a young striver seeking to leave behind his past as an orphan bullied for "+
        "being a “sissy.” Newly arrived in the heady world of Manhattan, Ripley meets a wealthy industrialist "+
        "who hires him to bring his playboy son, Dickie Greenleaf, back from gallivanting in Italy. Soon "+
        "Ripley’s fascination with Dickie’s debonair lifestyle turns obsessive as he finds himself enraged by "+
        "Dickie’s ambivalent affections for Marge, a charming American dilettante, and Ripley begins a "+
        "deadly game.\r\n" + //
        "\r\n" + //
        "“Sinister and strangely alluring,” (Mark Harris, Entertainment Weekly) The Talented Mr. Ripley serves "+
        "as an unforgettable introduction to this smooth confidence man, whose talent for self-invention is as "+
        "unnerving—and unnervingly revealing of the American psyche—as ever.",

        "It's been six years since Ripley murdered Dickie Greenleaf and inherited his money. Now, in Ripley "+
        "Under Ground (1970), he lives in a beautiful French villa, surrounded by a world-class art collection "+
        "and married to a pharmaceutical heiress. All seems serene in Ripley's world until a phone call from "+
        "London shatters his peace. An art forgery scheme he set up a few years ago is threatening to "+
        "unravel: a nosy American is asking questions and Ripley must go to London to put a stop to it. In this "+
        "second Ripley novel, Patricia Highsmith offers a mesmerizing and disturbing tale in which Ripley will "+
        "stop at nothing to preserve his tangle of lies.",

        "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family "+
        "tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug "+
        "capable of extending life and enhancing consciousness. Coveted across the known universe, "+
        "melange is a prize worth killing for...\r\n" + //
        "\r\n" + //
        "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a journey "+
        "toward a destiny greater than he could ever have imagined. And as he evolves into the mysterious "+
        "man known as Muad’Dib, he will bring to fruition humankind’s most ancient and unattainable dream."

    };
}
