package edu.upc.minimtardo;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductManager {

    HashMap listaPrecios();

    boolean realizarPedido(String nombre,String[] productos,int[] cantidad);

    Pedido servirPedido();

    ArrayList<Pedido> pedidosRealizados(String Nombre);

    HashMap listaVentas();
}
