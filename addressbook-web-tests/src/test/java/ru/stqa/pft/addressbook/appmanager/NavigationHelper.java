package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroup() {
      click(By.linkText("groups"));
  }

  public void gotoContacts() {
      click(By.xpath("//div/div[4]/div/i/a[2]"));
  }
}
