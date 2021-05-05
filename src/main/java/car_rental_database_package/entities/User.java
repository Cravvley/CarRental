package car_rental_database_package.entities;

public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    
    public User(int id,String firstName,String lastName,String email){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
}
