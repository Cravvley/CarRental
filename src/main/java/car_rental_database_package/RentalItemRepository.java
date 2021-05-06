package car_rental_database_package;

import car_rental_entities_package.RentalItem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RentalItemRepository {
    
    public RentalItemRepository(){

    }
   
    public void addRentalItem(RentalItem rentalItem) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        
    int id;
    int carId;
    int userId;
    int daysOfRent;
    float price;
    Date dateOfLoan;
        
        try {
            String sql = "INSERT INTO RentalItems (id, carId, userId, "
                    + "daysOfRent, price, dateOfLoan) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(2, rentalItem.getCarId());
            ps.setInt(3, rentalItem.getUserId());
            ps.setInt(4, rentalItem.getDaysOfRent());
            ps.setFloat(5, rentalItem.getPrice());
            ps.setDate(6, rentalItem.getDateOfLoan());
            ps.execute();
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try{
              ps.close();
              con.close();
            } catch(SQLException e) {
              System.out.println(e.toString());
             }
        }
    }
    
    /*public void removeUser(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try{
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
               }
        }
    }
    
    public User getUser(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        ResultSet rs=null; 
        User user=null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            user=new User(rs.getInt("id"),rs.getString("firstName"),
                rs.getString("lastName"),rs.getString("email")); 
            
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try{
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
               }
        }
        return user;
    }
    
    public void updateUser(User user) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        
        try {
            String sql = "UPDATE users SET firstName = ? ,"
                    + "lastName=? , email=? WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            ps.execute();
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try{
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
               }
        }
    }  
    
    public ArrayList<User> selectAll(){
        ArrayList<User> users= new ArrayList<User>();
        
        Connection con= DbConnection.connect();
        Statement ps = null; 
        ResultSet rs=null;    
        
        try {
            String sql = "SELECT id, firstName, lastName, email FROM users";
            ps = con.createStatement();
            rs=ps.executeQuery(sql);
          
            while(rs.next()){
                users.add(new User(rs.getInt("id"),rs.getString("firstName"),
                rs.getString("lastName"),rs.getString("email")));                           
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try{
                rs.close();
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
               }
        }
    
        return users;
    }
*/
}
