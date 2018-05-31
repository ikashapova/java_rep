package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import java.io.File;

public class Dir extends TestBase {

  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
  }



}
