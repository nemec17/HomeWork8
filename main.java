package Six;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class main {

    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();
        ParseResponse parseResponse = new ParseResponse();

        for (DailyForecasts dailyForecast: parseResponse.getDailyForecasts()) {

            dbConnection.insertValue("Moscow",
                    dailyForecast.getDate(),
                    dailyForecast.getDay().getIconPhrase(),
                    Double.parseDouble(dailyForecast.getTemperature().getMinimum().getValue()));

        }

        System.out.println(dbConnection.getValue("localDate","temperature", 70.0));

    }

}