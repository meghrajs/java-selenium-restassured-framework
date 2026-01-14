package tests.ui;

import framework.base.BaseTest;
import framework.pages.PlaywrightHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

  @Test(groups = {"smoke", "ui"})
  public void homepageLoads() {
    PlaywrightHomePage home = new PlaywrightHomePage(driver);
    home.open(baseUrl());
    Assert.assertTrue(driver.getTitle().toLowerCase().contains("playwright"));
  }
}
