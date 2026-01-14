package framework.base;

import framework.config.Config;
import framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    WebDriver driver = DriverFactory.create();
    DriverManager.set(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    try {
      if (!result.isSuccess() && DriverManager.get() != null) {
        ScreenshotUtil.capture(DriverManager.get(), result.getName());
      }
    } finally {
      if (DriverManager.get() != null) {
        DriverManager.get().quit();
      }
      DriverManager.unload();
    }
  }

  protected WebDriver driver() {
    return DriverManager.get();
  }

  protected String baseUrl() {
    return Config.baseUrl();
  }
}
