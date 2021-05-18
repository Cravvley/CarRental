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

    static final String CREATE_RENTAL_ITEM_TABLE = "CREATE TABLE IF NOT EXISTS RentalItems (id INTEGER, " +
            "carId INTEGER NOT NULL, userId INTEGER NOT NULL, daysOfRent INTEGER NOT NULL, " +
            "price REAL NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
    static final String INSERT_RENTAL_ITEM = "INSERT INTO RentalItems (id, carId, userId, "
            + "daysOfRent, price) VALUES(?,?,?,?,?)";
    static final String GET_RENTAL_ITEM = "SELECT * FROM RentalItems WHERE id = ?";
    static final String REMOVE_RENTAL_ITEM = "DELETE FROM RentalItems WHERE id = ?";
    static final String UPDATE_CAR ="UPDATE cars SET brand = ? ,"
            + "model = ? , fuelType=? , yearOfProduction = ?, "
            + "rentalPricePerDay = ? , isRent = ? WHERE id = ?";
    static final String GET_RENTAL_ITEMS = "SELECT id, carId, userId, daysOfRent "
            + ", price FROM RentalItems";

    public RentalItemRepository(){

    }
   
    public void addRentalItem(RentalItem rentalItem) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null;
        Statement statement=null;
        try {
            statement=con.createStatement();
            statement.execute(CREATE_RENTAL_ITEM_TABLE);

            ps = con.prepareStatement(INSERT_RENTAL_ITEM);
            ps.setInt(2, rentalItem.getCarId());
            ps.setInt(3, rentalItem.getUserId());
            ps.setInt(4, rentalItem.getDaysOfRent());
            ps.setFloat(5, rentalItem.getPrice());
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
        Statement statement=null;
        try {
            statement=con.createStatement();
            statement.execute(CREATE_RENTAL_ITEM_TABLE);

            ps = con.prepareStatement(REMOVE_RENTAL_ITEM);
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
        Statement statement=null;
        try {
            statement=con.createStatement();
            statement.execute(CREATE_RENTAL_ITEM_TABLE);

            ps = con.prepareStatement(GET_RENTAL_ITEM);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            rentalItem=new RentalItem(rs.getInt("id"),rs.getInt("carId"),
                rs.getInt("userId"),rs.getInt("daysOfRent"),rs.getFloat("price")); 
            
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
        Statement statement=null;
        try {
            statement=con.createStatement();
            statement.execute(CREATE_RENTAL_ITEM_TABLE);

            ps = con.createStatement();
            rs=ps.executeQuery(GET_RENTAL_ITEMS);

            while(rs.next()){
                rentals.add(new RentalItem(rs.getInt("id"),rs.getInt("carId"),
                rs.getInt("userId"),rs.getInt("daysOfRent"),
                        rs.getFloat("price")));                           
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
