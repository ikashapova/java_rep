package ru.stqa.pft.sandbox;

public class MyPoint {
  public static void main(String[] args){
    Point p1 = new Point(5.0, 6.0);
    Point p2 = new Point(7.0, 0.0);

    System.out.println("Расстояние между точками = " + p1.distanceTO(p1, p2));


  }

}
