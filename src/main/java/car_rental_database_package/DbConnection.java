package car_rental_database_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

  private static final  String CONNECTION_STRING="jdbc:sqlite:db/CarRental.db";

  private DbConnection(){

  }

  public static Connection connect() {
    Connection con = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection(CONNECTION_STRING);
      System.out.println("Connected!");
    } catch (ClassNotFoundException | SQLException e ) {
      System.out.println(e+"");
    }
    return con; 
  }
}
