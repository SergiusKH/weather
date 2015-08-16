import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by sergius on 16.08.15.
 */
public class ConkyWeatherWrite {

    private StringBuilder sb = new StringBuilder();

    public ConkyWeatherWrite(WeatherYahoo weather, String... data) {

        for (String d : data) {
            try {
                Field field = weather.getClass().getDeclaredField(d);
                field.setAccessible(true);
                String valueField = (String) field.get(weather);
                sb.append(d + "=\""+ valueField + "\"\n");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            File file = new File("/home/sergius/.weather/weather");
            try(BufferedWriter buffW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)))) {
                buffW.write(sb.toString(), 0, sb.toString().length());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
