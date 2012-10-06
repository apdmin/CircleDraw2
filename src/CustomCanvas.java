/*
Andrew Darwin
CSC 420: Graphical User Interfaces
Fall 2012
*/

//package csc420.hw2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CustomCanvas extends Canvas
{
  private int x, y, radius;
  private boolean filled = true;
  private boolean hidden = true;
  private boolean crossHairsShown = true;
  private boolean circleShown = false;
  private Color color;
  private final int circleMargin = 10;

  public void setCircleCoordinates(int x, int y) { this.x = x; this.y = y; }
  public void setCircleRadius(int radius) { this.radius = radius; }
  public int getCircleRadius() { return radius; }
  public void setFilled(boolean filled) { this.filled = filled; }
  public boolean isFilled() { return filled; }
  public void setHidden(boolean hidden) { this.hidden = hidden; }
  public void setCrossHairsShown(boolean crossHairsShown) { this.crossHairsShown = crossHairsShown; }
  public void setCircleShown(boolean circleShown) { this.circleShown = circleShown; }
  public boolean areCrossHairsShown() { return crossHairsShown; };
  public boolean isCircleShown() { return circleShown; };
  public void setColor(Color color) { this.color = color; }

  public void paint(Graphics g)
  {
    if (crossHairsShown)
    {
      x = CircleDraw.getXCoord();
      y = CircleDraw.getYCoord();
      radius = CircleDraw.getRadius();
      g.drawLine(x, 0, x, y-radius-circleMargin);
      g.drawLine(x, getHeight(), x, y+radius+circleMargin);
      g.drawLine(0, y, x-radius-circleMargin, y);
      g.drawLine(getWidth(), y, x+radius+circleMargin, y);
      g.setColor(CircleDraw.getColor());
      if (radius > circleMargin)
      {
        int innerMargin = (int)(radius/1.5);
        g.drawLine(x, y-radius+innerMargin, x, y+radius-innerMargin);
        g.drawLine(x-radius+innerMargin, y, x+radius-innerMargin, y);
      }
      g.drawArc(x-radius, y-radius, radius*2, radius*2, 30, 30);
      g.drawArc(x-radius, y-radius, radius*2, radius*2, 120, 30);
      g.drawArc(x-radius, y-radius, radius*2, radius*2, 210, 30);
      g.drawArc(x-radius, y-radius, radius*2, radius*2, 300, 30);
    }
    if (circleShown)
    {
      g.setColor(CircleDraw.getColor());
      if (filled)
      {
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
      }
      else
      {
        g.drawOval(x-radius, y-radius, radius*2, radius*2);
      }
    }
  }
}
