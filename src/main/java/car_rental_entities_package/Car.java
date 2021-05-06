package car_rental_entities_package;

public class Car {
    
    int id;
    String brand;
    String model;
    String fuelType;
    int yearOfProduction;
    float rentalPricePerDay;
    
    public Car(int id,String brand,String model,String fuelType,int yearOfProduction
                 ,float rentalPricePerDay){
       this.id=id;
       this.brand=brand;
       this.model=model;
       this.fuelType=fuelType;
       this.yearOfProduction=yearOfProduction;
       this.rentalPricePerDay=rentalPricePerDay;
   }

   public int getId(){
       return this.id;
   }

   public void setId(int id){
       this.id=id;
   }

    public String getBrand(){
       return this.brand;
   }

   public void setBrand(String brand){
       this.brand=brand;
   } 

   public String getModel(){
       return this.model;
   }

   public void setModel(String model){
       this.model=model;
   }   
   
    public String getFuelType(){
       return this.fuelType;
   }

   public void setFuleType(String fuleType){
       this.fuelType=fuelType;
   }   

    public int getYearOfProduction(){
       return this.yearOfProduction;
   }

   public void setYearOfProduction(int yearOfProduction){
       this.yearOfProduction=yearOfProduction;
   }
    
   public float getRentalPricePerDay(){
       return this.rentalPricePerDay;
   }
   
   public void setRentalPricePerDay(float rentalPricePerDay){
       this.rentalPricePerDay=rentalPricePerDay;
   }
}
