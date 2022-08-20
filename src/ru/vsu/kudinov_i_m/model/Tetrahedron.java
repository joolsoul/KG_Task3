package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tetrahedron implements IModel {

    private Vector3 centre;
    private float radius;
    private Color color;

    public Tetrahedron(Vector3 centre, float radius, Color color) {
        this.centre = centre;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();

        lines.add(new PolyLine3D(Arrays.asList(new Vector3(centre.getX(), centre.getY(), centre.getZ() + radius) /*S*/,
                new Vector3(centre.getX() + (float) (2 * Math.sqrt(2) * radius / 3), centre.getY(), centre.getZ() - radius / 3) /*A*/,
                new Vector3(centre.getX() - radius / 2, centre.getY() + (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*B*/ ), true));

        lines.add(new PolyLine3D(Arrays.asList(new Vector3(centre.getX(), centre.getY(), centre.getZ() + radius) /*S*/,
                new Vector3(centre.getX() + (float) (2 * Math.sqrt(2) * radius / 3), centre.getY(), centre.getZ() - radius / 3) /*A*/,
                new Vector3(centre.getX() - radius / 2,centre.getY() - (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*C*/), true));

        lines.add(new PolyLine3D(Arrays.asList(new Vector3(centre.getX(), centre.getY(), centre.getZ() + radius) /*S*/,
                new Vector3(centre.getX() - radius / 2, centre.getY() - (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*C*/,
                new Vector3(centre.getX() - radius / 2, centre.getY() + (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*B*/ ), true));

        lines.add(new PolyLine3D(Arrays.asList(new Vector3(centre.getX() - radius / 2, centre.getY() + (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*B*/ ,
                new Vector3(centre.getX() + (float) (2 * Math.sqrt(2) * radius / 3), centre.getY(), centre.getZ() - radius / 3) /*A*/,
                new Vector3(centre.getX() - radius / 2, centre.getY() - (float) (Math.sqrt(3) / 2 * radius), centre.getZ() - radius / 3) /*C*/), true));

        return lines;
    }
}
