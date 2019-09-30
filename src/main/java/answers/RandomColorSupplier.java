package answers;

import java.util.Random;
import java.util.function.Supplier;

public class RandomColorSupplier implements Supplier {

    private static final String [] COLORS = {"red", "green", "blue", "yellow", "pink", "black", "white"};

    @Override
    public String get() {
        int i = new Random().nextInt(7);
        return COLORS[i];
    }
}
