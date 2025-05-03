package ejercicio2;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        QueueArray<String> colaString = new QueueArray<>(5);

        colaString.enqueue("Rosario");
        colaString.enqueue("de");
        colaString.enqueue("los");
        colaString.enqueue("Angeles");
        colaString.enqueue("Cahuana");

        System.out.println("Elementos de la cola:");
        System.out.println(colaString);

        //colaString.enqueue("Pari");

        QueueArray<Integer> colaEnteros = new QueueArray<>(4);

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
    }
}
