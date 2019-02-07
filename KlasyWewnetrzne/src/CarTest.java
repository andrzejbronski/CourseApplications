public class CarTest {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Start");
        Car car = new Car();
        car.refuel(100);
        car.go();
    }
}
