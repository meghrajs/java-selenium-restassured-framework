package framework.base;

import framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
  public static WebDriver create() {
    ChromeOptions options = new ChromeOptions();
    if (Config.headless()) options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    return new ChromeDriver(options);
  }
}
