package ru.vsu.kudinov_i_m.model;

import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.List;

public interface IModel {

    Color getColor();
    List<PolyLine3D> getLines();
}
