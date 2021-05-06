package car_rental_entities_package;

import java.util.Date;

public class RentalItem {
    int id;
    int carId;
    int userId;
    int daysOfRent;
    int price;
    Date dateOfLoan;
    
    public RentalItem(int id,int carId,int userId,int daysOfRent,int price,
                        Date dateOfLoan){
        this.id=id;
        this.carId=carId;
        this.userId=userId;
        this.daysOfRent=daysOfRent;
        this.price=price;
        this.dateOfLoan=dateOfLoan;
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
    
    public int getPrice(){
        return this.price;
    }
    
    public void setPrice(int price){
        this.price=price;
    }
    
     public Date getDateOfLoan(){
        return this.dateOfLoan;
    }
    
    public void setDateOfLoan(Date dateOfLoan){
        this.dateOfLoan=dateOfLoan;
    }
}
