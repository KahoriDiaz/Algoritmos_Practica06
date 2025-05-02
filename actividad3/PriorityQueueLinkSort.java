package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() { // No hay parametros para inicializar la cola vacía
        this.first = null; // first y last son null para representar una cola vacía
        this.last = null;
    }

    @Override
    public void enqueue(E x, N pr) {
        EntryNode entradaNueva = new EntryNode(x, pr);
        Node<EntryNode> nodoNuevo = new Node<>(entradaNueva);

        // 1° Caso: Si la cola está vacía
        if (first == null) {
            first = last = nodoNuevo;
        }

        // 2° Caso: Si se inserta al inicio
        else if (pr.compareTo(first.data.priority) < 0) {
            nodoNuevo.next = first;
            first = nodoNuevo;
        }

        // 3° Caso: Si se inserta al medio o al final
        else {
            Node<EntryNode> nodoCurrent = first;
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

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("La cola está vacía");
        return last.data.data;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("La cola está vacía");
        return first.data.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        return "";
    }
}
