package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] data;
    private int inicio;
    private int fin;
    private int cantidad;

    public QueueArray(int tam) {
        data = (E[]) new Object[tam];
        inicio = 0;
        fin = 0;
        cantidad = 0;
    }

    @Override
    public void enqueue(E x) {

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