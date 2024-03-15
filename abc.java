import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApp {
    private static final String API_KEY = "your_openweathermap_api_key";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public static void main(String[] args) {
        // Prompt the user to enter a location
        System.out.println("Enter a location:");
        String location = System.console().readLine();

        // Fetch and display weather information
        try {
            String weatherData = fetchWeatherData(location);
            System.out.println(weatherData);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private static String fetchWeatherData(String location) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + location + "&appid=" + API_KEY))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
