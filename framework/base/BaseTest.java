package framework.base;

import framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    driver = DriverFactory.create();
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (driver != null) driver.quit();
  }

  protected String baseUrl() {
    return Config.baseUrl();
  }
}
