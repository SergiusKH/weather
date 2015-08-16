import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergius on 14.08.15.
 */

public class WeatherYahoo {

    private String xml;
    private String city;
    private String country;
    private String temperature;
    private String pressure;
    private String speed;
    private String temperatureU;
    private String distanceU;
    private String pressureU;
    private String speedU;
    private String chill;
    private String direction;
    private String humidity;
    private String visibility;
    private String rising;
    private String sunrise;
    private String sunset;
    private String text;
    private String code;
    private String date;


    public WeatherYahoo(String xml) {
        this.xml = xml;
        locationWeather();
        unitsWeather();
        windWeather();
        astronomyWeather();
        atmosphereWeather();
        conditionWeather();
    }

    private void locationWeather() {
        Matcher location = Pattern.compile("<yweather:location city=\"(\\w+?)\"\\s+?region=\"([\\w|\\w+]?)\"\\s+?country=\"(\\w+?)\"/>")
                .matcher(xml);
        if (location.find()) {
            city = location.group(1);
            country = location.group(3);
        }
    }

    private void unitsWeather() {
        Matcher units = Pattern.compile("<yweather:units temperature=\"(\\w?)\"\\s+?distance=\"(\\w+?)\"\\s+?pressure=\"(\\w+?)\"\\s+?speed=\"(\\w+?/\\w+?)\"/>")
                .matcher(xml);
        if (units.find()) {
            temperatureU = units.group(1);
            distanceU = units.group(2);
            pressureU = units.group(3);
            speedU = units.group(4);
        }

    }

    private void windWeather() {
        Matcher wind = Pattern.compile("<yweather:wind chill=\"(\\d+)\"\\s+?direction=\"(\\d+)\"\\s+?speed=\"(\\d+\\.\\d+)\"\\s+?/>")
                .matcher(xml);
        if (wind.find()) {
            chill = wind.group(1);
            direction = wind.group(2);
            speed = wind.group(3);
        }
    }

    private void atmosphereWeather() {
        Matcher atmosphere = Pattern.compile("<yweather:atmosphere humidity=\"(\\d+)\"\\s+?visibility=\"(\\d+\\.\\d+)\"\\s+?pressure=\"(\\d+\\.\\d+)\"\\s+?rising=\"(\\d+)\"")
                .matcher(xml);
        if (atmosphere.find()) {
            humidity = atmosphere.group(1);
            visibility = atmosphere.group(2);
            pressure = atmosphere.group(3);
            rising = atmosphere.group(4);
        }
    }

    private void astronomyWeather() {
        Matcher astronomy = Pattern.compile("<yweather:astronomy sunrise=\"(\\d+:\\d+ am)\"\\s+?sunset=\"(\\d+:\\d+ pm)\"")
                .matcher(xml);
        if (astronomy.find()) {
            sunrise = astronomy.group(1);
            sunset = astronomy.group(2);
        }
    }

    private void conditionWeather() {
        Matcher condition = Pattern.compile("<yweather:condition\\s+?text=\"([\\w+?\\s+?]{1,})\"\\s+?code=\"(\\d+)\"\\s+?temp=\"(\\d+)\"\\s+?" +
                "date=\"(\\w+, \\d+ \\w+ \\d+ \\d+:\\d+ \\w+ \\w+)\"\\s+?/>")
                .matcher(xml);
        if (condition.find()) {
            text = condition.group(1);
            code = condition.group(2);
            temperature = condition.group(3);
            date = condition.group(4);
        }
    }

//    public void forecastWeather() {
//        Matcher location = Pattern.compile("<yweather:forecast\\s+?day=\"(\\w+)\"\\s+?date=\"(\\d+ \\w+ \\d+)\"\\s+?low=\"(\\d+)\"\\s+?" +
//                "high=\"(\\d+)\"\\s+?text=\"([\\w+?\\s+?]{1,})\"\\s+?code=\"(\\d+)\"\\s+?/>")
//                .matcher(xml);
//        while (location.find()) {
//            System.out.println(location.group());
//            System.out.println(location.group(1));
//            System.out.println(location.group(2));
//            System.out.println(location.group(3));
//            System.out.println(location.group(4));
//            System.out.println(location.group(5));
//            System.out.println(location.group(6));
//        }
//    }

}
