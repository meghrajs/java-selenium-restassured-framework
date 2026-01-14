package framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ScreenshotUtil {

  private ScreenshotUtil() {}

  public static void capture(WebDriver driver, String testName) {
    try {
      if (!(driver instanceof TakesScreenshot)) return;

      Path dir = Path.of("target", "screenshots");
      Files.createDirectories(dir);

      File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File dest = dir.resolve(sanitize(testName) + ".png").toFile();

      FileUtils.copyFile(src, dest);
      System.out.println("[ARTIFACT] Screenshot saved: " + dest.getAbsolutePath());
    } catch (Exception e) {
      System.out.println("[WARN] Failed to capture screenshot: " + e.getMessage());
    }
  }

  private static String sanitize(String name) {
    return name.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
  }
}
