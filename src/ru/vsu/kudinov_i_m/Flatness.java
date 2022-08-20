package ru.vsu.kudinov_i_m;

public class Flatness{
    private float[] parameters;

    public Flatness(float[] parameters) {
        this.parameters = parameters;
    }

    public float getA() {
        return parameters[0];
    }

    public float getB() {
        return parameters[1];
    }

    public float getC() {
        return parameters[2];
    }

    public float getD() {
        return parameters[3];
    }

}
