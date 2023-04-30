package fortuneteller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.sql.SQLException;

public class DBController {

    private DatabaseModel model = new DatabaseModel();
      
    @FXML
    private AnchorPane DBScreen;

   @FXML
    private TableView<Queries> pastAnswersDatabase;
    
    @FXML
    private TableColumn<Queries, String> answerColumn;
    
    @FXML
    private TableColumn<Queries, String> questionColumn;
    
    @FXML
    private Button clear;

    @FXML
    private Button return2;

    @FXML
    private Button reveal;

    @FXML
    void handleButtonClear(ActionEvent event) 
    {
     String sql ="Delete from Question_Answer";
     
     try(Connection connection = DriverManager.getConnection("jdbc:sqlite:./fortuneteller/Resources/Question_Answer.db"))
     {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.executeUpdate();
      pastAnswersDatabase.setItems(model.getQueries());
     }
     catch(SQLException e)
     {
      System.out.printf("SQL Error: %s%n", e.getMessage());
     }
     pastAnswersDatabase.getItems().clear();
    }

    @FXML
    void handleButtonReturn2(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("WelcomeScreenFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      if(reveal.getScene().getStylesheets().size()==1)
      {
         scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
      }
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
    }

    @FXML
    void handleButtonReveal(ActionEvent event) 
    {
      pastAnswersDatabase.setItems(model.getQueries());
    }
    
    @FXML   
    public void initialize()
    {
      questionColumn.setCellValueFactory(new PropertyValueFactory<Queries, String>("question"));
      answerColumn.setCellValueFactory(new PropertyValueFactory<Queries, String>("answer"));
    }

}