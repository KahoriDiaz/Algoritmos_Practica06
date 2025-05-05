package ejercicio4;

import actividad1.ExceptionIsEmpty; // Importamos la excepción para manejar una pila vacía
import ejercicio1.StackLink; // Importamos la implementación propia de pila basada en nodos

public class Aplication {

    // Método estático que verifica si una cadena de corchetes está balanceada
    public static boolean symbolBalancing(String s) {
        // Creamos una pila para almacenar los caracteres de apertura: '(','[','{'
        StackLink<Character> pila = new StackLink<>();

        // Recorremos cada carácter de la cadena
        for (int i = 0; i < s.length(); i++) {
            char caracter = s.charAt(i); // Obtenemos y guardamos el carácter en la posición i

            // Si el carácter es un corchete de apertura, lo apilamos
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } 
            // Si es un corchete de cierre, debemos comprobar si hay uno abierto correspondiente
            else if (caracter == ')' || caracter == ']' || caracter == '}') {
                // Si la pila está vacía, y aparece un símbolo de cierre será false
                if (pila.isEmpty()) return false;

                try {
                    // Extraemos el último carácter apilado (el más reciente de apertura)
                    char top = pila.pop();

                    // Verificamos que coincida el tipo de corchete
                    if ((caracter == ')' && top != '(') ||
                        (caracter == ']' && top != '[') ||
                        (caracter == '}' && top != '{')) {
                        return false; // Si no es el par correcto, la secuencia es inválida
                    }

                } catch (ExceptionIsEmpty e) {
                    /* Ya validamos con isEmpty() antes, pero refueza la seguridad en caso hagamos
                    pop() pero la pila estaba vacía, entonces sale false */ 
                    return false;
                }
            }
        }

        /* Al final, si la pila está vacía, todo estuvo correctamente anidado
        Si no está vacía, quedó un corchete de apertura sin su cierre, entonce sería false */
        return pila.isEmpty();        
    }
}
