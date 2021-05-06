package car_rental_database_package;

import car_rental_entities_package.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CarRepository {
    
    public CarRepository(){
        
    }

    public void addCar(Car car) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 

       try {
           String sql = "INSERT INTO cars(id, brand, model, fuelType, yearOfProduction) VALUES(?,?,?,?,?)";
           ps = con.prepareStatement(sql);
           ps.setString(2, car.getBrand());
           ps.setString(3, car.getModel());
           ps.setString(4, car.getFuelType());
           ps.setInt(5, car.getYearOfProduction());
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

   public void removeCar(int id) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 

       try {
           String sql = "DELETE FROM cars WHERE id = ?";
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

   public Car getCar(int id) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 
       ResultSet rs=null; 
       Car car=null;
       try {
           String sql = "SELECT * FROM cars WHERE id = ?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();

           car=new Car(rs.getInt("id"),rs.getString("brand"),
               rs.getString("model"),rs.getString("fuelType"),
                   rs.getInt("yearOfProduction")); 

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
       return car;
   }

   public void updateCar(Car car) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 

       try {
           String sql = "UPDATE cars SET brand = ? ,"
                   + "model= ? , fuelType=? , yearOfProduction=? WHERE id = ?";
           ps = con.prepareStatement(sql);
           ps.setString(1, car.getBrand());
           ps.setString(2, car.getModel());
           ps.setString(3, car.getFuelType());
           ps.setInt(4, car.getYearOfProduction());
           ps.setInt(5, car.getId());
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

   public ArrayList<Car> selectAll(){
       ArrayList<Car> cars= new ArrayList<Car>();

       Connection con= DbConnection.connect();
       Statement ps = null; 
       ResultSet rs=null;    

       try {
           String sql = "SELECT id, brand, model, fuelType, yearOfProduction "
                   + "FROM cars";
           ps = con.createStatement();
           rs=ps.executeQuery(sql);

           while(rs.next()){
               cars.add(new Car(rs.getInt("id"),rs.getString("brand"),
               rs.getString("model"),rs.getString("fuelType"),
                   rs.getInt("yearOfProduction")));                           
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

       return cars;
   }
}
