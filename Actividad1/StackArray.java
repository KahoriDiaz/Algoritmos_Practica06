package actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    public void push(E x) {
        if (tope < array.length - 1) { // -> si hay espacio en la pila
            array[++tope] = x;  // -> incrementa tope y coloca el nuevo elemento
        } else {
            System.out.println("Pila llena");
        }
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {  // -> si la pila está vacía
            throw new ExceptionIsEmpty("Array vacío");
        }
        return array[tope--];  // -> devuelve y elimina el elemento del tope
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {  // -> si la pila está vacía
            throw new ExceptionIsEmpty("Array vacío");
        }
        return array[tope];    // -> devuelve el elemento del tope sin eliminarlo
    }

    public boolean isEmpty() {
        return tope == -1;  // -> retorna true si no hay elementos
    }

    public void destroyStack() {
        tope = -1;  // -> reinicia la pila dejándola vacía (tope=-1 -> vacía)
    }

    public boolean isFull() {
        return tope == array.length - 1; // -> retorna true si ya no hay espacio para más elementos
    }

    public String toString() {
        if (isEmpty()) {
            return "Pila vacía";              // -> si no hay elementos
        }

        String resultado = "Pila: [";

        for (int i = 0; i <= tope; i++) {
            resultado += array[i];            // -> agrega cada elemento
            if (i < tope) {
                resultado += ", ";            // -> separador entre elementos
            }
        }

        resultado += "]";  // -> cierra la cadena con corchete
        return resultado;  // -> retorna la cadena final
    }
    

    
}
