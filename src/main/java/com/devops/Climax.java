package com.devops;

public class Climax {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java -jar Climax.jar <latitude> <longitude>");
			return;
		}

		try {
			double latitude = Double.parseDouble(args[0]);
			double longitude = Double.parseDouble(args[1]);


//			System.out.println("Fetching weather for: Lat = " + latitude + ", Lon = " + longitude);

			WeatherService weatherService = new WeatherService();
			WeatherData weatherData = weatherService.getWeather(latitude, longitude);

			System.out.println(weatherData);

		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please provide numeric values for latitude and longitude.");
		}
	}
}
