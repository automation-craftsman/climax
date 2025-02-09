package com.devops;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static final Properties properties = new Properties();

	static {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new IOException("Unable to find 'config.properties' in resources");
			}

			properties.load(input);

		} catch (IOException e) {
			System.err.println("Error loading config.properties: " + e.getMessage()); // Use System.err for errors
		}
	}

	public static String getApiKey() {
		String apiKey = System.getenv("CLIMAX_API_KEY");
		if (apiKey == null || apiKey.isEmpty()) {
			throw new RuntimeException("""
							API Key not found!
							Set CLIMAX_API_KEY as an environment variable.
			    
							Example:
							Linux (.bashrc | /etc/profile): export CLIMAX_API_KEY=your_api_key_here
							Windows (PowerShell): [System.Environment]::SetEnvironmentVariable("CLIMAX_API_KEY", "your_api_key_here", "User")
							""");
		}
		return apiKey;
	}

	public static String getApiUrl(String key) {
		return properties.getProperty(key);
	}
}