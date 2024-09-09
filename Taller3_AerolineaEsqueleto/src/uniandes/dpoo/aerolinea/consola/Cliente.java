package uniandes.dpoo.aerolinea.consola;

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
