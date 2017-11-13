import edu.upc.minimtardo.ProductManagerImpl;
import edu.upc.minimtardo.Producto;
import edu.upc.minimtardo.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductManagerImplTest {
    ProductManagerImpl test;
    String[] pedir;
    int[] cuanto;

    @Before
    public void setUp() throws Exception {
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

        pedir=new String[2];
        pedir[0]="Leche";
        pedir[1]="Chorizo";

        cuanto=new int[2];
        cuanto[0]=2;
        cuanto[1]=3;
    }

    @After
    public void tearDown() throws Exception {
        test.getInstance().borrar();
    }

    @Test
    public void realizarPedido(){
        assertTrue(test.realizarPedido("Pepe",pedir,cuanto));
        assertFalse(test.realizarPedido("Juan",pedir,cuanto));
        assertEquals(1,test.getPedidostotales().size());
        assertEquals(1,test.getPedidostotales().get(0).getProductos().size());
    }

    @Test
    public void servirPedido(){
        test.realizarPedido("Pepe",pedir,cuanto);
        assertNotNull(test.servirPedido());
        assertNull(test.servirPedido());
    }

}