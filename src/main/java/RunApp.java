import customInt.RandomColorSupplier;
import entity.AutoType;
import entity.Car;
import entity.Engine;
import entity.EngineType;

public class RunApp {

    public static void main(String[] args) {

        Car electricCar = new Car("Audi 3", new Engine(EngineType.ELECTIC), AutoType.CAR);
        RandomColorSupplier randomColorSupplier = new RandomColorSupplier();
        electricCar.setColor(randomColorSupplier.get());
        System.out.println(electricCar);
    }
}
