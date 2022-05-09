package Six;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
public class ParseResponse {
    private Response response;
    public ParseResponse(){
        RestAssured.baseURI = "http://dataservice.accuweather.com/";
        response = given()
                .when()
                .get("forecasts/v1/daily/5day/294021?apikey=yODGgbTvYC5fkSQNmG0rOnvPB1V8vo89%20&q=Moscow&language=en");
    }
    @SneakyThrows
    public List<DailyForecasts> getDailyForecasts(){
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper
                .readTree(response.asPrettyString())
                .at("/DailyForecasts");

        List<DailyForecasts> dailyForecasts = new ArrayList<>();

        if(jsonNode.isArray()){
            for (JsonNode arrayItem : jsonNode) {
                dailyForecasts.add(objectMapper.convertValue(arrayItem,DailyForecasts.class));
            }
        }
        return dailyForecasts;
    }
}
