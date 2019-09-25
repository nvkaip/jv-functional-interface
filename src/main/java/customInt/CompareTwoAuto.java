package customInt;

import entity.Car;

import java.util.function.BinaryOperator;

public class CompareTwoAuto implements BinaryOperator<Car> {

    @Override
    public Car apply(Car firstCar, Car secondCar) {
        int firstCarEngineVolume = firstCar.getEngine().getEnginePower();
        int secondCarEngineVolume = secondCar.getEngine().getEnginePower();
        return firstCarEngineVolume < secondCarEngineVolume ? firstCar : secondCar;
    }
}
