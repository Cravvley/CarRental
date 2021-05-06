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
    
    public void removeRentalItem(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        
        try {
            String sql = "DELETE FROM RentalItems WHERE id = ?";
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
    
    public RentalItem getRentalItem(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        ResultSet rs=null; 
        RentalItem rentalItem=null;
        try {
            String sql = "SELECT * FROM RentalItems WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            rentalItem=new RentalItem(rs.getInt("id"),rs.getInt("carId"),
                rs.getInt("userId"),rs.getInt("daysOfRent"),rs.getFloat("price")
                    ,rs.getDate("dateOfLoan")); 
            
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
        return rentalItem;
    }
      
    public ArrayList<RentalItem> selectAll(){
        ArrayList<RentalItem> rentals= new ArrayList<RentalItem>();
        
        Connection con= DbConnection.connect();
        Statement ps = null; 
        ResultSet rs=null;    
        
        try {
            String sql = "SELECT id, carId, userId, daysOfRent "
                    + ", price, dateOfLoan FROM RentalItems";
            ps = con.createStatement();
            rs=ps.executeQuery(sql);
          
            while(rs.next()){
                rentals.add(new RentalItem(rs.getInt("id"),rs.getInt("carId"),
                rs.getInt("userId"),rs.getInt("daysOfRent"),
                        rs.getFloat("price"),rs.getDate("dateOfLoan")));                           
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
        return rentals;
    }

}
