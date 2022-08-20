package ru.vsu.kudinov_i_m.math;

public class Vector4 {

    private float[] values;
    private static final float EPS = 1e-12f;
    private static final int SIZE = 4;

    public Vector4(float x, float y, float z, float w) {
        this.values = new float[]{x, y, z, w};
    }

    public Vector4(float x, float y, float z) {
        this(x, y, z, 0);
    }

    public Vector4(Vector3 vector3, float w) {
        this(vector3.getX(), vector3.getY(), vector3.getZ(), w);
    }

    public Vector4(Vector3 vector3) {
        this(vector3.getX(), vector3.getY(), vector3.getZ(), 0);
    }

    private Vector4(float[] vector) {
        this.values = vector;
    }

    public Vector4 normalize() {
        if(Math.abs(getW()) < EPS) {
            return new Vector4(getX(), getY(), getZ(), getW());
        }
        return new Vector4(getX()/getW(), getY()/getW(), getZ()/getW(), 1f);
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

    public float getW() {
        return values[3];
    }

    public float getAt(int index) {
        return values[index];
    }

    public static Vector4 zeroVector() {
        return new Vector4(new float[4]);
    }

    public Vector4 multiply(float number) {
        float[] result = new float[4];
        for (int i = 0; i < SIZE; i++) {
            result[i] = this.getAt(i) * number;
        }
        return new Vector4(result);
    }

    public Vector4 plus(Vector4 otherVector) {
        float[] result = new float[4];
        for (int i = 0; i < SIZE; i++) {
            result[i] = this.getAt(i) + otherVector.getAt(i);
        }
        return new Vector4(result);
    }

    public Vector3 asVector3() {
        Vector4 result = (Math.abs(getW()) < EPS) ? this : normalize();
        return new Vector3(result.getX(), result.getY(), result.getZ());
    }


}
