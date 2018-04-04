package ru.stqa.pft.sandbox;

public class Point1 {
   public double x;
   public double y;
public Point1(double x, double y){
  this.x=x;
  this.y=y;
}
  public double distance(Point1 b, Point1 c) {
    return Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
  }
  }

