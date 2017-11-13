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
}
