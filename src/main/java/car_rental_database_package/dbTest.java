package car_rental_database_package;

import car_rental_entities_package.User;

public class dbTest {

    public static void main(String []args){
        UserRepository userRepository = new UserRepository();
 
        var item = userRepository.getUser(1);
        System.out.println(item.id);
        System.out.println(item.firstName);
        System.out.println(item.lastName);
        System.out.println(item.email);
    }   
}
