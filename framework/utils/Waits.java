package framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public final class Waits {
  private Waits() {}

  public static WebElement visible(WebDriver driver, By locator, int seconds) {
    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
      .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static void clickable(WebDriver driver, By locator, int seconds) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds))
      .until(ExpectedConditions.elementToBeClickable(locator));
  }
}
