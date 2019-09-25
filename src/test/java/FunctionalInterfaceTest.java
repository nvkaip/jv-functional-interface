import customInt.ChangeToCarFunction;
import customInt.CheckElectricCarPredicate;
import customInt.CompareTwoAuto;
import customInt.RandomColorSupplier;
import entity.AutoType;
import entity.Car;
import entity.Engine;
import entity.EngineType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
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
        RandomColorSupplier randomColorSupplier = new RandomColorSupplier();
        List<String> expectedColors =
                Arrays.asList("red", "green", "blue", "yellow", "pink", "black", "white");
        String actualColor = randomColorSupplier.get();
        Assert.assertTrue(expectedColors.contains(actualColor));
    }

    @Test
    public void changeToCarFunction() {
        ChangeToCarFunction changeToCarFunction = new ChangeToCarFunction();
        for (Car car : carList){
            car.setAutoType(changeToCarFunction.apply(car.getWeight()));
            if (car.getWeight() < 1500){
                Assert.assertEquals(AutoType.CAR, car.getAutoType());
            } else {
                Assert.assertEquals(AutoType.TRUCK, car.getAutoType());
            }
        }
    }

    @Test
    public void electricCarCheck() {
        CheckElectricCarPredicate electricCarPredicate = new CheckElectricCarPredicate();
        Assert.assertTrue(electricCarPredicate.test(carList.get(0)));
    }

    @Test
    public void electricCarCheckFail() {
        CheckElectricCarPredicate electricCarPredicate = new CheckElectricCarPredicate();
        Assert.assertFalse(electricCarPredicate.test(carList.get(1)));
    }

    @Test
    public void compareTwoAuto() {
        CompareTwoAuto compareTwoAuto = new CompareTwoAuto();
        Car expectedCar = carList.get(0);
        Car actualCar = compareTwoAuto.apply(carList.get(0), carList.get(1));
        Assert.assertEquals(expectedCar, actualCar);
    }

    @Test
    public void compareTwoEqualAuto() {
        CompareTwoAuto compareTwoAuto = new CompareTwoAuto();
        Car expectedCar = carList.get(1);
        Car actualCar = compareTwoAuto.apply(carList.get(1), carList.get(2));
        log.info("Expected: " + expectedCar + " actual: " + actualCar);
        Assert.assertEquals(expectedCar, actualCar);
    }
}