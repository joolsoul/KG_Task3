package ru.vsu.kudinov_i_m.screen;

import ru.vsu.kudinov_i_m.math.Vector3;

public class ScreenConverter
{
    private double realWidth, realHeight;
    private double cornerRealX, cornerRealY;
    private int screenWidth, screenHeight;

    public ScreenConverter(double angularRealX, double angularRealY, double realWidth, double realHeight, int screenWidth, int screenHeight)
    {
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.cornerRealX = angularRealX;
        this.cornerRealY = angularRealY;
    }

    public ScreenPoint realToScreen(Vector3 realPoint)
    {
        double screenX = (realPoint.getX() - cornerRealX) / realWidth * screenWidth;
        double screenY = (cornerRealY - realPoint.getY()) / realHeight * screenHeight;

        return new ScreenPoint((int) screenX, (int) screenY);
    }

    public Vector3 screenToReal(ScreenPoint screenPoint, float z)
    {
        double realX = cornerRealX + screenPoint.getScreenX() * realWidth / screenWidth;
        double realY = cornerRealY - screenPoint.getScreenY() * realHeight / screenHeight;

        return new Vector3((float) realX, (float) realY, z);
    }

    public Vector3 screenToReal(ScreenPoint screenPoint)
    {
        double realX = cornerRealX + screenPoint.getScreenX() * realWidth / screenWidth;
        double realY = cornerRealY - screenPoint.getScreenY() * realHeight / screenHeight;

        return new Vector3((float) realX, (float) realY, 0);
    }


    public double getRealWidth()
    {
        return realWidth;
    }

    public void setRealWidth(double realWidth)
    {
        this.realWidth = realWidth;
    }

    public double getRealHeight()
    {
        return realHeight;
    }

    public void setRealHeight(double realHeight)
    {
        this.realHeight = realHeight;
    }

    public int getScreenWidth()
    {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth)
    {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight()
    {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight)
    {
        this.screenHeight = screenHeight;
    }

    public double getCornerRealX()
    {
        return cornerRealX;
    }

    public void setCornerRealX(double cornerRealX)
    {
        this.cornerRealX = cornerRealX;
    }

    public double getCornerRealY()
    {
        return cornerRealY;
    }

    public void setCornerRealY(double cornerRealY)
    {
        this.cornerRealY = cornerRealY;
    }
}
