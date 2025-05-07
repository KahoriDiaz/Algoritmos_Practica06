package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] data; // Arreglo que almacena los elementos de la cola
    private int first; // Índice del primer elemento (inicio de la cola)
    private int last; // Índice del último elemento insertado (fin de la cola)
    private int cantidad; // Cantidad actual de elementos en la cola

    // Constructor: inicializa la cola vacía con el tamaño dado    
    public QueueArray(int tam) {
        data = (E[]) new Object[tam]; // Creamos el arreglo genérico
        first = 0; // Primer elemento en la posición 0
        last = 0; // Última posición para insertar
        cantidad = 0; // La cola empieza vacía
    }

    // Inserta un elemento al final de la cola
    @Override
    public void enqueue(E x) {
        if(x == null){
            // Evita insertar valores nulos
            throw new IllegalArgumentException("No se puede insertar un valor nulo.");
        }

        if(cantidad == data.length){
            // Si la cola está llena, no permite insertar
            throw new IllegalStateException("La cola esta llena. No se puede insertar.");
        }
        
        // Insertamos el elemento en la posición 'last'
        data[last] = x;

        /* Avanzamos 'last' de forma circular usando módulo,
        para que no se salga del arreglo al llegar al final */ 
        last = (last + 1) % data.length;

        // Aumentamos la cantidad de elementos
        cantidad++;
    }
    
    // Elimina y retorna el elemento al frente de la cola
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        // Si está vacía, no se puede eliminar
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía. No se puede eliminar.");
        }

        E elemento = data[first]; // Guardamos el valor que será eliminado

        if (elemento == null){
            // Verificación extra por consistencia de datos
            throw new IllegalStateException("Elemento inconsistente en la cola.");
        }

        data[first] = null; // Borramos el valor del arreglo
        
        /* Avanzamos 'first' de forma circular usando módulo,
        para que vuelva al inicio si llega al final del arreglo */
        first = (first + 1) % data.length;
        
        // Reducimos la cantidad        
        cantidad--;

        return elemento; // Devolvemos el valor eliminado
    }
    
    // Retorna el elemento al frente sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            // Si la cola está vacía, no hay elemento al frente
            throw new ExceptionIsEmpty("La cola está vacía. No hay elementos.");
        }
        return data[first];
    }
    
    // Retorna el último elemento agregado (final de la cola)
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            // Si la cola está vacía, no hay elemento al final
            throw new ExceptionIsEmpty("La cola está vacía. No hay elementos.");
        }

        // Calculamos la posición del último insertado de forma circular
        int posicionUltima = (last - 1 + data.length) % data.length;
        return data[posicionUltima];
    }

    // Verifica si la cola está vacía    
    @Override
    public boolean isEmpty() {
        return cantidad == 0;
    }

    // Retorna el contenido de la cola como cadena    
    @Override
    public String toString() {
        if (isEmpty()){
            return "La cola está vacía"; // Mensaje si no hay elementos
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cola: [");
    
        // Recorremos los elementos desde 'first' según la cantidad actual
        for (int i = 0; i < cantidad; i++) {
            int index = (first + i) % data.length; // Ciclo circular
            sb.append(data[index]);
            if (i < cantidad - 1) {
                sb.append(", "); // Separar cada elemento con comas
            }
        }
    
        sb.append("]");
        return sb.toString(); // Devuelve el estado completo de la cola
    }
}