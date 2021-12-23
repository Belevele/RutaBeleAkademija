package basetest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

public class BaseApiTest {

    protected static RequestSpecification reqSpec;

    @BeforeClass
    public static void setUp() {
        String token = "f98be55edff4122b7ef9a61cd078bcfd3704612b6576aac0d7e97c4714e320b9";
        reqSpec = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + token).
                addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter())).
                build();
    }
}
