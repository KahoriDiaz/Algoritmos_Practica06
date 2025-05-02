package actividad3;

import actividad1.ExceptionIsEmpty;

public interface PriorityQueue<E, N> {
    void enqueue(E x, N pr); // Inserta un elemento según su prioridad
    E dequeue() throws ExceptionIsEmpty; // Elimina y retorna el elemento con mayor prioridad
    E front() throws ExceptionIsEmpty; // Solo retorna el elemento con mayor prioridad
    E back() throws ExceptionIsEmpty; // Solo retorna el elemento con menor prioridad
    boolean isEmpty(); // Retorna true si la cola está vacía, false en caso contrario
}
