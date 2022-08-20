package ru.vsu.kudinov_i_m.view;

import ru.vsu.kudinov_i_m.Flatness;
import ru.vsu.kudinov_i_m.LightSource;
import ru.vsu.kudinov_i_m.ShadowController;
import ru.vsu.kudinov_i_m.draw.EdgeGraphicsDrawer;
import ru.vsu.kudinov_i_m.draw.IDrawer;
import ru.vsu.kudinov_i_m.math.Vector3;
import ru.vsu.kudinov_i_m.model.*;
import ru.vsu.kudinov_i_m.screen.ScreenConverter;
import ru.vsu.kudinov_i_m.third.Camera;
import ru.vsu.kudinov_i_m.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements CameraController.RepaintRequiredListener {

    private ScreenConverter screenConverter = new ScreenConverter(-1, 1, 2, 2, 1, 1);
    private Scene scene;
    private Camera camera;
    private CameraController cameraController;
    private Flatness flatness;
    private LightSource lightSource;
    private ShadowController shadowController;



    public DrawPanel() {
        camera = new Camera();
        cameraController = new CameraController(camera, screenConverter);
        cameraController.setRepaintRequiredListener(this);
        this.addMouseListener(cameraController);
        this.addMouseMotionListener(cameraController);
        this.addMouseWheelListener(cameraController);

        lightSource = new LightSource(new Vector3(7, 5,0.5f));

        flatness = new Flatness(new float[]{0.9f, 0.2f, 0.1f, 0.6f});
        shadowController = new ShadowController(lightSource, flatness);

        scene = new Scene(Color.WHITE, shadowController);

        scene.getModels().add(new Line3D(new Vector3(0, 0 , 0),
                new Vector3(1, 0 ,0), Color.BLUE));
        scene.getModels().add(new Line3D(new Vector3(0, 0, 0),
                new Vector3(0, 1 ,0), Color.GREEN));
        scene.getModels().add(new Line3D(new Vector3(0, 0 , 0),
                new Vector3(0, 0 ,1), Color.RED));

        scene.getModels().add(new Octahedron(new Vector3(0.0f, 0.0f, 0.0f),
                0.4f, new Color(150, 150, 150, 150)));
    }



    @Override
    public void paint(Graphics g) {
        screenConverter.setScreenWidth(getWidth());
        screenConverter.setScreenHeight(getHeight());

        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bufferedImage.createGraphics();

        IDrawer drawer = new EdgeGraphicsDrawer(gr, screenConverter);

        scene.drawWorld(camera, drawer);

        g.drawImage(bufferedImage, 0, 0, null);
        gr.dispose();

    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
