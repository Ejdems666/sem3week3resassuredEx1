package rest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by adam on 08/09/2017.
 */
public class CalcRestTest extends FunctionalTest {
    @Test
    public void testAdd() {
        given().when().get("/add/1/1")
                .then().body("result", equalTo(2));
    }

    @Test
    public void testSub() {
        given().when().get("/sub/2/1")
                .then().body("result", equalTo(1));
    }

    @Test
    public void testMul() {
        given().when().get("/mul/1/2")
                .then().body("result", equalTo(2));
    }

    @Test
    public void testDiv() {
        given().when().get("/div/2/1")
                .then().body("result", equalTo(2));
    }

    @Test
    public void testDivByZero() {
        given().when().get("/div/2/0")
                .then()
                .body("code", equalTo(500))
                .body("message", equalTo("/ by zero"));
    }
}
