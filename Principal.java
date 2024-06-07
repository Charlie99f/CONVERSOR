package CONVERSOR;

import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        System.out.println("""
                ############################################
                Seleccione opcion deseada:

                1.
                2.
                3.
                4.

                5.

                """);

        try{
            var eleccion = Integer.valueOf(sc.nextLine());

            Api api = consulta.busquedaApi(eleccion);
            System.out.println(api);
            //System.out.println(api);

        }catch (RuntimeException e ){
            System.out.println(e.getMessage());
            System.out.println("Finalizo aplicacion");
        }


    }
}
