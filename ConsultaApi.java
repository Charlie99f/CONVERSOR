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

        // VARIABLE PARA MODIFICAR LA APIKEY 
        String apiKey = "ad082f18b29ff1c8b6fd724b";

        // SE DECLARA VARIABLE TIPO <URI PARA ALMACENAR LA DIREXION DE LA API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD");
        // SE CREA NUEVO <HttpClient
        HttpClient cliente = HttpClient.newHttpClient();
        //SE CREA UN REQUEST CON LA DIRECCION DE LA API 
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        // SE DECLARA VARIABLE TIPO <HttpResponse Y SE USA PARA MANDAR EL REQUEST Y SE ESPECIFICA QUE EL CUERPO DE LA RESPUESTA SE MANEJARA COMO <String
        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());


        //SE CREA INSTANCIA TIPO <Gson 
        Gson gson = new Gson();
        //SE CREA VARIABLE TIPO <JsonObject Y SE ALMACENA LA INSTANCIA <gson PARA APLICAR EL METODO <fromJson() DONDE SE TOMA EL JSON DE LA RESPUESTA HTTP Y SE ESPECIFICA QUE SE CONVIERTE EN UN ONJETO <JsonObject
        JsonObject jsonManipulable = gson.fromJson(respuesta.body(), JsonObject.class);
        // **AQUI ESPECIFICAMENTE OBTIENE TODOS LOS VALORES ("KEY" : VALUE), <conversion_rates ES UNA KEY ESPECIFICA DE LA API DONDE SE ALMASENAN TODAS LAS MONEDAS ("KEY" : VALUE)
        // SE CREA VARIABLE TIPO <JsonObject , SE USA PARA CREAR UN JSON SECUNDARIO CON LOS VALORES ("KEY" : VALUE) QUE CONTIENE <conversion_rates A PARTIR DEL JSON PRINCIPAL <jsonManipulable
        JsonObject valoresAPI = jsonManipulable.getAsJsonObject("conversion_rates");

        double valor = 0;

        // SE CREA ESTRUCTURA DE CONTROL TIPO <switch Y COMO PARAMETRO TIENE LA VARIABLE <eleccion QUE ES EL INPUT DEL USUARIO 
        
        switch (eleccion) {
            //DEPENDIENDO DEL CASO (<case) OSEA EL INPUT (1, 2, 3 o 4) Y BUSCA LA "KEY" INTRODUCIDA EN EL METODO <get() para OBTENER EL VALOR Y ASIGNARLO A LA VARIABLE <valor  
            case 1:
                valor = valoresAPI.get("AUD").getAsDouble();
                break;
            case 2:
                valor = valoresAPI.get("CAD").getAsDouble();
                break;
            case 3:
                valor = valoresAPI.get("EUR").getAsDouble();
                break;
            case 4:
                valor = valoresAPI.get("MXN").getAsDouble();
                break;
            //SI <eleccion NO ES IGUAL A (1, 2, 3 o 4) SE LANZA LA EXCEPCION <RuntimeException E IMPRIME EL MENSAJE DDE DENTRO
            default:
                throw new RuntimeException("Hasta luego!!");
        }
        // SI ELECCION ES IGUAL A (1, 2, 3 o 4) SE DEVUELVE LA VARIABLE <valor CON EL "KEY" : VALUE ASIGNADO 
        return valor;
    }
    
}

