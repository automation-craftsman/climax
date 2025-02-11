package com.devops;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Location {

	public String getLocation(double latitude, double longitude) throws IOException {

		String url = String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%f&lon=%f", latitude, longitude);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject jsonObject = new JSONObject(response.toString()); // Parse JSON
			if (jsonObject.has("address")) {
				JSONObject address = jsonObject.getJSONObject("address");
				// Construct the address string as needed.  Here's an example:
				StringBuilder addressString = new StringBuilder();
				if (address.has("road")) {
					addressString.append(address.getString("road")).append(", ");
				}
				if (address.has("city")) {
					addressString.append(address.getString("city")).append(", ");
				}
				if (address.has("state")) {
					addressString.append(address.getString("state")).append(", ");
				}
				if (address.has("country")) {
					addressString.append(address.getString("country"));
				}

				return addressString.toString();
			} else {
				return "Location: Unknown " + "( " + latitude + ", " + longitude + " )";
			}
		} else {
			return "Error: " + responseCode;
		}

	}
}
