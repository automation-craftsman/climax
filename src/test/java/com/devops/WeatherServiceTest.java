package com.devops;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeatherServiceTest {
	private WeatherService weatherService;

	@BeforeClass
	public void setUp() {
		weatherService = new WeatherService();
	}

	@Test
	public void testValidWeatherResponse() {

		double latitude = 23.80408;  // Dhaka
		double longitude = 90.41524;

		WeatherData weatherData = weatherService.getWeather(latitude, longitude);

		System.out.println(weatherData);

		Assert.assertNotNull(weatherData, "WeatherData should not be null");
		Assert.assertNotEquals(weatherData.getDescription(), "Error retrieving data", "Weather description should not be an error message");
	}

	@Test
	public void testInvalidCoordinates() {
		double latitude = 999;  // Invalid latitude
		double longitude = 999; // Invalid longitude

		WeatherData weatherData = weatherService.getWeather(latitude, longitude);

		Assert.assertNotNull(weatherData, "WeatherData should not be null");
		Assert.assertEquals(weatherData.getDescription(), "Error retrieving data", "Weather description should indicate an error");
	}
}
