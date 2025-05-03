package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<String> colaString = new QueueArray<>(5);

        colaString.enqueue("Rosario");
        colaString.enqueue("de");
        colaString.enqueue("los");
        colaString.enqueue("Angeles");
        colaString.enqueue("Cahuana");

        System.out.println("Elementos de la cola:");
        System.out.println(colaString);

        //colaString.enqueue("Pari");

        System.out.println("");

        Queue<Integer> colaEnteros = new QueueArray<>(4);

        colaEnteros.enqueue(10);
        colaEnteros.enqueue(20);
        colaEnteros.enqueue(30);
        colaEnteros.enqueue(40);

        System.out.println("Cola original:");
        System.out.println(colaEnteros);

        try {
            Integer eliminado = colaEnteros.dequeue();
            System.out.println("Elemento eliminado: " + eliminado);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Cola después de eliminar:");
        System.out.println(colaEnteros);

        try {
            System.out.println("Primer elemento -> front: " + colaEnteros.front());
            System.out.println("Último elemento -> back: " + colaEnteros.back());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("");

        Queue<Character> colaLetras = new QueueArray<>(4);
        colaLetras.enqueue('X');
        colaLetras.enqueue('Y');
        colaLetras.enqueue('Z');

        System.out.println("Cola de caracteres:");
        System.out.println(colaLetras);

        try {
            System.out.println("Primer elemento -> front: " + colaLetras.front());
            System.out.println("Último elemento -> back: " + colaLetras.back());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
