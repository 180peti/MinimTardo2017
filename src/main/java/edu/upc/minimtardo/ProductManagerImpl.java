package edu.upc.minimtardo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager {

    HashMap<String,Producto> productos;
    ArrayList<Pedido> pedidostotales;
    HashMap<String,Usuario> usuarios;
    private static ProductManagerImpl instance;
    final static Logger log= Logger.getLogger(ProductManagerImpl.class.getName());

    public ProductManagerImpl() {
        org.apache.log4j.BasicConfigurator.configure();
        productos=new HashMap<String,Producto>();
        usuarios=new HashMap<String,Usuario>();
        pedidostotales=new ArrayList<Pedido>();
    }

    public static ProductManagerImpl getInstance(){
        if (instance==null){
            instance=new ProductManagerImpl();
        }
        return instance;
    }

    public void borrar(){
        instance=null;
    }

    public ArrayList<Pedido> getPedidostotales() {
        return pedidostotales;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public ArrayList<Pedido> getPedidosUsuario(String nombre){
        return usuarios.get(nombre).getPedidos();
    }

    public void añadirProducto(Producto a){
        log.info("cantidad de productos "+productos.size());
        productos.put(a.getNombre(),a);
        log.info("cantidad de productos "+productos.size());
    }

    public void añadirUsuario(Usuario a){
        usuarios.put(a.getNombre(),a);
    }

    private void ordenarPrecio(){
        //Ordenara por precio ascendente (por no perder tiempo de momento)
    }
    public HashMap listaPrecios() {

        ordenarPrecio();
        return productos;
    }

    public boolean realizarPedido(String nombre,String[] cosas,int[] cantidad) {
        log.info("Pedidos: "+pedidostotales.size());
        boolean hecho=false;
        if(usuarios.containsKey(nombre)){
            pedidostotales.add(usuarios.get(nombre).realizarPedido(productos,cosas,cantidad));
            hecho=true;
        }
        log.info("Pedidos: "+pedidostotales.size());
        return hecho;
    }

    public Pedido servirPedido(){
        Pedido hecho=null;
        log.info("Pedidos: "+pedidostotales.size());
        if (pedidostotales.size()>0)
        {
            hecho=pedidostotales.remove(0);
            String usuario=hecho.getNombreUsuario();
            usuarios.get(usuario).pedidoRealizado(hecho);
        }
        log.info("Pedidos: "+pedidostotales.size());
        return hecho;
    }

    public ArrayList<Pedido> pedidosRealizados(String nombre){
        log.info("Pedidos realizados por el usuario "+usuarios.get(nombre).getNombre()+": "+usuarios.get(nombre).getRealizados().size());
        return usuarios.get(nombre).getRealizados();
    }

    private void ordenarVentas(){
        //Lo mismo que ordenar por precios
    }

    public HashMap listaVentas() {
        ordenarVentas();
        return productos;
    }
}
