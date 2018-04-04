package ru.stqa.pft.sandbox;

public class MyPoint {
  public static void main(String[] args){
    Point1 s = new Point1(5, 6);
    Point1 b = new Point1(0, 0);
    System.out.println("Расстояние между точками = " + distance(s, b));


  }
  public static double distance(Point1 b, Point1 c) {
    return Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
  }
}
