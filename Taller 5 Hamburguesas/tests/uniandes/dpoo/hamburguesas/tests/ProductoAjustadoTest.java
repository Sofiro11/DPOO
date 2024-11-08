package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ProductoAjustadoTest {

	private ProductoMenu productoBase;
    private ProductoAjustado productoAjustado;
    private Ingrediente ingredienteExtra1;
    private Ingrediente ingredienteExtra2;
    private Ingrediente ingredienteEliminado;

    @BeforeEach
    public void setUp() {
        productoBase = new ProductoMenu("Hamburguesa Sencilla", 8000);
        productoAjustado = new ProductoAjustado(productoBase);
        ingredienteExtra1 = new Ingrediente("Queso", 500);
        ingredienteExtra2 = new Ingrediente("Tocineta", 1000);
        ingredienteEliminado = new Ingrediente("Lechuga", 0);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Hamburguesa Sencilla", productoAjustado.getNombre(), "El nombre del producto ajustado no coincide con el nombre del producto base.");
    }

    @Test
    public void testGetPrecioSinAjustes() {
        assertEquals(8000, productoAjustado.getPrecio(), "El precio del producto ajustado sin ingredientes adicionales no coincide con el precio del producto base.");
    }

    @Test
    public void testGetPrecioConAjustes() {
        productoAjustado.agregarIngrediente(ingredienteExtra1);
        productoAjustado.agregarIngrediente(ingredienteExtra2);

        int precioEsperado = 8000 + 500 + 1000;
        assertEquals(precioEsperado, productoAjustado.getPrecio(), "El precio del producto ajustado no es el esperado al agregar ingredientes.");
    }

    @Test
    public void testGenerarTextoFactura() {
        productoAjustado.agregarIngrediente(ingredienteExtra1);
        productoAjustado.eliminarIngrediente(ingredienteEliminado);

        String textoEsperado = 
            "Hamburguesa Sencilla\n" +
            "    +Queso                500\n" +
            "    -Lechuga\n" +
            "            8500\n";

        assertEquals(textoEsperado, productoAjustado.generarTextoFactura(), "El texto de la factura no coincide con el esperado.");
    }
}
