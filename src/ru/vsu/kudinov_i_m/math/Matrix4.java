package ru.vsu.kudinov_i_m.math;

public class Matrix4 {

    private static final int SIZE = 4;
    private float[] matrix;

    public Matrix4(float[][] matrix) {
        this.matrix = new float[16];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i * SIZE + j] = matrix[i][j];
            }
        }
    }

    private Matrix4(float[] matrix) {
        this.matrix = matrix;
    }

    public static Matrix4 zeroMatrix() {
        return new Matrix4(new float[16]);
    }

    public static Matrix4 oneMatrix() {
        Matrix4 result = zeroMatrix();
        for (int i = 0; i < SIZE; i++) {
            result.setAt(i, i, 1);
        }
        return result;
    }

    public float getAt(int row, int column) {
        return matrix[row * SIZE + column];
    }

    public void setAt(int row, int column, float value) {
        matrix[row * SIZE + column] = value;
    }

    public Matrix4 multiply(float number) {
        Matrix4 result = zeroMatrix();
        for (int i = 0; i < this.matrix.length; i++) {
            result.matrix[i] = this.matrix[i] * number;
        }
        return result;
    }

    public Vector4 multiply(Vector4 vector4) {
        float[] result = new float[4];
        for (int i = 0; i < SIZE; i++) {
            float sum = 0;
            for (int j = 0; j < SIZE; j++) {
                sum += this.getAt(i, j) * vector4.getAt(j);
            }
            result[i] = sum;
        }
        return new Vector4(result[0], result[1], result[2], result[3]);
    }

    public Matrix4 multiply(Matrix4 otherMatrix) {
        Matrix4 result = zeroMatrix();
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                float sum = 0;
                for (int k = 0; k < SIZE; k++)
                    sum += this.getAt(i, k) * otherMatrix.getAt(k, j);
                result.setAt(i, j, sum);
            }
        return result;
    }

    public Matrix4 plus(Matrix4 otherMatrix) {
        Matrix4 result = zeroMatrix();
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                result.setAt(i, j, this.getAt(i, j) + otherMatrix.getAt(i, j));
        return result;
    }


}


