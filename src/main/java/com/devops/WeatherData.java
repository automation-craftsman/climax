package com.devops;

import org.json.JSONObject;

public class WeatherData {
	private String description;
	private double temperature;
	private int humidity;
	private double windSpeed;

	public WeatherData(String description, double temperature, int humidity, double windSpeed) {
		this.description = description;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
	}

	public static WeatherData fromJson(String jsonResponse) {
		JSONObject json = new JSONObject(jsonResponse);

		// Handle API error response
		if (json.has("error")) {
			return new WeatherData("Error retrieving data", 0.0, 0, 0.0);
		}

		// Extract weather details
		String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
		double temperature = json.getJSONObject("main").getDouble("temp");
		int humidity = json.getJSONObject("main").getInt("humidity");
		double windSpeed = json.getJSONObject("wind").getDouble("speed");

		return new WeatherData(description, temperature, humidity, windSpeed);
	}

	@Override
	public String toString() {
		return String.format("Weather: %s | Temp: %.2f°C | Humidity: %d%% | Wind Speed: %.2f m/s\n",
				description, temperature, humidity, windSpeed);
	}

	// Getters (optional, useful for testing)
	public String getDescription() {
		return description;
	}

	public double getTemperature() {
		return temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}
}
