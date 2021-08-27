package util.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.config.ReadConfig;

public class OperatorApiMethods {
    private static final Logger logger = LoggerFactory.getLogger(OperatorApiMethods.class);


    public static String login(String email, String password) {
        logger.info("API - Login with operator credentials");
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post(ReadConfig.getConfigProperty("api_sign_in"))
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract()
                .body().jsonPath().getString("accessToken");
    }

    public static void setIdeaPromotionBannerState(String operatorAccessToken) {
        logger.info("Deactivate Idea Submission banner");
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + operatorAccessToken)
                .body("{\"enable\" : false}")
                .when()
                .put( ReadConfig.getConfigProperty("idea_submission_banner"))
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }
}


