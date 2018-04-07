package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyPoint {

  @Test
  public void testPoint (){
    Point p1 = new Point(5.0, 6.0);
    Point p2 = new Point(7.0, 0.0);
    Assert.assertEquals(p1.distanceTO(p1, p2),6.324555320336759 );


  }
}
