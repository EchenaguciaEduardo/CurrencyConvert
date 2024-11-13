package principal;

import com.google.gson.Gson;
import modelos.MonedaExchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean continuar = true;

        Scanner lec = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("Sea bienvenido/a al conversor de monedas = " + "\n");


        String menu = "1)     Dólar =>>  Peso argentino" + "\n" +
                "2)     Peso argentino =>>  Dólar" + "\n" +
                "3)     Dólar =>>  Real brasileño" + "\n" +
                "4)     Real brasileño =>>  Dólar" + "\n" +
                "5)     Dólar =>>  Peso colombiano" + "\n" +
                "6)     Peso colombiano =>>  Dólar" + "\n" +
                "7) Salir" + "\n";

        while (continuar) {
            ConvertirMoneda convertir = new ConvertirMoneda();
            System.out.println(menu);
            System.out.println("Elije una opcion valida: ");
            System.out.println("**************************************");
            int option = 0;
            option = lec.nextInt();
            String origen = "", destino = "";
            double monto = 0;

            if (option == 7) {
                System.out.println("Gracias por usar nuestro conversor.");
                continuar = false;
                break;
            }

            switch (option) {
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 2:
                    origen = "ARS";
                    destino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();

                    break;
                case 3:
                    origen = "USD";
                    destino = "BRL";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 4:
                    origen = "BRL";
                    destino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 5:
                    origen = "USD";
                    destino = "COP";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 6:
                    origen = "COP";
                    destino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor de monedas ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Debe escoger un numero entre 1 y 6 " + "\n");
                    continue;
            }
            MonedaExchange monedaExchange = convertir.moneda(origen, destino, monto);
            System.out.println("El valor " + monto + " [" + origen + "] " + "corresponde al valor final de =>>> " + monedaExchange.conversion_result() + " [" + destino + "] " + "\n");

        }

    }

}
