package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    
    private static final int COSTO_POR_KM = 1000;

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
        return distancia * COSTO_POR_KM;
    }

    protected double calcularPorcentajeDescuento(Cliente cliente) {
        return 0.0;
    }

    protected int calcularDistanciaVuelo(Ruta ruta) {
        int duracion = ruta.getDuracion();
        // Asumimos que la velocidad promedio es de 900 km/h
        return duracion * 900/60;
    }
        
}
