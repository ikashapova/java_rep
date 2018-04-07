package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyPoint2 {

  @Test
  public void testPoint (){
    Point p1 = new Point(-2.0, -6.0);
    Point p2 = new Point(7.0, 9.0);
    Assert.assertEquals(p1.distanceTO(p1, p2),17.4928556845359 );


  }
}
