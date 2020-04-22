package hu.charmanthere.ease;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EaseApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUsersAll() {

        when().get("http://localhost:8080/api/user/all")
                .then()
                .assertThat()
                .statusCode(200);
        //.body("size()", is(2));
    }

    @Test
    public void testUsersFindId1() {

        when().get("http://localhost:8080/api/user/find/id/1")
                .then()
                .assertThat()
                .statusCode(200);
        // .body("name", Matchers.equalTo("frank"));
    }

    @Test
    public void testUsersAllLessThan5Sec() {

        when().get("http://localhost:8080/api/user/all").then().time(lessThan(5000L));


    }
}
