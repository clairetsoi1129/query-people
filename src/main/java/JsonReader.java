import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JsonReader {

    public List<Person> readJson(String path){
        List<Person> personList = null;

        try {

            // Create a URL object with the REST API endpoint
            URL url = new URL(path);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check the response code to ensure it's a successful request (200)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response into an ArrayList of Person objects
                ObjectMapper objectMapper = new ObjectMapper();
                personList = objectMapper.readValue(response.toString(), new TypeReference<>() {
                });
                int count = 0;
                for (Person person : personList) {
                    person.setPosition(count++);
                }
            } else {
                // Handle unsuccessful request
                System.out.println("Error: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        }catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return personList;
    }
}
