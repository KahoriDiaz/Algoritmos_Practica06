package ejercicio2;

public class Test {
    public static void main(String[] args) {
        QueueArray<String> cola = new QueueArray<>(5);

        cola.enqueue("Rosario");
        cola.enqueue("de");
        cola.enqueue("los");
        cola.enqueue("Angeles");
        cola.enqueue("Cahuana");

        System.out.println("Elementos de la cola:");
        System.out.println(cola);

        cola.enqueue("Pari");
    }
}
