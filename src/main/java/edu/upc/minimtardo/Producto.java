package edu.upc.minimtardo;

public class Producto {

    String nombre;
    int precio,cantidad; //No me convence poner la cantidad aqui

    public Producto(String nombre,int precio)
    {
        this.nombre=nombre;
        this.precio=precio;
    }
    public String getNombre(){
        return nombre;
    }
    public void cantidadAPedir(int cantidad){
        this.cantidad=cantidad;
    }

    @Override//Prueba para el REST
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
    }
}
