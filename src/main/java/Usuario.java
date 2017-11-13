import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {

    String nombre;
    ArrayList<Pedido> pedidos,realizados;

    public Usuario(String nombre){
        this.nombre=nombre;
        pedidos=new ArrayList<Pedido>();
        realizados=new ArrayList<Pedido>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<Pedido> getRealizados() {
        return realizados;
    }

    public Pedido realizarPedido(HashMap<String,Producto> productos, String[] nombre, int[] cantidad)
    {
        Pedido todo=new Pedido(this.nombre);
        for(int i=0;i<nombre.length;i++) {
            if(productos.containsKey(nombre[i])) {
                Producto quiero = productos.get(nombre[i]);
                quiero.cantidadAPedir(cantidad[i]);
                todo.añadirAlPedido(quiero);
            }
        }
        pedidos.add(todo);
        return todo;
    }
    public void pedidoRealizado(Pedido a){
        realizados.add(a);
    }


}
