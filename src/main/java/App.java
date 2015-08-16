import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sergius on 14.08.15.
 */
public class App {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                                                                                    //2264778
                WeatherYahoo weather = WeatherReaderYahoo.parseWeatherXml(Integer.parseInt(args[0]));
                new ConkyWeatherWrite(weather, "city", "country", "code", "temperature", "temperatureU");
            }
        }, 0, 1800 * 1000);
    }
}
