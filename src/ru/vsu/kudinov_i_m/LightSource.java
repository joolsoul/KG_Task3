package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.math.Vector3;

public class LightSource {
    private Vector3 coordinates;

    public LightSource(Vector3 coordinates) {
        this.coordinates = coordinates;
    }

    public float getX() {
        return coordinates.getX();
    }

    public float getY() {
        return coordinates.getY();
    }

    public float getZ() {
        return coordinates.getZ();
    }

}

