package answers;

import entity.AutoType;

import java.util.function.Function;

public class ChangeToCarFunction implements Function<Integer, AutoType> {
    @Override
    public AutoType apply(Integer weight) {
        return weight < 1500 ? AutoType.CAR : AutoType.TRUCK;
    }
}
