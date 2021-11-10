package dasniko.quarkus.funqy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@QuarkusTest
public class GreetingFunctionTest {

    @Test
    public void testPlain() {
        given().contentType("application/json")
                .body("\"John\"")
                .post("/plain")
                .then()
                .statusCode(200)
                .body(containsString("Hello John"));
    }

    @Test
    public void testHello() {
        given().contentType("application/json")
                .param("name", "john")
                .get("/hello")
                .then()
                .statusCode(200)
                .body("hello", is("john"));
    }

    @Test
    public void testGreeting() {
        given().contentType("application/json")
                .param("first", "John")
                .param("last", "Doe")
                .get("/greet")
                .then()
                .statusCode(200)
                .body("message", is("Hello, John Doe"));
    }

    @Test
    public void testFamilyGet() {
        given().contentType("application/json")
                .param("mom.first", "Jane")
                .param("mom.last", "Doe")
                .param("dad.first", "John")
                .param("dad.last", "Doe")
                .param("kids", "Peter", "Mary")
                .get("/family")
                .then()
                .statusCode(200)
                .body(containsString("Hello Mom, Jane Doe and Dad, John Doe, with the kids Peter, Mary!"));
    }

    @Test
    public void testFamilyPost() {
        Family family = new Family(new Person("Jane", "Doe"), new Person("John", "Doe"), List.of("Peter", "Mary"));
        given().contentType("application/json")
                .body(family)
                .post("/family")
                .then()
                .statusCode(200)
                .body(containsString("Hello Mom, Jane Doe and Dad, John Doe, with the kids Peter, Mary!"));
    }

}
