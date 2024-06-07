package CONVERSOR;

import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        Scanner cantidadDeseada = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        System.out.println("""
            ---------------------------------------------
                Seleccione opcion deseada:

                1. USD
                2. CAD
                3. EUR
                4. MXN 
            
                5. Salir

            ---------------------------------------------
                """);
            System.out.println("Introduce opcion: ");

        

        try {
            int eleccion = Integer.parseInt(sc.nextLine());
            double valor = consulta.busquedaApi(eleccion);
            System.out.println("El valor de la opción seleccionada es: " + valor);

            System.out.println("Introduzca cantidad a combertir: ");

            int eleccion2 = Integer.parseInt(cantidadDeseada.nextLine());
            System.out.println("Cantidad a cambiar " + eleccion2);

            if (eleccion == 1){
                double resultado = eleccion2 * valor;
                System.out.println("Cantidad comvertida = " + resultado);
            }else if (eleccion == 2){
                double resultado = eleccion2 * valor;
                System.out.println("Cantidad comvertida = " + resultado);
            }else if (eleccion == 3){
                double resultado = eleccion2 * valor;
                System.out.println("Cantidad comvertida = " + resultado);
            }else if (eleccion == 4){
                double resultado = eleccion2 * valor;
                System.out.println("Cantidad comvertida = " + resultado);
            }
 
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizo aplicacion");
        }

    }
}