
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GUIController {

    
    
    @FXML
    private TextField txtFieldName;

    private Stage mainWindow;

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }

    @FXML
    void onBtnClick(ActionEvent event) {
        String title = txtFieldName.getText();
        mainWindow.setTitle(title);


    }

}

    

