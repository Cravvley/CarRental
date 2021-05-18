package car_rental_database_package;

import car_rental_entities_package.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepository {

    static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS Users (id INTEGER, " +
            "firstName TEXT NOT NULL, lastName TEXT NOT NULL, email TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
    static final String INSERT_USER ="INSERT INTO users(id, firstName, lastName, email) VALUES(?,?,?,?)";
    static final String GET_USER ="SELECT * FROM users WHERE id = ?";
    static final String REMOVE_USER ="DELETE FROM users WHERE id = ?";
    static final String UPDATE_USER ="UPDATE users SET firstName = ?, lastName= ? , email= ? WHERE id = ?";
    static final String GET_USERS ="SELECT id, firstName, lastName, email FROM users";

    private UserRepository(){

    }
   
    public static void addUser(User user) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null;
        Statement statement=null;

        try {
            statement=con.createStatement();
            statement.execute(CREATE_USER_TABLE);

            ps = con.prepareStatement(INSERT_USER);
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
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
    
    public static void removeUser(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null;
        Statement statement=null;

        try {
            statement=con.createStatement();
            statement.execute(CREATE_USER_TABLE);

            ps = con.prepareStatement(REMOVE_USER);
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
    
    public static User getUser(int id) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null; 
        ResultSet rs=null;
        Statement statement=null;
        User user=null;
        try {
            statement=con.createStatement();
            statement.execute(CREATE_USER_TABLE);

            ps = con.prepareStatement(GET_USER);
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
    
    public static void updateUser(User user) {
        Connection con= DbConnection.connect();
        PreparedStatement ps = null;
        Statement statement=null;

        try {
            statement=con.createStatement();
            statement.execute(CREATE_USER_TABLE);

            ps = con.prepareStatement(UPDATE_USER);
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
    
    public static ArrayList<User> selectAll(){
        ArrayList<User> users= new ArrayList<User>();
        
        Connection con= DbConnection.connect();
        Statement ps = null; 
        ResultSet rs=null;
        Statement statement=null;

        try {
            statement=con.createStatement();
            statement.execute(CREATE_USER_TABLE);

            ps = con.createStatement();
            rs=ps.executeQuery(GET_USERS);
          
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
}
