package com.devops;

public class WeatherService {
	private static final String API_KEY = Config.getApiKey();
	private static final String BASE_URL = Config.getApiUrl("api.url");

	public WeatherData getWeather(double latitude, double longitude) {
		String apiUrl = String.format("%s?lat=%f&lon=%f&appid=%s&units=metric", BASE_URL, latitude, longitude, API_KEY);

		try {
			Location loc = new Location();
			System.out.println("Location: " + loc.getLocation(latitude, longitude));
			String response = HttpClientHelper.sendGetRequest(apiUrl);
			return WeatherData.fromJson(response);
		} catch (Exception e) {
			return new WeatherData("Error retrieving data", 0.0, 0, 0.0);
		}
	}
}
