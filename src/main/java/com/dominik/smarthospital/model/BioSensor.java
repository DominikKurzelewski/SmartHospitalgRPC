package com.dominik.smarthospital.model;

public class BioSensor {
    String type;
    double value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BioSensor{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
