package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hexahedron implements IModel{

    private Vector3 centre;
    private float radius;
    private Color color;

    public Hexahedron(Vector3 centre, float radius, Color color) {
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
        float halfSide = (float) (radius / Math.sqrt(3));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() + halfSide)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() - halfSide)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() - halfSide)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() - halfSide)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() - halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() - halfSide, centre.getZ() - halfSide)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() + halfSide),
                new Vector3(centre.getX() - halfSide, centre.getY() + halfSide, centre.getZ() - halfSide),
                new Vector3(centre.getX() + halfSide, centre.getY() + halfSide, centre.getZ() - halfSide)
        ), true));

        return lines;
    }
}