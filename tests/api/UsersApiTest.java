package tests.api;

import framework.config.Config;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersApiTest {

  @Test(groups = {"smoke", "api"})
  public void usersEndpointReturnsData() {
    RestAssured.baseURI = Config.apiBaseUrl();

    var res = given()
      .when()
      .get("/api/users?page=2")
      .then()
      .extract().response();

    Assert.assertTrue(res.statusCode() >= 200 && res.statusCode() < 300);
    Assert.assertTrue(res.jsonPath().getList("data").size() > 0);
  }
}
