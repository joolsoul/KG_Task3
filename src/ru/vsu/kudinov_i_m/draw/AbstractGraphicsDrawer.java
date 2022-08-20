package ru.vsu.kudinov_i_m.draw;

import ru.vsu.kudinov_i_m.Shadow;
import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.screen.ScreenConverter;
import ru.vsu.kudinov_i_m.screen.ScreenCoordinates;
import ru.vsu.kudinov_i_m.screen.ScreenPoint;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGraphicsDrawer implements IDrawer {

    private Graphics graphics;
    private ScreenConverter screenConverter;

    public AbstractGraphicsDrawer(Graphics graphics, ScreenConverter screenConverter) {
        this.graphics = graphics;
        this.screenConverter = screenConverter;
    }

    @Override
    public void draw(List<PolyLine3D> lines) {
        List<PolyLine3D> accepted = new ArrayList<>();
        IFilter<PolyLine3D> filter = getFilter();
        for (PolyLine3D polyLine : lines) {
            if(filter.accept(polyLine))
                accepted.add(polyLine);
        }

        accepted.sort(getComparator());

        for (PolyLine3D polyLine : accepted) {
            drawOne(polyLine);
        }
    }

    @Override
    public void clear(Color color) {
       Color oldColor = getGraphics().getColor();
       getGraphics().setColor(color);
       getGraphics().fillRect(0, 0, getScreenConverter().getScreenWidth(), getScreenConverter().getScreenHeight());
       getGraphics().setColor(oldColor);
    }

    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public void drawShadow(Shadow shadow) {
        Color oldColor = getGraphics().getColor();
        getGraphics().setColor(Color.BLACK);
        drawOne(new PolyLine3D(shadow.getPoints(), true));
        getGraphics().setColor(oldColor);
        /*
        List<ScreenPoint> screenPoints = new LinkedList<>();
        for (Vector3 vector3 : shadow.getPoints()) {
            screenPoints.add(getScreenConverter().realToScreen(vector3));
        }
        ScreenCoordinates screenCoordinates = new ScreenCoordinates(screenPoints);
            //getGraphics().setColor(new Color(150, 150, 150, 150));
            getGraphics().fillPolygon(screenCoordinates.getXCoordinates(), screenCoordinates.getYCoordinates(), screenCoordinates.getLength());
            Color oldColor = getGraphics().getColor();
            getGraphics().setColor(Color.BLACK);
            getGraphics().drawPolygon(screenCoordinates.getXCoordinates(), screenCoordinates.getYCoordinates(), screenCoordinates.getLength());
            getGraphics().setColor(oldColor);

         */

    }

    public ScreenConverter getScreenConverter() {
        return screenConverter;
    }

    protected abstract void drawOne(PolyLine3D polyLine);
    protected abstract Comparator<PolyLine3D> getComparator();
    protected abstract IFilter<PolyLine3D> getFilter();
}
