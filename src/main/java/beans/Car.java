package beans;

public class Car {

    private String brand;
    private int price;
//    private double tyrePerimeter;
    
    public Car(String brand, int price) {
        super();
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", price=" + price + "]";
    }
    
}
