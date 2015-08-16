import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sergius on 16.08.15.
 */
public class WeatherReaderYahoo {

    public static WeatherYahoo parseWeatherXml(final int id) {
        URL wUrl;
        StringBuilder sb = new StringBuilder();
        try {
            wUrl = new URL("http://weather.yahooapis.com/forecastrss?w=" + id + "&u=c");
            HttpURLConnection con = (HttpURLConnection) wUrl.openConnection();
            BufferedReader buf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = buf.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new WeatherYahoo(sb.toString());
    }

}
