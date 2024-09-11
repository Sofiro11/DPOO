package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {

    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private Tiquete tiquete;
    private ArrayList<Tiquete> tiquetes;

    public Vuelo(Ruta ruta, String fecha, Avion avion){
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
    }
    public Ruta getRuta(){
        return this.ruta;
    }
    public String getFecha(){
        return this.fecha;
    }
    public Avion getAvion(){
        return this.avion;
    }
    public Tiquete getTiquete(){
        return this.tiquete;
    }
    public void venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int tarifa = calculadora.calcularTarifa(this, cliente);
            Tiquete codigo = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
            Tiquete tiquete = new Tiquete(codigo, this, cliente, tarifa);
            tiquetes.add(tiquete);
            cliente.agregarTiquete(tiquete);
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vuelo vuelo = (Vuelo) obj;

        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
    }
    
        
    
}
