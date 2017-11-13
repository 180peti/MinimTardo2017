package edu.upc.minimtardo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Path("cafeteria")
public class ProductManagerService {

    ProductManagerImpl test;
    String[] pedir;
    int[] cuanto;
    public ProductManagerService()
    {
        test= ProductManagerImpl.getInstance();

        Producto a=new Producto("Leche",10);
        test.añadirProducto(a);
        Producto b=new Producto("Pan",5);
        test.añadirProducto(b);
        Producto c=new Producto("Huevos",15);
        test.añadirProducto(c);

        Usuario primero=new Usuario("Pepe");
        test.añadirUsuario(primero);
        Usuario segundo=new Usuario("Ruben");
        test.añadirUsuario(segundo);

        /*pedir=new String[2];
        pedir[0]="Leche";
        pedir[1]="Chorizo";

        cuanto=new int[2];
        cuanto[0]=2;
        cuanto[1]=3;*/
    }

    @Path("/productos2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String productos2(){return "hola";}

    @Path("/productos")
    @GET
    @Produces(MediaType.APPLICATION_JSON) //Por que una track si la aceptaba (ejemplo) pero un producto no?
    public String productos(){
        //Solo he hecho pruebas
        return test.getProductos().get("Leche").toString();

    }
    //Pruebas
    @Path("/{usuario}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pedido> pedidosDelUsuario(@PathParam("usuario") String user){
        return test.getPedidosUsuario(user);
    }
    /*
    @Path("/{usuario}/pedir")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerPedido(@PathParam("usuario") String user,String[] cosas,int[] cantidad){
        test.realizarPedido(user,cosas,cantidad);
        return Response.status(201).entity("Pedido realizado").build();
    }
*/
}
