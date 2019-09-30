package answers;

import entity.Car;
import entity.EngineType;

import java.util.function.Predicate;

public class CheckElectricCarPredicate implements Predicate<Car> {

    @Override
    public boolean test(Car car) {
        return car.getEngine().getEngineType().equals(EngineType.ELECTRIC);
    }
}
