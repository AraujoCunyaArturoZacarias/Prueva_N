/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frmlistasenlazadas;

/**
 *
 * @author carlospalominovidal
 */
public class ListaEnlazada {
    Nodo nodoInicial; // Primer nodo de la lista
    int numElementos; // Número de elementos en la lista

    // Constructor para crear una lista enlazada vacía
    public ListaEnlazada() {
        nodoInicial = null; // Inicialmente, no hay nodos
        numElementos = 0;  // Inicialmente, el contador es 0
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void agregarNodo(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);

        // Si la lista está vacía, el nuevo nodo se convierte en el nodo inicial
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            // Si la lista no está vacía, recorremos la lista hasta llegar al último nodo
            Nodo nodoActual = nodoInicial;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }

            // Enlazamos el último nodo con el nuevo nodo
            nodoActual.setSiguiente(nuevoNodo);
        }

        numElementos++; // Incrementamos el contador de elementos
    }

    // Método para imprimir los elementos de la lista
    public void imprimir() {
        Nodo nodoActual = nodoInicial;

        System.out.println("Elementos de la lista enlazada:");

        while (nodoActual != null) {
            System.out.println("Código: " + nodoActual.getValor().getCodigo());
            System.out.println("Descripción: " + nodoActual.getValor().getDescripcion());
            System.out.println("Categoría: " + nodoActual.getValor().getCategoria());
            System.out.println();

            nodoActual = nodoActual.getSiguiente();
        }
    }
    
    public Producto Buscar(int id){
        Nodo puntero = nodoInicial;
        
        while(puntero != null){
            if(puntero.getValor().getCodigo()== id){
                return puntero.getValor();
            }
            puntero = puntero.getSiguiente();
        }
        return null;
    }
    
    public boolean remover(int id){
        
        if(nodoInicial==null){
            return false;
        }
        
        if(nodoInicial.getValor().getCodigo() == id){
            nodoInicial = nodoInicial.getSiguiente();
            numElementos--;
            return true;
        }
        
        boolean rpta = false;
        Nodo puntero = nodoInicial;
        
        while(puntero.getSiguiente() != null){
            if(puntero.getSiguiente().getValor().getCodigo() == id){
                puntero.setSiguiente(puntero.getSiguiente().getSiguiente());
                numElementos--;
                rpta = true;
            }
            puntero = puntero.getSiguiente();
        }
        return rpta;
    }
    
}
