package entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Engine {

    @NonNull
    private EngineType engineType;
    @NonNull
    private Integer enginePower;
}
