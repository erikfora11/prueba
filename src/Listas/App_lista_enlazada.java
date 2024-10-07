
package Listas;

import javax.swing.JOptionPane;

public class App_lista_enlazada {
    
    public static void llenar_lista(Nodo nodo) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese su identificacion"));
        nodo.setId(id);
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        nodo.setNombre(nombre);
        double n1 = Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota 1"));
        nodo.setN1(n1);
        double n2 = Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota 2"));
        nodo.setN2(n2);
    }
    
        public static void visualizar(Nodo nodo){
        System.out.printf("%s\t %10s\t %s\t %s\t %s \n","identificacion","Nombre","corte1","corte2","definitiva");
        while (nodo!=null) {
            System.out.printf("%10d\t %10s\t %.2f\t %.2f\t %.2f \n", nodo.getId(),nodo.getNombre(),nodo.getN1(),nodo.getN2(),nodo.promedio());
            nodo = nodo.getSig();
            
        }

    }
    
    public static void visualizarDesc(Nodo nodo){
        System.out.printf("%s\t %10s\t %s\t %s\t %s \n","identificacion","Nombre","corte1","corte2","definitiva");
        while (nodo!=null) {
            System.out.printf("%10d\t %10s\t %.2f\t %.2f\t %.2f \n", nodo.getId(),nodo.getNombre(),nodo.getN1(),nodo.getN2(),nodo.promedio());
            nodo = nodo.getAnt();
            
        }

    }
    
    public static int menu(){
        System.out.println("-------- MENÚ DE CURSO DE ED --------\n");
        System.out.println("1. Agregar un estudiante");
        System.out.println("2. Agregar estudiante en la parte intermedia de la lista");
        System.out.println("3. Mostrar el listado de estudiantes");
        System.out.println("4. mostrar listado de estudiantes de forma descendente");
        System.out.println("6. Buscar un estudiante");
        System.out.println("5. Eliminar un estudiante");
        System.out.println("6. Mostrar el promedio de notas del curso");
        System.out.println("7. Mostrar el estudiante con mayor promedio de notas");
        System.out.println("0. para salir");
        int op =  Integer.parseInt(JOptionPane.showInputDialog("Elije una opcion"));
        return op;
    }
    
    public static void main(String[] args) {
       Lista_enlazadaSimple lista = new Lista_enlazadaSimple();
       Nodo nuevo, temp;arg;
       int id;
       int op;
        do {
            op = menu();  // Only call the menu once
            switch (op) {
                case 1://leer la lista de estudiantes
                    nuevo = new Nodo();
                    llenar_lista(nuevo);
                    lista.agregar_X_final(nuevo);
                    break;
                    
                case 2://insercion por cualquier parte intermedia de la lista
                    nuevo = new Nodo();
                    llenar_lista(nuevo);
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu id"));
                    lista.agregar_X_intermedio(nuevo,id);
                    break;
                    
                case 3://Visualizr los nodos de la lista
                    visualizar (lista.getNodo_cabeza());
                    break;
                case 4:
                    visualizarDesc(lista.ultimo());
                    break;
                    
                case 5:
                    Nodo aux;
                    id =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));
                    aux = lista.buscar(id);

                    if (aux == null){
                        System.out.println("Estudiante no encontrado en lista");
                    }
                    else{
                        System.out.println("Estudiante " + lista.buscar(id).getNombre());
                        lista.eliminar(aux);

                    }
                    break;
                case 6:
                    id =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));
                    temp = lista.buscar(id);
                    if(temp==null){
                        System.out.println("Estudiante no encontrado en lista");
                    }
                    else{
                     lista.eliminar(temp);
                     JOptionPane.showInputDialog(null,"elemento eliminado con exito");
                     visualizar(lista.getNodo_cabeza());
                    }
                    break;
                case 7:

                    System.out.printf("%s %.2f\n","el promedio general del curso: ",  lista.promGeneral());
                    break;
                case 8:
                   
                    System.out.printf("%s %.2f\n","La nota mayor del curso es: ",lista.notaMax());
                    break; //parcial: estructuras repetitivas, vectores y matrices, arreglos de objetos, listas a conceptual
            }
        } while (op!=0);
    }
    
}
