package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ComboTest {

	private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new ProductoMenu("Hamburguesa Sencilla", 8000);
        producto2 = new ProductoMenu("Papas Fritas", 3000);

        ArrayList<ProductoMenu> itemsCombo = new ArrayList<>();
        itemsCombo.add(producto1);
        itemsCombo.add(producto2);

        combo = new Combo("Combo Especial", 0.9, itemsCombo);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo Especial", combo.getNombre(), "El nombre del combo no es el esperado.");
    }

    @Test
    public void testGetPrecio() {
        int precioEsperado = (int) ((8000 + 3000) * 0.9);
        assertEquals(precioEsperado, combo.getPrecio(), "El precio del combo no es el esperado.");
    }

    @Test
    public void testGenerarTextoFactura() {
        String textoEsperado = 
            "Combo Combo Especial\n" +
            " Descuento: 0.9\n" +
            "            " + combo.getPrecio() + "\n";

        assertEquals(textoEsperado, combo.generarTextoFactura(), "El texto de la factura no coincide con el esperado.");
    }

}
