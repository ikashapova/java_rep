package ru.stqa.pft.sandbox;

public class Point1 {
   public double x;
   public double y;
   public double z;
   public double m;
public Point1(double x, double y, double z, double m){
  this.x=x;
  this.y=y;
  this.z=z;
  this.m=m;
}
  public double distance() {
    return Math.sqrt((this.z - this.x) * (this.z - this.x) + (this.m - this.y) * (this.m - this.y));
  }
  }

