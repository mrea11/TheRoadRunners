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

public class WelcomeController {

    @FXML
    private Button toAsk;

    @FXML
    private Button toCustom;

    @FXML
    private Button toDBScreen;

    @FXML
    private AnchorPane welcomeScreen;

    @FXML
    void handleButton11(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("AskScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(toAsk.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
         //toAsk.getScene().getStylesheets().size()==0;
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }

    @FXML
    void handleButton12(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("DBScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(toAsk.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }

    @FXML
    void handleButton13(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CustomScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(toAsk.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }

}
