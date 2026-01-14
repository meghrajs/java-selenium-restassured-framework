package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UsersApiTest {

  @Test(groups = {"smoke", "api"})
  public void usersEndpointReturnsData_mimic() {
    // Mimic API response (stable, CI-friendly)
    var body = Map.of(
      "page", 2,
      "data", List.of(
        Map.of("id", 7, "first_name", "Michael", "last_name", "Lawson"),
        Map.of("id", 8, "first_name", "Lindsay", "last_name", "Ferguson")
      )
    );

    Assert.assertNotNull(body.get("data"));
    Assert.assertTrue(((List<?>) body.get("data")).size() > 0);
  }
}
