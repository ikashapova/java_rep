package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;
  public double distance;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTO(Point a, Point b) {
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    double distance = Math.sqrt(dx * dx + dy * dy);
    return distance;

  }
}