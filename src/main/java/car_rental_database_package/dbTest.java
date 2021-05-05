package car_rental_database_package;
import car_rental_database_package.entities.User;

public class dbTest {

    public static void main(String []args){
        UserRepository userRepository = new UserRepository();
          var userList=userRepository.selectAll();
          for(User user : userList){
              System.out.println(user.id);
              System.out.println(user.firstName);
              System.out.println(user.lastName);
              System.out.println(user.email);
          }  
           
          User userxd3=new User(5,"etet","Net","test@gmail.com");
          userRepository.updateUser(userxd3);
    }   
}
