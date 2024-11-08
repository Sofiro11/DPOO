package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ProductoMenuTest {

	private ProductoMenu producto;

    @BeforeEach
    public void setUp() {
        producto = new ProductoMenu("Hamburguesa Sencilla", 8000); 
    }
    
    @Test
    public void testGetNombre() {
        assertEquals("Hamburguesa Sencilla", producto.getNombre(), "El nombre del producto no es el esperado.");
    }

    @Test
    public void testGetPrecio() {
        assertEquals(8000, producto.getPrecio(), "El precio base del producto no es el esperado.");
    }
    
    @Test
    public void testGenerarTextoFactura() {
        String textoEsperado = "Hamburguesa Sencilla\n            8000\n";
        assertEquals(textoEsperado, producto.generarTextoFactura(), "El texto de la factura no es el esperado.");
    }

}
