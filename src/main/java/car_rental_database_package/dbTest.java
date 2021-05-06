package car_rental_database_package;

import car_rental_entities_package.Car;

public class dbTest {

    public static void main(String []args){
        CarRepository carRepository = new CarRepository();

        var item=carRepository.selectAll();
        for(Car car : item){
            System.out.println(car.getBrand());
        }

    }   
}
