package ejercicio4;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String[] pruebas = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}",
            ""
        };

        System.out.println("Pruebas predefinidas:");

        // Recorremos cada cadena del arreglo y aplicamos el método symbolBalancing
        for (String expresion : pruebas) {
            boolean resultado = Aplication.symbolBalancing(expresion); // Verificamos si la cadena está balanceada
            System.out.println(expresion + " -> " + resultado); // Imprimimos el resultado junto a la cadena original
        }

        // Ahora permitimos que el usuario escriba sus propias cadenas para probar
        Scanner scanner = new Scanner(System.in); // Creamos el objeto Scanner para leer desde el teclado
        System.out.println("\nIngresa una cadena. Escribe 'salir' para terminar.");

        // Bucle infinito que se rompe cuando el usuario escribe "salir"
        while (true) {
            System.out.print("Ingresa una cadena: ");
            String entrada = scanner.nextLine(); // Leemos la cadena ingresada por el usuario

            // Si escribe "salir", salimos del bucle
            if (entrada.equalsIgnoreCase("salir")) { // Este método ignora si las letras están en mayúsculas o minúsculas.
                break;
            }

            // Aplicamos el método de verificación a la cadena ingresada
            boolean resultado = Aplication.symbolBalancing(entrada);
            System.out.println("Resultado: " + resultado); // Mostramos si está balanceada o no
        }

        // Mensaje final al terminar el programa
        System.out.println("Programa finalizado.");
        scanner.close(); // Cerramos el objeto Scanner
    }
}
