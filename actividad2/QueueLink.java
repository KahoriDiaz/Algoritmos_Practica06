package actividad2;
import actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;  // -> inicio de la cola
    private Node<E> last;   // -> final de la cola

    public QueueLink() {
        first = last = null;  // -> cola vacía
    }

    public boolean isEmpty() {
        return first == null;  // -> true si no hay elementos
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);  // -> nuevo nodo con el dato
        if (this.isEmpty()) {
            first = last = aux;  // -> primer nodo si la cola está vacía
        } else {
            this.last.setNext(aux);  // -> enlaza nuevo nodo al final
            this.last = aux;         // -> actualiza el último nodo
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");  // -> no se puede eliminar
        }
        E elemento = first.getData();  // -> almacena el dato del primer nodo
        first = first.getNext();       // -> avanza el inicio de la cola

        if (first == null) {
            last = null;  // -> si ya no hay nodos, last también debe ser null
        }

        return elemento;  // -> retorna el dato eliminado
    }

    public E front() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return first.getData();  // -> retorna el valor al frente
    }

    public E back() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return last.getData();  // -> retorna el valor del final
    }

    public String toString() {
        if (isEmpty()) {
            return "Cola vacía";               // -> si no hay elementos
        }
    
        String resultado = "Cola: [";          // -> inicio del texto
    
        Node<E> actual = first;                // -> comenzamos desde el primer nodo
    
        while (actual != null) {
            resultado += actual.getData();     // -> agrega el dato del nodo actual
            if (actual.getNext() != null) {
                resultado += ", ";             // -> separador si hay más elementos
            }
            actual = actual.getNext();         // -> avanza al siguiente nodo
        }
    
        resultado += "]";                      // -> cierra la cadena con corchete
        return resultado;                      // -> retorna la cadena final
    }
    
}
