package CONVERSOR;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaApi {

    public Api busquedaApi(int eleccion){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ad082f18b29ff1c8b6fd724b/latest/USD");

        HttpClient cliente = HttpClient.newHttpClient();
    
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
    
        try {
            HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
    
            return new Gson().fromJson(respuesta.body(), Api.class);
            
        } catch (Exception e) {
            throw new RuntimeException("ERROR");

        }

    }
    
}
