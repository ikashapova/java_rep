package ru.stqa.pft.sandbox;

import java.awt.*;

public class MyfirstProgram {


  public static void main(String[] args) {
    System.out.println("Hello, world!");
    Point1 c = new Point1();
    c.x = 4;
    c.y = 5;
    Point1 b = new Point1();
    b.x = 0;
    b.y = 0;
    System.out.println("Расстояние между точками = " + distance(c, b));

  }

  public static double distance(Point1 b, Point1 c) {
    return Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y));
  }
}



