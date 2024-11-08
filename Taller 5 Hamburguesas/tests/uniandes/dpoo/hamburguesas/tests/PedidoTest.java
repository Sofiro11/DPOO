package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class PedidoTest {

	private Pedido pedido;
    private ProductoMenu producto1;
    private ProductoAjustado productoAjustado;
    private Ingrediente ingredienteExtra;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido("Juan Pérez", "Calle Falsa 123");
        producto1 = new ProductoMenu("Hamburguesa Sencilla", 8000);
        productoAjustado = new ProductoAjustado(producto1);
        ingredienteExtra = new Ingrediente("Queso", 500);
        productoAjustado.agregarIngrediente(ingredienteExtra);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(productoAjustado);
    }

    @Test
    public void testGetIdPedido() {
        assertEquals(0, pedido.getIdPedido(), "El ID del pedido no es el esperado.");
    }

    @Test
    public void testGetNombreCliente() {
        assertEquals("Juan Pérez", pedido.getNombreCliente(), "El nombre del cliente no es el esperado.");
    }

    @Test
    public void testGetPrecioTotalPedido() {
        int precioEsperado = (int)((8000 + (8000 + 500)) * 1.19);
        assertEquals(precioEsperado, pedido.getPrecioTotalPedido(), "El precio total del pedido no es el esperado.");
    }

    @Test
    public void testGenerarTextoFactura() {
        String facturaEsperada = 
            "Cliente: Juan Pérez\n" +
            "Dirección: Calle Falsa 123\n" +
            "----------------\n" +
            "Hamburguesa Sencilla\n            8000\n" +
            "Hamburguesa Sencilla\n" +
            "    +Queso                500\n" +
            "            8500\n" +
            "----------------\n" +
            "Precio Neto:  16500\n" +
            "IVA:          3135\n" +
            "Precio Total: 19635\n";
        
        assertEquals(facturaEsperada, pedido.generarTextoFactura(), "El texto de la factura no coincide con el esperado.");
    }

    @Test
    public void testGuardarFactura() throws FileNotFoundException {
        File archivo = new File("factura_test.txt");
        pedido.guardarFactura(archivo);

        // Lee el archivo y verifica su contenido
        Scanner scanner = new Scanner(archivo);
        StringBuilder contenido = new StringBuilder();
        while (scanner.hasNextLine()) {
            contenido.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        assertEquals(pedido.generarTextoFactura(), contenido.toString(), "El contenido del archivo de factura no es el esperado.");

        // Elimina el archivo de prueba después de la verificación
        archivo.delete();
    }

}
