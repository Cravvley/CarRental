package car_rental_database_package;

import java.sql.*;

public  class AdminRepository {

    static final String CREATE_ADMIN_TABLE= "CREATE TABLE IF NOT EXISTS Admin (username TEXT NOT NULL UNIQUE, " +
            "password TEXT NOT NULL)";
    static final String INSERT_ADMIN="INSERT INTO ADMIN VALUES('test','test')";
    static final String GET_ADMIN_DEFAULT_PASSWORDS="SELECT * FROM Admin where username = 'test' and password = 'test'";
    static final String GET_ADMIN="SELECT * FROM admin WHERE username = ? and password = ?";

    private AdminRepository(){
        
    }
    
    public static boolean login(String username,String password) {
       Connection con= DbConnection.connect();
       PreparedStatement ps = null;
       ResultSet rs=null;
       Statement statement=null;

       boolean passwordMatched=false;
       try {
           statement=con.createStatement();
           statement.execute(CREATE_ADMIN_TABLE);

           ps = con.prepareStatement(GET_ADMIN_DEFAULT_PASSWORDS);
           rs=ps.executeQuery();

           if(!rs.next()){
                statement.execute(INSERT_ADMIN);
           }

           ps = con.prepareStatement(GET_ADMIN);
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
               statement.close();
           } catch(SQLException e) {
               System.out.println(e.toString());
              }
       }
       
       return passwordMatched;
   }
}
