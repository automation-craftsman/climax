package com.devops;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpClientHelper {

	public static String sendGetRequest(String urlString) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			Scanner scanner = new Scanner(connection.getInputStream());
			StringBuilder response = new StringBuilder();
			while (scanner.hasNext()) {
				response.append(scanner.nextLine());
			}
			scanner.close();
			return response.toString();
		} else {
			throw new IOException("API request failed with response code " + responseCode);
		}
	}
}
