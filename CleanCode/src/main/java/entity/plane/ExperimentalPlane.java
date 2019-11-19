package main.java.entity.plane;

import main.java.entity.type.ClassificationLevelType;
import main.java.entity.type.ExperimentalType;

public class ExperimentalPlane extends Plane{

    private ExperimentalType experimentalType;
    private ClassificationLevelType classificationLevelType;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationLevelType classificationLevelType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevelType = classificationLevelType;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    public ClassificationLevelType getClassificationLevelType() {
        return classificationLevelType;
    }

    public void setClassificationLevelType(ClassificationLevelType classificationLevelType) {
        this.classificationLevelType = classificationLevelType;
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
