package ru.vsu.kudinov_i_m.math;

public class Vector3 {

    private float[] values;

    private static final float EPS = 1e-8f;

    public Vector3(float x, float y, float z) {
        this.values = new float[]{x, y, z};
    }

    public float getX() {
        return values[0];
    }

    public float getY() {
        return values[1];
    }

    public float getZ() {
        return values[2];
    }

    public void setX(float x) {
        this.values[0] = x;
    }

    public void setY(float y) {
        this.values[1] = y;
    }

    public void setZ(float z) {
        this.values[2] = z;
    }

    public float getAt(int index) {
        return values[index];
    }

    public float length() {
        float length = getX()*getX() + getY()*getY() + getZ()*getZ();
        if(Math.abs(length) < EPS)
            return 0;
        return (float) Math.sqrt(length);
    }
}
