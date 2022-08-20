package ru.vsu.kudinov_i_m.view;

import ru.vsu.kudinov_i_m.math.MatricesFactory;
import ru.vsu.kudinov_i_m.math.Matrix4;
import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.math.Vector4;
import ru.vsu.kudinov_i_m.screen.ScreenConverter;
import ru.vsu.kudinov_i_m.screen.ScreenPoint;
import ru.vsu.kudinov_i_m.third.Camera;

import javax.swing.*;
import java.awt.event.*;

public class CameraController implements MouseListener, MouseMotionListener, MouseWheelListener {

    public interface RepaintRequiredListener {
        void shouldRepaint();
    }

    private RepaintRequiredListener listener = null;
    private Camera camera;
    private ScreenConverter screenConverter;

    public CameraController(Camera camera, ScreenConverter screenConverter) {
        this.camera = camera;
        this.screenConverter= screenConverter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    ScreenPoint lastPoint = null;
    boolean leftFlag, rightFlag, middleFlag;
    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e))
            leftFlag = true;
        if (SwingUtilities.isRightMouseButton(e))
            rightFlag = true;
        if (SwingUtilities.isMiddleMouseButton(e))
            middleFlag = true;
        lastPoint = new ScreenPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e))
            leftFlag = false;
        if (SwingUtilities.isRightMouseButton(e))
            rightFlag = false;
        if (SwingUtilities.isMiddleMouseButton(e))
            middleFlag = false;
        lastPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ScreenPoint currentPoint = new ScreenPoint(e.getX(), e.getY());
        int dx = currentPoint.getScreenX() - lastPoint.getScreenX();
        int dy = currentPoint.getScreenY() - lastPoint.getScreenY();
        if(leftFlag) {
            double deltaAlpha = dx * Math.PI / 180;
            double deltaBeta = dy * Math.PI / 180;

            Matrix4 delta = MatricesFactory.rotation(deltaAlpha, MatricesFactory.Axis.Y)
                            .multiply(MatricesFactory.rotation(deltaBeta, MatricesFactory.Axis.X));
            camera.modifyRotation(delta);
        }

        if(rightFlag) {
            Vector4 zero = new Vector4(screenConverter.screenToReal(new ScreenPoint(0, 0)), 0);
            Vector4 delta = new Vector4(screenConverter.screenToReal(new ScreenPoint(dx, dy)), 0);
            Vector3 actualDelta = delta.plus(zero.multiply(-1f)).asVector3();
            camera.modifyTranslation(MatricesFactory.translation(actualDelta));
        }

        if (middleFlag && dy != 0) {
            Vector4 zero = new Vector4(screenConverter.screenToReal(new ScreenPoint(0, 0)), 0);
            Vector4 current = new Vector4(screenConverter.screenToReal(new ScreenPoint(dx, dy)), 0);
            Vector3 actualDelta = current.plus(zero.multiply(-1)).asVector3();
            float deltaZ = actualDelta.length();
            if (dy < 0)
                deltaZ = -deltaZ;
            camera.modifyTranslation(MatricesFactory.translation(0, 0, deltaZ));
        }
        lastPoint = currentPoint;
        onRepaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int delta = e.getWheelRotation();
        if (e.isControlDown()) {
            camera.modifyProjection(MatricesFactory.projection(delta*5f, MatricesFactory.Axis.Z));
        } else {
            float factor = 1;
            float scale = delta < 0 ? 0.9f : 1.1f;
            int counter = delta < 0 ? -delta : delta;
            while (counter-- > 0)
                factor *= scale;
            camera.modifyScale(MatricesFactory.scale(factor));
        }
        onRepaint();
    }

    public void setRepaintRequiredListener(RepaintRequiredListener listener) {
        this.listener = listener;
    }

    protected void onRepaint() {
        if(listener != null) {
            listener.shouldRepaint();
        }
    }

}
