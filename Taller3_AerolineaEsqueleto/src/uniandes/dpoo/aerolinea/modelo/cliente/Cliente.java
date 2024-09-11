package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

    public Cliente() {
    }
    
    public abstract String getTipoCliente();

    public abstract String getIdentificador();

    public abstract void agregarTiquete(Tiquete tiquete);

    public abstract int calcularValorTotalTiquetes();

    public abstract void usarTiquetes(Vuelo vuelo);
    
}
