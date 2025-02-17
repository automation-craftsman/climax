# Climax - Weather Fetcher

This is a simple Java-based weather application that retrieves and displays current weather information. It uses the OpenWeatherMap API to fetch weather data based on location (latitude and longitude).

## Features

* Retrieves current weather data (description, temperature, humidity, wind speed).
* Displays weather information in a user-friendly format.
* Demonstrates how to handle API calls and JSON parsing in Java.


## Getting Started

1. **Clone the repository:**

   ```bash
   https://github.com/automation-craftsman/climax.git

2. **Add OpenWeatherMap API Key:**

* Create an account at https://openweathermap.org/
* Obtain an API key

3. **Set your API key as environment variable:**

    ```bash
   Example:
   Linux (.bashrc | /etc/profile): export CLIMAX_API_KEY=your_api_key_here
   Windows (PowerShell): [System.Environment]::SetEnvironmentVariable("CLIMAX_API_KEY", "your_api_key_here", "User")
   
4. **Build the project (Maven):**
    ```bash
   mvn clean package
   
5. **Run the application:**
    ```bash
   java -jar climax.jar <latitude> <longitude>
   
   Example:
   java -jar ./target/climax-1.0-jar-with-dependencies.jar 40.7128 -74.0060 # For New York

# Base Project Structure
    climax/
    │── src/
    │   ├── main/java/com/devops/
    │   │   ├── Climax.java
    │   │   ├── Config.java
    │   │   ├── HttpClientHelper.java
    │   │   ├── Location.java
    │   │   ├── WeatherData.java
    │   │   ├── WeatherService.java
    │   ├── test/java/com/devops/
    │   │   ├── WeatherServiceTest.java
    │── config.properties
    │── pom.xml

# Docker Image
    docker pull aliulislamabir/climax

# Contribution
Contributions are welcome! Please open an issue or submit a pull request.
