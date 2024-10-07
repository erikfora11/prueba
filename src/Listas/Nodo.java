/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author HP
 */
public class Nodo {//debe ser una clase autoreferenciada
    
    private int id;
    private String nombre;
    private double n1,n2;
    Nodo ant;//apuntador al anterior nodo de la lista

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    Nodo sig; //apunto al siguiente nodo de la lista
    
    public Nodo(){
        this.id = 0;
        this.nombre = null;
        this.n1 = 0;
        this.n2 = 0;
        this.sig =  null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    public double promedio(){//promedio para calcular nota del estudiante
        return this.n1*0.4+this.n2*0.6;
    }
    
    //temp =  temp.getsig

    @Override
    public String toString() {
        return "Nodo{" + "id=" + id + ", nombre=" + nombre + ", n1=" + n1 + ", n2=" + n2 + ", sig=" + sig + '}';
    }
    
    
}
