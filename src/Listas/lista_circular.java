package Listas;

public class lista_circular {
    Nodo cabeza = null;

    public void agregar(Nodo n_nodo){
          if(cabeza==null){
               cabeza = n_nodo;
               n_nodo.sig = n_nodo;
          }else {
             Nodo actual = cabeza;
             while (actual.sig !=cabeza) {
                 actual = actual.sig;
             }
             actual = n_nodo;
             n_nodo.sig = cabeza;

          }
    }



    public void display() {
        if (cabeza == null) {
            System.out.println("La lista esta vacia");
            return;
        }
        Nodo actual = cabeza;
        while (true) {
            System.out.print(actual.getNombre()+ " -> ");
            actual = actual.sig;
            if (actual == cabeza) {
                break;
            }
        }
        System.out.println();
    }
}
