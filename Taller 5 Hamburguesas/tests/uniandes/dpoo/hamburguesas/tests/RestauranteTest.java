package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

class RestauranteTest {


    private Restaurante restaurante;

    @BeforeEach
    public void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    public void testCargarInformacionRestaurante() throws IOException, HamburguesaException, NumberFormatException {
        File archivoIngredientes = new File("data/ingredientes.txt");
        File archivoMenu = new File("data/menu.txt");
        File archivoCombos = new File("data/combos.txt");

        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

        assertFalse(restaurante.getIngredientes().isEmpty(), "La lista de ingredientes no debería estar vacía.");
        assertFalse(restaurante.getMenuBase().isEmpty(), "La lista de productos del menú no debería estar vacía.");
        assertFalse(restaurante.getMenuCombos().isEmpty(), "La lista de combos no debería estar vacía.");
    }

    @Test
    public void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
        restaurante.iniciarPedido("Juan Pérez", "Calle Falsa 123");
        assertNotNull(restaurante.getPedidoEnCurso(), "Debería haber un pedido en curso después de iniciarlo.");
        assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            restaurante.iniciarPedido("Maria López", "Calle Real 456");
        });
    }

    @Test
    public void testCerrarYGuardarPedido() throws YaHayUnPedidoEnCursoException, IOException, NoHayPedidoEnCursoException {
        restaurante.iniciarPedido("Juan Pérez", "Calle Falsa 123");
        restaurante.cerrarYGuardarPedido();
        assertNull(restaurante.getPedidoEnCurso(), "No debería haber un pedido en curso después de cerrarlo.");
        assertThrows(NoHayPedidoEnCursoException.class, () -> {
            restaurante.cerrarYGuardarPedido();
        });
    }

    @Test
    public void testGetMenuBase() {
        assertNotNull(restaurante.getMenuBase(), "La lista de menú base no debería ser null.");
    }

    @Test
    public void testGetMenuCombos() {
        assertNotNull(restaurante.getMenuCombos(), "La lista de combos no debería ser null.");
    }

    @Test
    public void testGetIngredientes() {
        assertNotNull(restaurante.getIngredientes(), "La lista de ingredientes no debería ser null.");
    }

    @Test
    public void testGetPedidos() {
        assertNotNull(restaurante.getPedidos(), "La lista de pedidos no debería ser null.");
    }

}
