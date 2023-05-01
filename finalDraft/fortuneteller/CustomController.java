package fortuneteller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;

public class CustomController
{
    @FXML
    private AnchorPane customScreen;

    @FXML
    private Button darkMode;

    @FXML
    private Button lightMode;

    @FXML
    private Button return3;

    @FXML
    void handleButton41(ActionEvent event) 
    {
      lightMode.getScene().getStylesheets().clear();
    }

    @FXML
    void handleButton42(ActionEvent event) 
    {
       darkMode.getScene().getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
    }

    @FXML
    void handleButton43(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("WelcomeScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(darkMode.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }
}
