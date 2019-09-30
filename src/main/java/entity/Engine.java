package entity;

import java.util.Objects;

public class Engine {

    private EngineType engineType;
    private Integer enginePower;

    public Engine(EngineType engineType, Integer enginePower) {
        this.engineType = engineType;
        this.enginePower = enginePower;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return engineType == engine.engineType &&
                Objects.equals(enginePower, engine.enginePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineType, enginePower);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineType=" + engineType +
                ", enginePower=" + enginePower +
                '}';
    }
}
