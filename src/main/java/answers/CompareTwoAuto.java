package answers;

import java.util.function.BinaryOperator;

public class CompareTwoAuto implements BinaryOperator<Integer> {

    @Override
    public Integer apply(Integer firstCarEnginePower, Integer secondCarEnginePower) {
        return firstCarEnginePower - secondCarEnginePower;
    }
}
