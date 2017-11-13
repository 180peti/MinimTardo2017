import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {

    String nombreUsuario;
    HashMap<String,Producto> productos;

    public Pedido(String nombre){
        productos=new HashMap<String,Producto>();
        nombreUsuario=nombre;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /*public Pedido(String[] productos, int[] cantidad){
        this.productos=new HashMap<String,Producto>();
        if (productos.length==cantidad.length)
        for (int i=0;i<productos.length;i++)
        {
            this.productos.put(productos[i],cantidad[i]);
        }

    }*/

    public boolean añadirAlPedido(Producto producto){
        boolean hecho=false;
        if (!productos.containsKey(producto.getNombre())) {
            productos.put(producto.getNombre(),producto);
            hecho=true;
        }
        return hecho;
    }

}
