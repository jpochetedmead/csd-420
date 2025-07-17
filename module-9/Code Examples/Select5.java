import java.sql.*;

public class Select5 {

  public static void main(String[] args) {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/databasedb?";
      Connection con = DriverManager.getConnection(url + "user=student1&password=pass");

      System.out.println("Connection established - now executing select");

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

      System.out.println("Results:");

      int columnCount = rs.getMetaData().getColumnCount();

      while (rs.next()) {
        for (int i = 1; i <= columnCount; i++) {
          System.out.print(rs.getString(i) + " ");
        }
        System.out.println();
      }

      stmt.close();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}