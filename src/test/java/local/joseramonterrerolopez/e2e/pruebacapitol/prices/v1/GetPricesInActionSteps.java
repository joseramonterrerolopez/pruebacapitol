package local.joseramonterrerolopez.e2e.pruebacapitol.prices.v1;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import local.joseramonterrerolopez.e2e.CucumberSpringConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPricesInActionSteps {
    @Autowired
    private CucumberSpringConfiguration cucumberSpringConfiguration;

    private static final String ENDPOINT = "/api/v1/prices/in-action";

    private String brandId;
    private String productId;
    private String dateTime;
    private Response response;

    @Given("the brand is {string}")
    public void the_brand_is(String brandId) {
        this.brandId = brandId;
    }

    @Given("the product id is {string}")
    public void the_product_id_is(String productId) {
        this.productId = productId;
    }

    @Given("the date and time is {string}")
    public void the_date_and_time_is(String dateTime) {
        this.dateTime = dateTime;
    }

    @When("I check the price")
    public void i_check_the_price() {
        // Send GET request to the application's API using RestAssured
        response = RestAssured.given()
                .port(cucumberSpringConfiguration.port())
                .queryParams(queryParams())
                .when()
                .get(ENDPOINT)
                .then()
                .extract()
                .response();
    }

    @Then("I should get a price record:")
    public void i_should_get_a_price_record(DataTable expectedPriceRecord) {
        // Extract the first row of the table as a map
        Map<String, String> row = expectedPriceRecord.asMaps(String.class, String.class).get(0);

        // Validate the response status code and each field
        Integer statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        JsonPath body = response.jsonPath();
        assertEquals(parseInt(row.get("product_id")), body.getInt("productId"));
        assertEquals(parseInt(row.get("brand_id")), body.getInt("brandId"));
        assertEquals(parseInt(row.get("price_list")), body.getInt("priceList"));
        assertEquals(row.get("start_date"), body.getString("startDate"));
        assertEquals(row.get("end_date"), body.getString("endDate"));
        assertEquals(parseFloat(row.get("price")), body.getFloat("price"));
    }

    private Map<String, String> queryParams()
    {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("brandId", brandId);
        queryParams.put("productId", productId);
        queryParams.put("dateTime", dateTime);
        return queryParams;
    }
}

