package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;
import actividad3.PriorityQueue;

//clase que implementa de la interfaz PriorityQueue - E es el tipo de dato a almacenar - Integer es el tipo de la prioridad
public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {
    //declaramos un arreglo de colas
    private QueueLink<E>[] colaPrioridad;
    // numero de prioridades (tamaño del arreglo)
    private int numPriorities; 

    //constructor
    @SuppressWarnings("unchecked") //es para evitar un warning al crear el arreglo generico
    public PriorityQueueLinked(int numPriorities) {
        //inicializamos el numero de prioridades
        this.numPriorities = numPriorities;
        //y creamos un arreglo con ese tamaño (numPriorities)
        colaPrioridad = new QueueLink[numPriorities];
        //inicializa cada una de las colas dentro del arreglo queues
        for (int i = 0; i < numPriorities; i++) {
            colaPrioridad[i] = new QueueLink<>();
        }
    }

    //para insertar un elemento x con prioridad pr
    @Override
    public void enqueue(E x, Integer pr) {
        //verifica que la prioridad este dentro de los limites validos 
        if (pr < 0 || pr >= numPriorities) {
            //si no, lanza excepcion
            throw new IllegalArgumentException("Prioridad fuera de rango: " + pr);
        }
        //insertamos el elemento en la cola correspondiente a esa prioridad
        colaPrioridad[pr].enqueue(x);
    }

    // elimina y retorna el primer elemento de mayor prioridad (menor numero)
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        //recorre todas las colas de prioridades desde la mas alta (0) hasta la mas baja
        for (int i = 0; i < numPriorities; i++) {
            //si encuentra una cola que no está vacia
            if (!colaPrioridad[i].isEmpty()) {
                //entonces elimina y retorna el primer elemento de esa cola (la de mayor prioridad disponible)
                return colaPrioridad[i].dequeue();
            }
        }
        //si ninguna cola tiene elementos, lanza la excepcion porque no hay nada para eliminar
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    //retorna el primer elemento de mayor prioridad (sin eliminar)
    @Override
    public E front() throws ExceptionIsEmpty {
        //recorre las colas desde la prioridad mas alta (0) hasta la mas baja
        for (int i = 0; i < numPriorities; i++) {
            //verifica si la cola actual tiene elementos
            if (!colaPrioridad[i].isEmpty()) {
                //si la encuentra con elementos devuelve el primero (sin quitarlo)
                return colaPrioridad[i].front();
            }
        }
        //si todas estan vacias lanza una excepcion indicando que no hay elementos
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    //retorna el ultimo elemento de menor prioridad (sin eliminar)
    @Override
    public E back() throws ExceptionIsEmpty {
        //recorre las colas desde la ultima prioridad (numero mas alto) hacia la mas alta (numero mas bajo) 
        //comenzando desde numPriorities - 1 (la ultima cola) y decrementando
        for (int i = numPriorities - 1; i >= 0; i--) {
            //verifica si la cola actual (prioridad mas baja en ese momento) no esta vacia
            if (!colaPrioridad[i].isEmpty()) {
                //si la cola tiene elementos, devuelve el ultimo elemento de esa cola sin eliminarlo
                return colaPrioridad[i].back();
            }
        }
        //si todas estan vacias lanza una excepcion indicando que no hay elementos
        throw new ExceptionIsEmpty("Todas las colas están vacías");
    }

    //verifica si todas las colas dentro de la cola de prioridad están vacias o no
    @Override
    public boolean isEmpty() {
        //recorre todas las colas de prioridades - desde la prioridad mas baja hasta la mas alta
        for (int i = 0; i < numPriorities; i++) {
            //verifica si la cola en la posición i no esta vacia. 
            //si al menos una cola tiene elementos la funcion devolverá false.
            if (!colaPrioridad[i].isEmpty()) {
                return false;
            }
        }
        //si ninguna cola tiene con elementos (vacias) se devuelve true
        return true;
    }

    //representación en cadena (texto) de la cola de prioridad
    @Override
    public String toString() { //sobrescrito de la clase Object
        //objeto StringBuilder iniciado con el texto:
        StringBuilder sb = new StringBuilder("Contenido de la Cola de Prioridad:\n");
        //recorre cada una de las prioridades en la cola, desde la prioridad 0 hasta numPriorities - 1
        for (int i = 0; i < numPriorities; i++) {
            //por cada prioridad se agrega una cadena - ejemplo: "Prioridad 0: 
            sb.append("Prioridad ").append(i).append(": ");
            //Se llama al metodo toString() de la cola especifica en la posicion i
            sb.append(colaPrioridad[i].toString()).append("\n");
        }
        //se devuelve la cadena construida
        return sb.toString();
    }

    //retorna un mensaje indicando la prioridad y la posicion en la cola
    public String buscarElemento(E elemento) {
        //recorre todas las colas de prioridad de la mas alta a la mas baja
        for (int i = 0; i < numPriorities; i++) {
            //colaPrioridad[i] - la cola correspondiente a la prioridad i
            //indexOf(elemento) - la posición del elemento dentro de la cola en la posicion i
            int pos = colaPrioridad[i].indexOf(elemento); // buscamos la posicion del elemento en esa cola
            //si el elemento si se encontro
            if (pos != -1) {
                //retornamos el mensaje de que se encontro
                // \" se usa para incluir comillas dobles dentro de una cadena de texto
                return "\"" + elemento + "\" esta en la prioridad " + i + " y en la posicion " + pos + " de esa cola.";
            }
        }
        //sino retornamos el mensaje de que NO se encontro
        return "\"" + elemento + "\" no se encontro en ninguna cola de prioridad.";
    }

}

