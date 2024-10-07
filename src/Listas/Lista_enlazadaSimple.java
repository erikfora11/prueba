package Listas;

import javax.swing.JOptionPane;

public class Lista_enlazadaSimple {
    private Nodo nodo_cabeza;
    
    public Lista_enlazadaSimple(){
        this.nodo_cabeza =  null;
    }

    public Nodo getNodo_cabeza() {
        return nodo_cabeza;
    }

    public void setNodo_cabeza(Nodo nodo_cabeza) {
        this.nodo_cabeza = nodo_cabeza;
    }

    public Nodo ultimo(){
       Nodo temp = this.nodo_cabeza;
       while (temp!=null){//mientras la lista no este vacia
           if (temp.getSig()==null){//si es el primer nodo
               break;
           } else{
               temp = temp.getSig();//si no seguimos iterando
           }
       }
        return temp;
    }
    
    public  int contar_Nodos(){
        Nodo temp = this.nodo_cabeza;
        int contador = 0;
        while (temp!=null){
            contador++;
            temp = temp.getSig();
        }
        return contador;
    }
    
    
    public void agregar_X_final(Nodo nodo_nuevo){
        Nodo temp = ultimo();
        if (this.nodo_cabeza==null) {//consultar si la lista es vacia
            this.nodo_cabeza = nodo_nuevo;//se crea el primer nodo de la lista
            this.nodo_cabeza.setAnt(null);
        }
        else{
            temp.setSig(nodo_nuevo);//agregamos por el final de la lista
            nodo_nuevo.setAnt(temp);
        }}
    
    public void agregar_X_intermedio(Nodo nodo_nuevo, int id){
        Nodo temp = buscar(id);
        if (temp!=null) {
            if (temp.getSig()==null) {
                this.agregar_X_final(nodo_nuevo);
            }
            else{
                temp.getSig().setAnt(nodo_nuevo);
                nodo_nuevo.setSig(temp.getSig());
                temp.setSig(nodo_nuevo);
                nodo_nuevo.setAnt(temp);
            }
        }else{
          JOptionPane.showMessageDialog(null,"Estudiante no loxalizado en la lista!!");
        }

    }
    
    public Nodo buscar(int id){
        Nodo temp =  this.nodo_cabeza;
        while (temp!=null){
        if (temp.getId()==id){
            break;
        } else{
            temp = temp.getSig();
        }
    }return temp;
    }
    
    public void eliminar (Nodo nodo){
        Nodo anterior =this.nodo_cabeza;
        if (nodo==this.nodo_cabeza){
            this.nodo_cabeza = this.nodo_cabeza.getSig();
        }else{
            while (anterior.getSig()!=nodo) {
                anterior = anterior.getSig();
                
            }
            anterior.setSig(nodo.getSig());
        }
        nodo = null;
    }
    
    public double promGeneral(){
        Nodo temp = this.nodo_cabeza;
        double suma =0;
        while (temp!=null) {
            suma += temp.promedio();
            temp = temp.getSig();
        } return suma/this.contar_Nodos();
    }
    
    public double notaMax(){
        Nodo temp = this.nodo_cabeza;
        double def = temp.promedio();
        while (temp!=null) {
            if (def < temp.getSig().promedio()) {
                def =  temp.getSig().promedio();
            }
        }
        return def;
    }
}
