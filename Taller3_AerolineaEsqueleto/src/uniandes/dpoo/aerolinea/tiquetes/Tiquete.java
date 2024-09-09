package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.consola.Cliente;

public class Tiquete {
    
    private String codigo;
    private int tarifa;
    private boolean comprado;
    private Vuelo vuelo;
    private Cliente cliente;

    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.comprado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean esUsado() {
        return comprado;
    }

    public void marcarComoUsado() {
        this.comprado = true;
    }

}
