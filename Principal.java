package CONVERSOR;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        // SE INICIA UN SCANNER PARA SELECCIONAR LA OPERACION DESEADA
        Scanner seleccionarOperacion = new Scanner(System.in);
        // SE INICIA SCANNER PARA INTRODUCIR LA CANTIDAD DE DOLARES
        Scanner cantidadDeseada = new Scanner(System.in);
        // SE DECLARA INSTANCIA TIPO <ConsultaApi Y SE CREA
        ConsultaApi consulta = new ConsultaApi();

        int eleccion = 0;

        // LOOP WHILE QUE CONTINUARA MIENTRAS <eleccion SEA DIFERENTE A "5"
        while (eleccion != 5) {

            System.out.println("""
                    ---------------------------------------------
                        Seleccione operacion deseada:

                        1. USD  -->  AUD
                        2. USD  -->  CAD
                        3. USD  -->  EUR
                        4. USD  -->  MXN

                        5. Salir

                    ---------------------------------------------
                        """);
            System.out.print("Introduce opcion: ");

            // BLOQUE TRY PARA MANEJAR ERRORES
            try {
                // A LA VARIABLE <eleccion SE LE ASIGNA EL INPUT DE LA VARIABLE
                // <seleccionarOperacion (SE ACTIVA EL SCANNER "seleccionarOperacion")
                eleccion = Integer.parseInt(seleccionarOperacion.nextLine());
                // SE DECLARA VARIABLE TIPO <double DESPUES, DE LA INSTANCIA <consulta SE LLAM A
                // AL METODO <busquedaApi() Y SE LE PASA COMO VALOR LA VARIABLE <eleccion QUE
                // CONTIENE EL INPUT DEL USUARIO
                double valor = consulta.busquedaApi(eleccion);

                System.out.print("Introduzca cantidad de dolares combertir: ");

                // A LA VARIABLE <eleccion2 SE LE ASIGNA EL INPUT DE LA VARIABLE
                // <cantidadDeseada (SE ACTIVA EL SCANNER "cantidadDeseada")
                int eleccion2 = Integer.parseInt(cantidadDeseada.nextLine());

                // SE ESTABLECE LA LOGICA DE OPERACIONES SEGUN EL EL INPUT QUE EL USUARIO
                // REALIZO PARA LA VARIABLE <eleccion
                if (eleccion == 1) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad comvertida = " + resultado);
                } else if (eleccion == 2) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad comvertida = " + resultado);
                } else if (eleccion == 3) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad comvertida = " + resultado);
                } else if (eleccion == 4) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad comvertida = " + resultado);
                }

                System.out.println("""

                        """);

                // EN CASO DE QUE ALGO DE LO ANTERIOR FALLE SE CORRE EL <catch
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }

        }

    }
}