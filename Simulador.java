
/**
* Simula una ventanilla usando un TDA Cola
*
* @author Miguel Murguia
* @version 1.2
*/
import java.util.*;
import java.util.concurrent.*;

public class Simulador
{
// Cola: se implementa mediante una lista ligada
private LinkedList<Integer> cola_1 = new LinkedList<Integer>();
private final int CICLOS=15;
// milisengundos para observar en pantalla
private final int TIEMPO_PANTALLA=20;
// Máximo número de trámites de cada nodo
private final double MAX_TRAMITES=5;
public void correSimulador() {
cola_1.clear();
simula();
}
// Ciclos del simulador
private void simula() {
int actual, actual_t, tiempo, ciclo=0, hay_nuevo;
// forma al primer cliente
actual_t = asigna_tramites();
actual=actual_t;
do {
// Atiende al siguiente cliente en la fila
if(actual_t==0) {
if(cola_1.size()>0) {
actual=cola_1.removeFirst();
actual_t=actual-1;
}
}
// sige atendiendo al mismo cliente
else {
actual_t--;
}
// decide si se forma o no otro cliente
asigna_cliente();
// Imprime la cola
System.out.print(ciclo +") Actual:" + actual);
System.out.println(". Cola: " + cola_1);
ciclo++;
esperar(TIEMPO_PANTALLA);
} while (ciclo < CICLOS);
}

// Genera un número al azar de trámites
private int asigna_tramites() {
return ((int) (Math.random() * (double)(MAX_TRAMITES-1)))+1 ;
}
// Decide si se forma o no otro cliente
// y cuántos trámites realizará
private void asigna_cliente() {
int hay_nuevo = ((int) (Math.random() * 2.0));
if (hay_nuevo==1)
cola_1.addLast(asigna_tramites());
}
// Se espera n milisegundos
private void esperar (int n) {
long t0, t1;
t0 = System.currentTimeMillis();
do{
t1 = System.currentTimeMillis();
}
while (t1 - t0 < n);
}

}
