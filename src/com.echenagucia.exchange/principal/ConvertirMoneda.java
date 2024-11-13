package principal;

import com.google.gson.Gson;
import modelos.MonedaExchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {

   String Apikey = "bf2ee8aa6bd2dd17b213742b";
   public MonedaExchange moneda (String origen, String destino, double monto){

       URI direction = URI.create("https://v6.exchangerate-api.com/v6/"+ Apikey  + "/pair/" + origen + "/" + destino + "/" + monto);
       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder()
               .uri(direction)
               .build();

       HttpResponse<String> response = null;
       try {
           response = client
                   .send(request, HttpResponse.BodyHandlers.ofString());
       } catch (IOException  | InterruptedException e) {
           throw new RuntimeException(e);
       }

       String json = response.body();

       return new Gson().fromJson(response.body(),MonedaExchange.class);





   }




}
