package fortuneteller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.scene.control.TextField;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class AskController {
      
    @FXML
    private Button answer;

    @FXML
    private AnchorPane askScreen;

    @FXML
    private Label resultsField;

    @FXML
    private Button return1;

    @FXML
    private Button save;

    @FXML
    private TextField questionField;

    @FXML
    void handleButtonAnswer(ActionEvent event) 
    {
       String[] replies = {"No", "Yes", "Not Likely", "Very Likely", "I like what I see in your future!",
                   "I do not like what your future holds!", "Ask again later"};
         Random ran = new Random();
         String replies_ran = replies[ran.nextInt(replies.length)];
         
         resultsField.setText(replies_ran);
    }

    @FXML
    void handleButtonReturn(ActionEvent event) throws IOException
    {
       FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("WelcomeScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(save.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }

    @FXML
    void handleButtonSave(ActionEvent event) 
    {
      try(Connection connection = DriverManager.getConnection("jdbc:sqlite:./fortuneteller/Resources/Question_Answer.db"))
      {
         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);
         statement.executeUpdate(String.format("insert into Question_Answer(question, answer) values('%s', " + "'%s')", questionField.getText(), resultsField.getText()));
      }
      catch(SQLException e)
      {
         System.out.printf("SQL Error: %s%n", e.getMessage());
      }
    }

}