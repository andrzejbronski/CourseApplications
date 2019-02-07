public class Car {
    private Engine engine;
    private int fuel;

    public Car() {
        engine = new Engine("Opel");
        System.out.println("Utworzono samochód marki " + engine.engineType);
    }

    public void refuel(int litres) {
        fuel = fuel + litres;
    }

    public void go() throws InterruptedException {
        while (fuel > 0) {

            engine.consumeFuel();
            System.out.println("Pozostało " + fuel + " litrów");
            Thread.sleep(1000);

        }
        System.out.println("Brak paliwa!");
    }

    public class Engine {
        private String engineType;
        private static final int FUEL_CONSUMPTION = 20;

        public Engine(String type) {
            engineType = type;
        }

        public void consumeFuel() {
            Car.this.fuel = fuel - FUEL_CONSUMPTION;
        }

    }

}
