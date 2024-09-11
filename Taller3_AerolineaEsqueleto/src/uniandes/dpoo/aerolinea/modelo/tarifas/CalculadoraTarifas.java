package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

    public static final double IMPUESTO = 0.28;

    public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);
    protected abstract int calcularDistanciaVuelo(Ruta ruta);
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }

}
