package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.model.IModel;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shadow implements IModel {
    private List<Vector3> points;

    public Shadow(List<Vector3> points) {
        this.points = points;
    }

    public List<Vector3> getPoints() {
        return points;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public List<PolyLine3D> getLines() {
        List<PolyLine3D> list = new ArrayList<>();
        list.add(new PolyLine3D(points, true));
        return list;
    }
}
