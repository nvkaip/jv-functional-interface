import task.ChangeToCar;
import task.CheckElectricCar;
import task.CompareTwoAuto;
import task.RandomColor;
import entity.AutoType;
import entity.Car;
import entity.Engine;
import entity.EngineType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceTest {

    private List<Car> carList;

    @Before
    public void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("Nissan Leaf",
                new Engine(EngineType.ELECTRIC, 150), AutoType.TRUCK, 1200));
        carList.add(new Car("Ford F250",
                new Engine(EngineType.DIESEL, 385), AutoType.TRUCK, 2500));
        carList.add(new Car("Ford F150",
                new Engine(EngineType.DIESEL, 385), AutoType.TRUCK, 2500));
    }

    @Test
    public void randomColorSupplier() {
        RandomColor randomColor = new RandomColor();
        List<String> expectedColors =
                Arrays.asList("red", "green", "blue", "yellow", "pink", "black", "white");
        String actualColor = randomColor.get();
        Assert.assertTrue(expectedColors.contains(actualColor));
    }

    @Test
    public void changeToCarFunction() {
        ChangeToCar changeToCar = new ChangeToCar();
        for (Car car : carList){
            car.setAutoType(changeToCar.apply(car.getWeight()));
            if (car.getWeight() < 1500){
                Assert.assertEquals(AutoType.CAR, car.getAutoType());
            } else {
                Assert.assertEquals(AutoType.TRUCK, car.getAutoType());
            }
        }
    }

    @Test
    public void electricCarCheck() {
        CheckElectricCar electricCarPredicate = new CheckElectricCar();
        Assert.assertTrue(electricCarPredicate.test(carList.get(0)));
    }

    @Test
    public void electricCarCheckFail() {
        CheckElectricCar electricCarPredicate = new CheckElectricCar();
        Assert.assertFalse(electricCarPredicate.test(carList.get(1)));
    }

    @Test
    public void compareTwoAuto() {
        CompareTwoAuto compareTwoAuto = new CompareTwoAuto();
        Integer expectedDifference = carList.get(0).getEngine().getEnginePower()
                - carList.get(1).getEngine().getEnginePower();
        Integer actualDifference = compareTwoAuto.apply(carList.get(0).getEngine().getEnginePower(),
                carList.get(1).getEngine().getEnginePower());
        Assert.assertEquals(expectedDifference, actualDifference);
    }
}
