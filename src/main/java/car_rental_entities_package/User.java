package car_rental_entities_package;

public class User {
    int id;
    String firstName;
    String lastName;
    String email;
    
    public User(int id,String firstName,String lastName,String email){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
     public String getFirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName=firstName;
    } 
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName=lastName;
    }   
    
     public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }   
}
