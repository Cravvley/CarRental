package car_rental_entities_package;

import java.sql.Date;

public class RentalItem {
    int id;
    int carId;
    int userId;
    int daysOfRent;
    float price;
    
    public RentalItem(int id,int carId,int userId,int daysOfRent,float price){
        this.id=id;
        this.carId=carId;
        this.userId=userId;
        this.daysOfRent=daysOfRent;
        this.price=price;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getCarId(){
        return this.carId;
    }
    
    public void setCarId(int carId){
        this.carId=carId;
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    public void setUserId(int userId){
        this.userId=userId;
    }
    
    public int getDaysOfRent(){
        return this.daysOfRent;
    }
    
    public void setdaysOfRent(int daysOfRent){
        this.daysOfRent=daysOfRent;
    }
    
    public float getPrice(){
        return this.price;
    }
    
    public void setPrice(int price){
        this.price=price;
    }
}
