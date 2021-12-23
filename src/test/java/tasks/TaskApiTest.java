package tasks;

import basetest.BaseApiTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TaskApiTest extends BaseApiTest {

    @Test
    public void testCrudActions() {

        String endpointUsers = "/public-api/users";
        String endpointPosts = "public-api/posts";
        //String endpointPostsID = "/public-api/posts/{postID}";

        String userEmail = new Random().nextInt(1000) + "aaa@gmail.com";

        //CREATE a new user

        Map user = new HashMap();

        user.put("name", "Emilija");
        user.put("email", userEmail);
        user.put("gender", "female");
        user.put("status", "active");

        int userID = given().
                spec(reqSpec).
                body(user).
        when().
                post(endpointUsers).
        then().
                log().all().
                assertThat().
                body("code", is(201)).
                extract().
                path("data.id");

        //CREATE a new post

        Map<String, Object> userPost = new HashMap<>();
        userPost.put("user_id", userID);
        userPost.put("title", "Success");
        userPost.put("body", "The work is finished");

        int postID = given().
                spec(reqSpec).
                body(userPost).
        when().
                post(endpointPosts).
        then().
                log().all().
                assertThat().
                body("code", is(201)).
                extract().
                path("data.id");

        //CHECK that previously created post is saved and post title maches

        given().
                spec(reqSpec).
                queryParam("id", postID).
        when().
                get("/public-api/posts/{postID}").
        then().
                log().all().
                assertThat().
                body("code", is(200)).
                body("data.title", is("Success"));


        //DELETE previously created post
        given().
                spec(reqSpec).
                queryParam("id", postID).
                log().all().
        when().
                delete("/public-api/posts/{postID}").
        then().
                assertThat().
                log().all().
                body("code", is(204));

        //CHECK that your post is no longer retrievable and verify with message
        given().
                spec(reqSpec).
                queryParam("id", postID).
                log().all().
        when().
                get("/public-api/posts/{postID}").
        then().
                log().all().
                assertThat().
                body("code", is(404)).
                body("data.message", is("Resource not found"));
    }
}




