package Concurrida;

import java.util.Random;

// Clase para representar un avión
public class Avion extends Thread {
    
    private long id;                
    private String prefijoID;       
    private String idFormateado;        

    private int capacidadMaxima;
    private int pasajerosDentro;
    private int vuelos = 0;
        
    private Aeropuerto origen, destino;
    private Aeropuerto copia;
    
    private Log log;
        
    Avion(Aeropuerto Origen, Aeropuerto Destino, String prefijoID, long idAvion, int capacidad, Log log) {
        this.id = idAvion;
        this.prefijoID = prefijoID;
        this.idFormateado = prefijoID + String.format("%04d", idAvion);          
        this.capacidadMaxima = capacidad;
        this.origen = Origen;
        this.destino = Destino;
        this.log = log;
    }

    //@Override
    public void run() {
        boolean primeraVez = true;                              
        while (true) {
            try {
                if(primeraVez){                                 
                    primeraVez = false;                         
                }else{                                          
                    this.setCopia(this.getDestino());           
                    this.setDestino(this.getOrigen());          
                    this.setOrigen(this.getCopia());            
                    this.setCopia(null);                        
                }
                //Aparece en el Hangar
                origen.entrarHangar(this);
                Thread.sleep(2000);
                origen.salirHangar(this);
                
                // Acceder al ÁREA DE ESTACIONAMIENTO Y POSTERIORMENTE A LA PUERTA DE EMBARQUE                           
                origen.AreaEstacionamiento(this, 1);
                
                // Acceder y salir del ÁREA DE RODAJE
                origen.AreaRodaje(this, 1);

                //Solicita pista para el despegue y despega
                origen.solicitarPista(this);

                // Accede a la AEROVÍA correspondiente y aterriza en la pista que le concedan
                origen.accederAerovia(this);
                
                vuelos ++;
                
                // Acceder al ÁREA DE RODAJE, solicita PUERTA DESEMBARUQE y DESEMBARCA LOS PASAJEROS
                destino.AreaRodaje(this, 2);

                //Accede al Area de Estacionamiento
                destino.AreaEstacionamiento(this, 2);

                // Realizar inspección en el taller después de 15 vuelos
                if (vuelos == 15) {
                    destino.pasarPuertaTaller(this);
                    destino.inspeccion(this, 1);
                    vuelos = 0;
                } else {
                    destino.pasarPuertaTaller(this);
                    destino.inspeccion(this, 2);
                }

                // Decidir si ir al HANGAR o continuar con el ciclo de vida
                if (new Random().nextBoolean()) {
                    log.writeLog("El avión " + idFormateado + " va al HANGAR a reposar.");                            //
                    //Thread.sleep((int)(Math.random()*15000+15000));
                    Thread.sleep((new Random().nextInt(3)*10000) + 15000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    ///////GETTERS Y SETTERS/////////
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getPasajerosDentro() {
        return pasajerosDentro;
    }

    public void setPasajerosDentro(int pasajerosDentro) {
        this.pasajerosDentro = pasajerosDentro;
    }

    public int getVuelos() {
        return vuelos;
    }

    public void setVuelos(int vuelos) {
        this.vuelos = vuelos;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto aeropuerto) {
        this.origen = aeropuerto;
    }
    
    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto aeropuerto) {
        this.destino = aeropuerto;
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

    public Aeropuerto getCopia() {
        return copia;
    }

    public void setCopia(Aeropuerto copia) {
        this.copia = copia;
    }
    
    
}