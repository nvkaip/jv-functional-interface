package entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Car {

    @NonNull
    private String model;
    @NonNull
    private Engine engine;
    private String color;
    @NonNull
    private AutoType autoType;
}
