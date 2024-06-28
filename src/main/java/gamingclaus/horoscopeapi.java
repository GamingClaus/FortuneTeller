package gamingclaus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONObject;

public class horoscopeapi {
    String sign;
    String day;
    String horoscope_data;
    Scanner scanner = new Scanner(System.in);

    public String getSign() {
        System.out.println("Enter your Sign:");
        return scanner.nextLine().trim();
    }

   public String getDay() {
    System.out.println("Enter Day: (/Today/Tomorrow/Yesterday)");
        return scanner.nextLine().trim();
        }


        public String horoscopefetcher(String sign, String day) throws IOException, InterruptedException {
           
            // Construct the API URL with the sign and day
            String urlapi = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=" + sign + "&day=" + day;
        
            // Create the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(urlapi))
            .build();
        
            // Create the HTTP client
            HttpClient client = HttpClient.newBuilder().build();
        
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            if(response.statusCode()!=200){
                 
                System.out.println("ERROR: "+response.statusCode());
                return null;
            }
            else{
                JSONObject jsonResponse = new JSONObject(response.body());
            
                JSONObject dataObject = jsonResponse.getJSONObject("data");
                String horoscopeData = dataObject.getString("horoscope_data");

            
                //System.out.println(horoscopeData);
                // Return the horoscope data
                return horoscopeData;
            }
        }

        public void setText(String horoscope_data2) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setText'");
        }
        
    
}

