package framework.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
  private static final Properties props = new Properties();

  static {
    try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (in != null) props.load(in);
    } catch (Exception e) {
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }

  public static String baseUrl() {
    return System.getProperty("BASE_URL", props.getProperty("baseUrl", "https://playwright.dev"));
  }

  public static String apiBaseUrl() {
    return System.getProperty("API_BASE_URL", props.getProperty("apiBaseUrl", "https://reqres.in"));
  }

  public static boolean headless() {
    return Boolean.parseBoolean(System.getProperty("HEADLESS", props.getProperty("headless", "true")));
  }
}
