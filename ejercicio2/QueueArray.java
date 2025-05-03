package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] data;
    private int first;
    private int last;
    private int cantidad;

    public QueueArray(int tam) {
        data = (E[]) new Object[tam];
        first = 0;
        last = 0;
        cantidad = 0;
    }

    // Inserta un elemento al final de la cola
    @Override
    public void enqueue(E x) {
        if(cantidad == data.length){
            throw new IllegalStateException("La cola esta llena. No se puede insertar.");
        }
        data[last] = x;
        last = (last + 1) % data.length;
        cantidad++;
    }
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        return null;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        return null;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return cantidad == 0;
    }

    @Override
    public String toString() {
        return "";
    }
}