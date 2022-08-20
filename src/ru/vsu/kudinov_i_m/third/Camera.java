package ru.vsu.kudinov_i_m.third;

import ru.vsu.kudinov_i_m.math.Matrix4;
import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.math.Vector4;

public class Camera implements ICamera{

    private Matrix4 translation, scale, rotation, projection;

    public Camera() {
        translation = Matrix4.oneMatrix();
        scale = Matrix4.oneMatrix();
        rotation = Matrix4.oneMatrix();
        projection = Matrix4.oneMatrix();
    }

    @Override
    public Vector3 coordinateTransformation(Vector3 point) {
        return projection.multiply(
                translation.multiply(
                        rotation.multiply(
                                scale.multiply(new Vector4(point, 1)
                                )
                        )
                )
        ).asVector3();
    }

    public Matrix4 getTranslation() {
        return translation;
    }

    public void setTranslation(Matrix4 translation) {
        this.translation = translation;
    }

    public void modifyTranslation(Matrix4 delta) {
        this.translation = delta.multiply(this.translation);
    }

    public Matrix4 getScale() {
        return scale;
    }

    public void setScale(Matrix4 scale) {
        this.scale = scale;
    }

    public void modifyScale(Matrix4 delta) {
        this.scale = delta.multiply(this.scale);
    }

    public Matrix4 getRotation() {
        return rotation;
    }

    public void setRotation(Matrix4 rotation) {
        this.rotation = rotation;
    }

    public void modifyRotation(Matrix4 delta) {
        this.rotation = delta.multiply(this.rotation);
    }

    public Matrix4 getProjection() {
        return projection;
    }

    public void setProjection(Matrix4 projection) {
        this.projection = projection;
    }

    public void modifyProjection(Matrix4 delta) {
        this.projection = delta.multiply(this.projection);
    }
}
