package ru.vsu.kudinov_i_m.draw;

import ru.vsu.kudinov_i_m.Shadow;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.List;

public interface IDrawer {

    Graphics getGraphics();
    void draw(List<PolyLine3D> lines);
    void clear(Color color);
    void drawShadow(Shadow shadow);
}
