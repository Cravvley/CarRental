/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_database_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nieku
 */
public class dbTest {

    public static void main(String []args){
        insert("Test", "Test", "test@test.com", "test");
    }
    
    private static void insert(String firstName, String secondName, String email, String password) {
         Connection con = DbConnection.connect();
  PreparedStatement ps = null; 
  try {
    String sql = "INSERT INTO users(firstName, secondName, email, password) VALUES(?,?,?,?) ";
    ps = con.prepareStatement(sql);
    ps.setString(1, firstName);
    ps.setString(2, secondName);
    ps.setString(3, email);
    ps.setString(4, password);
    ps.execute();
    System.out.println("Data has been inserted!");
  } catch(SQLException e) {
    System.out.println(e.toString());
    // always remember to close database connections
  } finally {
    try{
      ps.close();
      con.close();
    } catch(SQLException e) {
      System.out.println(e.toString());
    }
        
    }
  }
}
