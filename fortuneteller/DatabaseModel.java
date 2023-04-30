package fortuneteller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DatabaseModel
{
   private ObservableList <Queries> queries;
   
   public DatabaseModel()
   {
      queries = FXCollections.observableArrayList();
      
       Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:./fortuneteller/Resources/Question_Answer.db");
         String queryString = "Select Question, Answer From Question_Answer";
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(queryString);
         
         while(rs.next())
         {
            queries.add(new Queries(rs.getString("Question"), rs.getString("Answer")));
         }
       }
       catch(SQLException e)
       {
         e.printStackTrace();
       }
   }
   public static void clearQueries (String empQueries) throws SQLException, ClassNotFoundException
   {
    /*String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Question_Answer\n" +
                        "         WHERE Question ="+ empQueries +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }*/
   }
   
   public ObservableList<Queries> getQueries()
   {
      return queries;
   }
   
   public void setQueries(ObservableList<Queries> queries)
   {
      this.queries = queries;
   }
}