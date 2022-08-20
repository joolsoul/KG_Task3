package ru.vsu.kudinov_i_m.third;

import ru.vsu.kudinov_i_m.math.Vector3;

import java.util.LinkedList;
import java.util.List;

public class PolyLine3D {
    private List<Vector3> points;
    private boolean isClosed = false;

    public PolyLine3D(List<Vector3> points, boolean isClosed) {
        this.points = new LinkedList<>();
        this.points.addAll(points);
        this.isClosed = isClosed;
    }

    public List<Vector3> getPoints() {
        return new LinkedList<>(points);
    }

    public boolean isClosed() {
        return isClosed;
    }

    public float avgZ() {
        if (points == null || points.size() == 0)
            return 0;
        float sum = 0;
        for (Vector3 v : points)
            sum += v.getZ();
        return sum / points.size();
    }
}
