package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {

    // curl -u "anna_ds6Jvj:BvFsNCs2kcYFxy1fkBb3" -X GET "https://api.browserstack.com/app-automate/sessions/b68b008e4a683bb67f434bad3a28280c19ef871d.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("anna_ds6Jvj", "BvFsNCs2kcYFxy1fkBb3")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
