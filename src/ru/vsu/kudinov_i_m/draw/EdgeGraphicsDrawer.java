package ru.vsu.kudinov_i_m.draw;

import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.screen.ScreenConverter;
import ru.vsu.kudinov_i_m.screen.ScreenCoordinates;
import ru.vsu.kudinov_i_m.screen.ScreenPoint;
import ru.vsu.kudinov_i_m.third.PolyLine3D;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EdgeGraphicsDrawer extends AbstractGraphicsDrawer{

    public EdgeGraphicsDrawer(Graphics graphics, ScreenConverter screenConverter) {
        super(graphics, screenConverter);
    }

    @Override
    protected void drawOne(PolyLine3D polyLine) {
        List<ScreenPoint> screenPoints = new LinkedList<>();
        for (Vector3 vector3 : polyLine.getPoints()) {
            screenPoints.add(getScreenConverter().realToScreen(vector3));
        }
        if(screenPoints.size() == 1) {
            getGraphics().fillRect(screenPoints.get(0).getScreenX(), screenPoints.get(0).getScreenY(), 1, 1);
        } else if(screenPoints.size() == 2){
            getGraphics().drawLine(screenPoints.get(0).getScreenX(), screenPoints.get(0).getScreenY(), screenPoints.get(1).getScreenX(), screenPoints.get(1).getScreenY());
        } else if(screenPoints.size() > 2) {
            ScreenCoordinates screenCoordinates = new ScreenCoordinates(screenPoints);
            if(polyLine.isClosed()) {
                getGraphics().fillPolygon(screenCoordinates.getXCoordinates(), screenCoordinates.getYCoordinates(), screenCoordinates.getLength());
                Color oldColor = getGraphics().getColor();
                getGraphics().setColor(Color.BLACK);
                getGraphics().drawPolygon(screenCoordinates.getXCoordinates(), screenCoordinates.getYCoordinates(), screenCoordinates.getLength());
                getGraphics().setColor(oldColor);
            }
            else
                getGraphics().drawPolyline(screenCoordinates.getXCoordinates(), screenCoordinates.getYCoordinates(), screenCoordinates.getLength());
        }
    }

    private static final float EPS = 1e-8f;
    @Override
    protected Comparator<PolyLine3D> getComparator() {
        return new Comparator<PolyLine3D>() {
            @Override
            public int compare(PolyLine3D o1, PolyLine3D o2) {
                float delta = o2.avgZ() - o1.avgZ();
                if(Math.abs(delta) < EPS)
                    return 0;
                return delta < 0 ? -1 : 1;
            }
        };
    }

    @Override
    protected IFilter<PolyLine3D> getFilter() {
        return new IFilter<PolyLine3D>() {
            @Override
            public boolean accept(PolyLine3D value) {
                return true;
            }
        };
    }
}
