
package Concurrida;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import javax.swing.JTextField;


// Clase para representar un autobús

public class Autobus extends Thread {
    private long id;
    private String prefijoID;
    private String idFormateado;        //
    
    private Aeropuerto aeropuerto;
    private int pasajerosSubidos = 0;
    
    Autobus(String prefijoID, Long idAutobus, Aeropuerto aeropuerto) {
        this.prefijoID = prefijoID;
        this.id = idAutobus;
        this.idFormateado = this.getPrefijoID() + String.format("%04d", this.getId());
        this.aeropuerto = aeropuerto;
    }

    //@Override
    public void run() {
        while (true) {                                 
            // Llegada a la parada del centro de la ciudad
            aeropuerto.paradaCiudad(this);
            // Viaje al aeropuerto
            aeropuerto.viajarAeropuerto(this);
            // Llegada a la parada del aeropuerto
            aeropuerto.paradaAeropuerto(this);
            // Viaje a la ciudad
            aeropuerto.viajarCiudad(this);
        }
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrefijoID() {
        return prefijoID;
    }

    public void setPrefijoID(String prefijoID) {
        this.prefijoID = prefijoID;
    } 

    public String getIdFormateado() {
        return idFormateado;
    }

    public void setIdFormateado(String idFormateado) {
        this.idFormateado = idFormateado;
    }

    public int getPasajerosSubidos() {
        return pasajerosSubidos;
    }

    public void setPasajerosSubidos(int pasajerosSubidos) {
        this.pasajerosSubidos = pasajerosSubidos;
    }
    
}
