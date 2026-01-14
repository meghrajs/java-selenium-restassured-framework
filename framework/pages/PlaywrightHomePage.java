package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaywrightHomePage {
  private final WebDriver driver;

  public PlaywrightHomePage(WebDriver driver) {
    this.driver = driver;
  }

  private final By docsLink = By.cssSelector("a[href*='docs']");

  public void open(String baseUrl) {
    driver.get(baseUrl);
  }

  public void clickDocs() {
    driver.findElement(docsLink).click();
  }
}
