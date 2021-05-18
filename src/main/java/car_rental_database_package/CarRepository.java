package car_rental_database_package;

import car_rental_entities_package.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CarRepository {

    static final String CREATE_CAR_TABLE = "CREATE TABLE IF NOT EXISTS Cars (id INTEGER, " +
            "brand	TEXT NOT NULL, model TEXT NOT NULL, fuelType TEXT NOT NULL, yearOfProduction INTEGER NOT NULL, " +
            "rentalPricePerDay REAL NOT NULL, isRent INTEGER NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
    static final String INSERT_CAR ="INSERT INTO cars(id, brand, model, fuelType, "
            + "yearOfProduction, rentalPricePerDay, isRent) VALUES(?,?,?,?,?,?,?)";
    static final String GET_CAR ="SELECT * FROM cars WHERE id = ?";
    static final String REMOVE_CAR ="DELETE FROM cars WHERE id = ?";
    static final String UPDATE_CAR ="UPDATE cars SET brand = ? ,"
            + "model = ? , fuelType=? , yearOfProduction = ?, "
            + "rentalPricePerDay = ? , isRent = ? WHERE id = ?";
    static final String GET_RENT_CARS ="SELECT id, brand, model, fuelType, yearOfProduction ,"
            + "rentalPricePerDay, isRent "
            + "FROM cars where isRent=1";
    static final String GET_NO_RENT_CARS ="SELECT id, brand, model, fuelType, yearOfProduction ,"
            + "rentalPricePerDay, isRent "
            + "FROM cars where isRent=0";
    static final String GET_CARS ="SELECT id, brand, model, fuelType, yearOfProduction ,"
            + "rentalPricePerDay, isRent "
            + "FROM cars";

    private CarRepository(){
        
    }

    public static void addCar(Car car) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null;
        Statement statement=null;
        try {
           statement=con.createStatement();
           statement.execute(CREATE_CAR_TABLE);

           ps = con.prepareStatement(INSERT_CAR);
           ps.setString(2, car.getBrand());
           ps.setString(3, car.getModel());
           ps.setString(4, car.getFuelType());
           ps.setInt(5, car.getYearOfProduction());
           ps.setFloat(6, car.getRentalPricePerDay());
           ps.setBoolean(7, car.getIsRent());
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

   public static void removeCar(int id) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null;
       Statement statement=null;
       try {
           statement=con.createStatement();
           statement.execute(CREATE_CAR_TABLE);

           ps = con.prepareStatement(REMOVE_CAR);
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

   public static Car getCar(int id) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 
       ResultSet rs=null; 
       Car car=null;
       Statement statement=null;
       try {
           statement=con.createStatement();
           statement.execute(CREATE_CAR_TABLE);

           ps = con.prepareStatement(GET_CAR);
           ps.setInt(1, id);
           rs=ps.executeQuery();

           car=new Car(rs.getInt("id"),rs.getString("brand"),
               rs.getString("model"),rs.getString("fuelType"),
                   rs.getInt("yearOfProduction"),rs.getFloat("rentalPricePerDay")
           ,rs.getBoolean("isRent")); 

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

   public static void updateCar(Car car) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null;
       Statement statement=null;
       try {
           statement=con.createStatement();
           statement.execute(CREATE_CAR_TABLE);

           ps = con.prepareStatement(UPDATE_CAR);
           ps.setString(1, car.getBrand());
           ps.setString(2, car.getModel());
           ps.setString(3, car.getFuelType());
           ps.setInt(4, car.getYearOfProduction());
           ps.setFloat(5,car.getRentalPricePerDay());
           ps.setBoolean(6,car.getIsRent());
           ps.setInt(7, car.getId());
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

   public static ArrayList<Car> selectAll(boolean all,boolean rent){
       ArrayList<Car> cars= new ArrayList<Car>();

       Connection con= DbConnection.connect();
       Statement ps = null; 
       ResultSet rs=null;
       Statement statement=null;
       try {
           statement=con.createStatement();
           statement.execute(CREATE_CAR_TABLE);

           String sql;
           if(all){
               sql = GET_CARS;
           }else{
               if(rent){
                   sql = GET_RENT_CARS;
               }else{
                   sql = GET_NO_RENT_CARS;
               }
           }
           ps = con.createStatement();
           rs=ps.executeQuery(sql);

           while(rs.next()){
               cars.add(new Car(rs.getInt("id"),rs.getString("brand"),
               rs.getString("model"),rs.getString("fuelType"),
                   rs.getInt("yearOfProduction"),rs.getFloat("rentalPricePerDay")
                            ,rs.getBoolean("isRent")));                           
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
