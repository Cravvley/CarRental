package car_rental_database_package;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository {
    
    public AdminRepository(){
        
    }
    
    public boolean login(String username,String password) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null; 
       ResultSet rs=null; 
       boolean passwordMatched=false;
       try {
           String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
           ps = con.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, password);
           rs = ps.executeQuery();
           
           if(rs.next()){
                passwordMatched=true;
           }
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
       
       return passwordMatched;
   }
}
