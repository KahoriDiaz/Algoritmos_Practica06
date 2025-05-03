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
    
    // Elimina y retorna el elemento al frente de la cola
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía. No se puede eliminar.");
        }

        E elemento = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        cantidad--;
        return elemento;
    }
    
    // Retorna el elemento al frente sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        return null;
    }
    
    // Retorna el último elemento agregado (final de la cola)
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
        if (isEmpty()){
            return "La cola está vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cola: [");
    
        for (int i = 0; i < cantidad; i++) {
            int index = (first + i) % data.length;
            sb.append(data[index]);
            if (i < cantidad - 1) {
                sb.append(", ");
            }
        }
    
        sb.append("]");
        return sb.toString();
    }
}