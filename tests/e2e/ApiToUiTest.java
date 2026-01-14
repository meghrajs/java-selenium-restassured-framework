package tests.e2e;

import framework.base.BaseTest;
import framework.config.Config;
import framework.pages.PlaywrightHomePage;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiToUiTest extends BaseTest {

  @Test(groups = {"smoke", "e2e"})
  public void apiSeedThenUiValidation() {
    RestAssured.baseURI = Config.apiBaseUrl();

    var res = given().when().get("/api/users/2").then().extract().response();
    Assert.assertTrue(res.statusCode() >= 200 && res.statusCode() < 300);

    String firstName = res.jsonPath().getString("data.first_name");
    Assert.assertNotNull(firstName);

    PlaywrightHomePage home = new PlaywrightHomePage(driver());
    home.open(baseUrl());
    home.clickDocs();

    Assert.assertTrue(driver().getCurrentUrl().contains("docs"));
  }
}
