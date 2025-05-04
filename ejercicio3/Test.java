package ejercicio3;

import actividad3.PriorityQueue;
import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            //creamoa una cola de prioridad con 4 niveles (0 = mayor prioridad, 3 = menor)
            PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinked<>(4);

            //insertamos tareas con diferentes niveles de prioridad
            colaPrioridad.enqueue("Tarea urgente", 0);         //alta prioridad
            colaPrioridad.enqueue("Revision email", 2);        //prioridad media
            colaPrioridad.enqueue("Tomar agua", 3);            //prioridad baja
            colaPrioridad.enqueue("Estudiar examen", 1);       //prioridad alta intermedia
            colaPrioridad.enqueue("Preparar cena", 2);         //misma prioridad que "Revision email"

            //muestra el contenido completo de la cola de prioridad
            System.out.println(colaPrioridad.toString());

            //muestra el primer elemento de mayor prioridad (sin eliminarlo)
            System.out.println("Elemento con mayor prioridad (front): " + colaPrioridad.front());

            //muestra el ultimo elemento de menor prioridad (sin eliminarlo)
            System.out.println("Elemento con menor prioridad (back): " + colaPrioridad.back());

            //buscar un elemento especifico en la cola de una cola de prioridad
            System.out.println(colaPrioridad.buscarElemento("Preparar cena"));
            //buscar un elemento que no esta
            System.out.println(colaPrioridad.buscarElemento("dormir"));
            
            //eliminamos e imprimimos los elementos por orden de prioridad
            System.out.println("Eliminando elementos por prioridad:");
            while (!colaPrioridad.isEmpty()) {
                System.out.println("-> " + colaPrioridad.dequeue());
            }

        } catch (ExceptionIsEmpty e) {
            // captura y muestra error si se intenta eliminar de una cola vacia
            System.err.println("Error: " + e.getMessage());
        }
    }
}
