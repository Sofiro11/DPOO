package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.consola.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente {
    
    public static final String NATURAL = "Natural";
    private String nombre;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();

    public ClienteNatural(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificador(){
        return this.nombre;
    }
    public String getTipoCliente(){
        return NATURAL;
    }
    public void agregarTiquete(Tiquete tiquete){
        tiquetes.add(tiquete);
    }
    public int calcularValorTotalTiquetes(){
        int total = 0;
        for (Tiquete tiquete : tiquetes) {
            total += tiquete.getTarifa();
        }
        return total;
    }
    
    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetes) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
            }
        }
    }
    
        
}
