package CONVERSOR;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaApi {

    public double busquedaApi(int eleccion) throws IOException, InterruptedException{

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ad082f18b29ff1c8b6fd724b/latest/USD");
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(respuesta.body(), JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
    
        double valor = 0;
        switch (eleccion) {
            case 1:
                valor = conversionRates.get("USD").getAsDouble();
                break;
            case 2:
                valor = conversionRates.get("CAD").getAsDouble();
                break;
            case 3:
                valor = conversionRates.get("EUR").getAsDouble();
                break;
            case 4:
                valor = conversionRates.get("MXN").getAsDouble();
                break;
            default:
                throw new RuntimeException("Opción no válida");
        }
        return valor;

        // Devolver el valor de la conversión
    }
    
}

