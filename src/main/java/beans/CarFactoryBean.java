package beans;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car getObject() throws Exception {
        // TODO Auto-generated method stub
        return new Car(brand, 500000);
    }

    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Car.class;
    }

    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

    
}
