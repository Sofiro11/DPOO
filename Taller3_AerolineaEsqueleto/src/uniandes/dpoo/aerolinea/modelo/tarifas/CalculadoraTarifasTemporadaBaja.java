package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas  {
    private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQ = 0.02;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;

    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) (costoBase * (1 - descuento));
        int valorImpuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + valorImpuestos;
    }

    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        Ruta ruta = vuelo.getRuta();
        int distancia = calcularDistanciaVuelo(ruta);
        if (cliente.getTipoCliente().equals("Corporativo")) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else {
            return distancia * COSTO_POR_KM_NATURAL;
        }
    }

    protected double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente.getTipoCliente().equals(ClienteCorporativo.CORPORATIVO)) {
            ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
            switch (clienteCorporativo.getTamanoEmpresa()) {
                case ClienteCorporativo.GRANDE:
                    return DESCUENTO_GRANDES;
                case ClienteCorporativo.MEDIANA:
                    return DESCUENTO_MEDIANAS; 
                case ClienteCorporativo.PEQUENA:
                    return DESCUENTO_PEQ;
                default:
                    return 0.0;
            }
        } else {
            return 0.0;
        }
    }
    protected int calcularDistanciaVuelo(Ruta ruta) {
        int duracion = ruta.getDuracion();
        // Asumimos que la velocidad promedio es de 900 km/h
        return duracion * 900/60;
    }
}
