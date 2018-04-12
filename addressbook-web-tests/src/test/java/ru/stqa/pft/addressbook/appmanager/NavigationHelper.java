package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroup() {
      wd.findElement(By.linkText("groups")).click();
  }

  public void gotoContacts() {
      wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }
}
