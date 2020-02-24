import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.google.gson.*;

import java.net.ResponseCache;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginAndShowListOfAircrafts {
  String token;
    @Test
    public void loginTestCase (){
        HashMap<String, String> header = new HashMap<String, String>();
        //header.put("Content-Type", "Content-Type");
        header.put("X-API-VERSION", "1.3");

        HashMap<String, String > body = new HashMap<String, String>();
        body.put("email", "bohdan.zherebukh@rocketroute.com");
        body.put("password", "Qwerty12345.");
        body.put("app_key", "c42672bb58951a4a6b0cd7f5e8577548");

        Response r = given().contentType("application/json").headers(header).body(body).
                when().post("https://flydev-host1.rocketroute.com/api/login").
                then().extract().response();

        //r.prettyPrint();
        token = r.path("data.access_token");
        System.out.println("Token " + token);
  }
}
