package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data; // Dato
        N priority; // Prioridad asociada al dato

        //Contructor
        EntryNode(E data, N priority) { 
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first; // Referencia al primer nodo de la cola
    private Node<EntryNode> last;  // Referencia al último nodo de la cola

    //Constructor
    public PriorityQueueLinkSort() { // No hay parametros para inicializar la cola vacía
        this.first = null; // first y last son null para representar una cola vacía
        this.last = null;
    }

    // Inserta un elemento según su prioridad
    @Override
    public void enqueue(E x, N pr) {
        EntryNode entradaNueva = new EntryNode(x, pr);
        Node<EntryNode> nodoNuevo = new Node<>(entradaNueva);

        // 1° Caso: Si la cola está vacía
        if (first == null) {
            first = last = nodoNuevo; // El nuevo nodo es el único, se vuelve first y last
        }

        // 2° Caso: Si se inserta al inicio
        else if (pr.compareTo(first.data.priority) < 0) { // Si el nuevo nodo tiene mayor prioridad que el primero
            nodoNuevo.next = first; // Entonces el nuevo nodo apunta al nodo que era el primero 
            first = nodoNuevo; // El nuevo nodo se convierte en el primero de la cola
        }

        // 3° Caso: Si se inserta al medio o al final
        else {
            Node<EntryNode> nodoCurrent = first; // Creamos una variable que apunta al mismo nodo que first
            Node<EntryNode> nodoPrevio = null;

            while (nodoCurrent != null && pr.compareTo(nodoCurrent.data.priority) >= 0) {
                nodoPrevio = nodoCurrent;
                nodoCurrent = nodoCurrent.next;
            }

            nodoNuevo.next = nodoCurrent;
            nodoPrevio.next = nodoNuevo;

            if (nodoCurrent == null) {
                last = nodoNuevo;
            }
        }
    }

    // Elimina y retorna el elemento con mayor prioridad
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cannot remove from an empty queue");

        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null)
            this.last = null;
        return aux;
    }
    
    // Retorna el dato del elemento con menor prioridad
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("La cola está vacía");
        return last.data.data;
    }

    // Retorna el dato del elemento con mayor prioridad
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("La cola está vacía");
        return first.data.data;
    }

    // Retorna true si la cola está vacía, false en caso contrario
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Cola vacía";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s | %s\n", "Dato", "Prioridad"));
        sb.append("----------------------\n");

        Node<EntryNode> actual = first;

        while (actual != null) {
            sb.append(String.format("%-10s | %s\n", actual.data.data.toString(),
                    actual.data.priority.toString()));
            actual = actual.next;
        }

        return sb.toString();
    }
}
