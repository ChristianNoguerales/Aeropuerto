package Concurrida;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

// Clase para representar un aeropuerto
public class Aeropuerto {

    private boolean pista1Cerrada, pista2Cerrada, pista3Cerrada, pista4Cerrada = false;
    boolean pistaCerrada;

    private final JTextField fieldParadaAeropuerto, fieldParadaCiudad, TFPersonasDentro, fieldHangar, fieldTaller, tFAreaEstacionamiento, fieldGate1, fieldGate2, fieldGate3,
            fieldGate4, fieldGate5, fieldGate6, fieldAreaRodaje, fieldPista1, fieldPista2, fieldPista3, fieldPista4, fieldAerovia;

    //Variables para Autobus
    private final Lock paradaAeropuerto;
    private final Lock paradaCiudad;

    //Variables para Avion
    private int personasDentro;

    private String nombre;

    private Log log;

    private boolean parar = false;

    //Hangar
    private List<String> hangar = new ArrayList<>();

    private LinkedList<String> areaEstacionamiento = new LinkedList<>();
    private Lock lockEstacionamiento = new ReentrantLock();
    private Condition algunoOcupado = lockEstacionamiento.newCondition();

    private Lock puertaEmbarque = new ReentrantLock();
    private Lock puertaDesembarque = new ReentrantLock();
    private Lock puertaLibre1 = new ReentrantLock();
    private Lock puertaLibre2 = new ReentrantLock();
    private Lock puertaLibre3 = new ReentrantLock();
    private Lock puertaLibre4 = new ReentrantLock();

    private List<Lock> PuertasEmbarque = new ArrayList<>();
    private List<Lock> PuertasDesembarque = new ArrayList<>();

    private List<String> areaRodaje = new ArrayList<>();

    private Lock pista1 = new ReentrantLock();
    private Lock pista2 = new ReentrantLock();
    private Lock pista3 = new ReentrantLock();
    private Lock pista4 = new ReentrantLock();

    private List<Lock> Pistas = new ArrayList<>();

    private Lock lock = new ReentrantLock();
    private Condition parado = lock.newCondition();

    private List<String> aerovia = new ArrayList<>();

    private Semaphore taller = new Semaphore(20, true);
    private Lock puertaTaller = new ReentrantLock();

    private int avionesHangar, avionesTaller, avionesAreaRodaje, avionesAreaEstacionamiento;

    Aeropuerto(Lock paradaCiudad, Lock paradaAeropuerto, Log log, JTextField TransfersAeropuerto, JTextField TransfersCiudad, JTextField TFPersonasDentro,
            JTextField txtHangar, JTextField txtTaller, JTextField txtAreaEstacion, JTextField txtGate1,
            JTextField txtGate2, JTextField txtGate3, JTextField txtGate4, JTextField txtGate5,
            JTextField txtGate6, JTextField txtAreaRodaje, JTextField txtPista1, JTextField txtPista2,
            JTextField txtPista3, JTextField txtPista4, JTextField txtAerovia, String nombre) {

        PuertasEmbarque.add(puertaEmbarque);
        PuertasEmbarque.add(puertaLibre1);
        PuertasEmbarque.add(puertaLibre2);
        PuertasEmbarque.add(puertaLibre3);
        PuertasEmbarque.add(puertaLibre4);

        PuertasDesembarque.add(puertaDesembarque);
        PuertasDesembarque.add(puertaLibre1);
        PuertasDesembarque.add(puertaLibre2);
        PuertasDesembarque.add(puertaLibre3);
        PuertasDesembarque.add(puertaLibre4);

        Pistas.add(pista1);
        Pistas.add(pista2);
        Pistas.add(pista3);
        Pistas.add(pista4);

        this.paradaCiudad = paradaCiudad;
        this.paradaAeropuerto = paradaAeropuerto;
        this.log = log;
        this.fieldParadaAeropuerto = TransfersAeropuerto;
        this.fieldParadaCiudad = TransfersCiudad;
        this.TFPersonasDentro = TFPersonasDentro;
        this.fieldHangar = txtHangar;
        this.fieldTaller = txtTaller;
        this.tFAreaEstacionamiento = txtAreaEstacion;
        this.fieldGate1 = txtGate1;
        this.fieldGate2 = txtGate2;
        this.fieldGate3 = txtGate3;
        this.fieldGate4 = txtGate4;
        this.fieldGate5 = txtGate5;
        this.fieldGate6 = txtGate6;
        this.fieldAreaRodaje = txtAreaRodaje;
        this.fieldPista1 = txtPista1;
        this.fieldPista2 = txtPista2;
        this.fieldPista3 = txtPista3;
        this.fieldPista4 = txtPista4;
        this.fieldAerovia = txtAerovia;
        this.nombre = nombre;
        TFPersonasDentro.setText(String.format("%s", personasDentro));
    }

    //MÉTODOS PARA AUTOBUSES
    public void paradaCiudad(Autobus aThis) {
        siParar();
        try {
            paradaCiudad.lock();
            log.writeLog("El autobús " + aThis.getIdFormateado() + " llegó a " + this.getNombre());
            siParar();
            fieldParadaCiudad.setText(String.format("%s", aThis.getIdFormateado() + "(" + aThis.getPasajerosSubidos() + ")"));
            Thread.sleep(new Random().nextInt(4) * 1000);
            // Suben los pasajeros
            aThis.setPasajerosSubidos(new Random().nextInt(51));
            log.writeLog("Al autobús " + aThis.getIdFormateado() + " subieron " + aThis.getPasajerosSubidos() + " pasajeros.");
            siParar();
            fieldParadaCiudad.setText(String.format("%s", aThis.getIdFormateado() + "(" + aThis.getPasajerosSubidos() + ")"));
            Thread.sleep(2000);
            siParar();
            fieldParadaCiudad.setText("");
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            paradaCiudad.unlock();
        }
    }

    public void viajarAeropuerto(Autobus aThis) {
        siParar();
        try {
            log.writeLog("El autobús " + aThis.getIdFormateado() + " viaja hacia el aeropuerto de " + this.getNombre());
            Thread.sleep((new Random().nextInt(6) * 1000) + 5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paradaAeropuerto(Autobus aThis) {
        siParar();
        try {
            paradaAeropuerto.lock();
            siParar();
            fieldParadaAeropuerto.setText(String.format("%s", aThis.getIdFormateado() + "(" + aThis.getPasajerosSubidos() + ")"));
            Thread.sleep(new Random().nextInt(4) * 1000);
            //Se bajan los pasajeros y se suben otros
            this.setPersonasDentro(this.getPersonasDentro() + aThis.getPasajerosSubidos());
            actualizarPersonasDentro(personasDentro);
            Thread.sleep(2000);
            aThis.setPasajerosSubidos(0);
            siParar();
            fieldParadaAeropuerto.setText(String.format("%s", aThis.getIdFormateado() + "(" + aThis.getPasajerosSubidos() + ")"));
            aThis.setPasajerosSubidos(new Random().nextInt(51));
            if (aThis.getPasajerosSubidos() >= personasDentro) {
                aThis.setPasajerosSubidos(personasDentro);
                this.setPersonasDentro(0);
            } else {
                this.setPersonasDentro(this.getPersonasDentro() - aThis.getPasajerosSubidos());
            }
            fieldParadaAeropuerto.setText(String.format("%s", aThis.getIdFormateado() + "(" + aThis.getPasajerosSubidos() + ")"));
            actualizarPersonasDentro(personasDentro);
            log.writeLog("El autobús " + aThis.getIdFormateado() + " llegó al aeropuerto de " + this.getNombre() + ", se bajaron sus pasajeros y se han subido otros " + aThis.getPasajerosSubidos() + " nuevos pasajeros.");
            siParar();
            fieldParadaAeropuerto.setText("");
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            paradaAeropuerto.unlock();
        }
    }

    public void viajarCiudad(Autobus aThis) {
        siParar();
        try {
            log.writeLog("El autobús " + aThis.getIdFormateado() + " viaja hacia la ciudad " + this.getNombre());
            Thread.sleep((new Random().nextInt(6) * 1000) + 5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void siParar() {
        while (parar) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //MÉTODOS PARA AVIONES
    public synchronized void actualizarPersonasDentro(int personasDentro) {
        TFPersonasDentro.setText(String.format("%s", personasDentro));
    }

    public synchronized void entrarHangar(Avion AThis) {
        siParar();
        annadirAvionHangar(AThis);
        avionesHangar++;
        fieldHangar.setText(String.join(", ", hangar));
    }

    public synchronized void salirHangar(Avion AThis) {
        siParar();
        quitarAvionHangar(AThis);
        avionesHangar--;
        if (hangar != null && !hangar.isEmpty()) {
            fieldHangar.setText(String.join(", ", hangar));
        } else {
            fieldHangar.setText("");
        }
    }

    public synchronized String obtenerPrimeroColaAreaEstacionamiento() {
        siParar();
        if (this.getAreaEstacionamiento() != null) {
            return this.getAreaEstacionamiento().get(0);
        } else {
            return null;
        }
    }

    public int controlBloqueoPuertas(Avion aThis, int caso) {
        siParar();
        int contador = 0;
        boolean continuar = true;
        while (continuar) {
            if (caso == 1) {
                if (this.getPuertaEmbarque().tryLock()) {
                    siParar();
                    log.writeLog("El avion " + aThis.getIdFormateado() + " ha obtenido la puerta de embarque");
                    areaEstacionamiento.remove(aThis.getIdFormateado());
                    avionesAreaEstacionamiento--;
                    if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                        siParar();
                        tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                    } else {
                        siParar();
                        tFAreaEstacionamiento.setText("");
                    }
                    siParar();
                    fieldGate1.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + "EMBARCA");
                    contador = 0;
                    break;
                }
            }
            if (this.getPuertaLibre1().tryLock()) {
                if (caso == 1) {
                    siParar();
                    log.writeLog("El avion " + aThis.getIdFormateado() + " ha obtenido la puerta libre 1 para embarcar");
                    areaEstacionamiento.remove(aThis.getIdFormateado());
                    avionesAreaEstacionamiento--;
                    if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                        siParar();
                        tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                    } else {
                        siParar();
                        tFAreaEstacionamiento.setText("");
                    }
                    siParar();
                    fieldGate2.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + "EMBARCA");
                    contador = 1;
                    break;
                } else {
                    try {
                        Thread.sleep((new Random().nextInt(5) * 1000) + 3000);
                        quitarAvionAreaRodaje(aThis);
                        avionesAreaRodaje--;
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                        log.writeLog("El avion " + aThis.getIdFormateado() + " obtiene la puerta libre 1 para desembarcar");
                        siParar();
                        fieldGate2.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESEMBARQUE ");
                        contador = 1;
                        desembarcarPasajeros(aThis, puertaLibre1, contador);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (this.getPuertaLibre2().tryLock()) {
                if (caso == 1) {
                    log.writeLog("El avion " + aThis.getIdFormateado() + " ha obtenido la puerta libre 2 para embarcar");
                    areaEstacionamiento.remove(aThis.getIdFormateado());
                    avionesAreaEstacionamiento--;
                    if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                        siParar();
                        tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                    } else {
                        siParar();
                        tFAreaEstacionamiento.setText("");
                    }
                    siParar();
                    fieldGate3.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + "EMBARCA");
                    contador = 2;
                    break;
                } else {
                    try {
                        Thread.sleep((new Random().nextInt(5) * 1000) + 3000);
                        quitarAvionAreaRodaje(aThis);
                        avionesAreaRodaje--;
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                        log.writeLog("El avion " + aThis.getIdFormateado() + " obtiene la puerta libre 2 para desembarcar");
                        siParar();
                        fieldGate3.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESEMBARQUE ");
                        contador = 2;
                        desembarcarPasajeros(aThis, puertaLibre2, contador);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (this.getPuertaLibre3().tryLock()) {
                if (caso == 1) {
                    log.writeLog("El avion " + aThis.getIdFormateado() + " ha obtenido la puerta libre 3 para embarcar");
                    areaEstacionamiento.remove(aThis.getIdFormateado());
                    avionesAreaEstacionamiento--;
                    if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                        siParar();
                        tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                    } else {
                        siParar();
                        tFAreaEstacionamiento.setText("");
                    }
                    siParar();
                    fieldGate4.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + "EMBARCA");
                    contador = 3;
                    break;
                } else {
                    try {
                        Thread.sleep((new Random().nextInt(5) * 1000) + 3000);
                        quitarAvionAreaRodaje(aThis);
                        avionesAreaRodaje--;
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                        log.writeLog("El avion " + aThis.getIdFormateado() + " obtiene la puerta libre 3 para desembarcar");
                        siParar();
                        fieldGate4.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESEMBARQUE ");
                        contador = 3;
                        desembarcarPasajeros(aThis, puertaLibre3, contador);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (this.getPuertaLibre4().tryLock()) {
                if (caso == 1) {
                    log.writeLog("El avion " + aThis.getIdFormateado() + " ha obtenido la puerta libre 4 para embarcar");
                    areaEstacionamiento.remove(aThis.getIdFormateado());
                    avionesAreaEstacionamiento--;
                    if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                        siParar();
                        tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                    } else {
                        siParar();
                        tFAreaEstacionamiento.setText("");
                    }
                    fieldGate5.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + "EMBARCA");
                    contador = 4;
                    break;
                } else {
                    try {
                        Thread.sleep((new Random().nextInt(5) * 1000) + 3000);
                        quitarAvionAreaRodaje(aThis);
                        avionesAreaRodaje--;
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                        log.writeLog("El avion " + aThis.getIdFormateado() + " obtiene la puerta libre 4 para desembarcar");
                        siParar();
                        fieldGate5.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESEMBARQUE ");
                        contador = 4;
                        desembarcarPasajeros(aThis, puertaLibre4, contador);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (caso == 2) {
                if (this.getPuertaDesembarque().tryLock()) {
                    try {
                        Thread.sleep((new Random().nextInt(5) * 1000) + 3000);
                        quitarAvionAreaRodaje(aThis);
                        avionesAreaRodaje--;
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                        log.writeLog("El avion " + aThis.getIdFormateado() + " obtiene la puerta de desembarque");
                        siParar();
                        fieldGate6.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESEMBARQUE ");
                        contador = 0;
                        desembarcarPasajeros(aThis, puertaDesembarque, contador);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        }
        log.writeLog("El avion: " + aThis.getIdFormateado() + " bloquea la puerta: " + contador + " del caso: " + caso);
        return contador;
    }

    private synchronized void cerrarBloqueoPuertas(Avion aThis, int contador, int caso) {
        siParar();
        try {
            if (caso == 1) {
                switch (contador) {
                    case 0 ->
                        this.getPuertaEmbarque().unlock();
                    case 1 ->
                        this.getPuertaLibre1().unlock();
                    case 2 ->
                        this.getPuertaLibre2().unlock();
                    case 3 ->
                        this.getPuertaLibre3().unlock();
                    case 4 ->
                        this.getPuertaLibre4().unlock();
                    default -> {
                    }
                }
            } else {
                switch (contador) {
                    case 0 ->
                        this.getPuertaDesembarque().unlock();
                    case 1 ->
                        this.getPuertaLibre1().unlock();
                    case 2 ->
                        this.getPuertaLibre2().unlock();
                    case 3 ->
                        this.getPuertaLibre3().unlock();
                    case 4 ->
                        this.getPuertaLibre4().unlock();
                    default -> {
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.writeLog("El avion: " + aThis.getIdFormateado() + " desbloquea la puerta: " + contador + "del caso: " + caso);
    }

    public void AreaEstacionamiento(Avion aThis, int caso) {
        siParar();
        int contador_puertas = 0;
        if (caso == 1) {
            try {
                int contador = 0;
                areaEstacionamiento.add(aThis.getIdFormateado());
                avionesAreaEstacionamiento++;
                siParar();
                tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                Thread.sleep((new Random().nextInt(1) * 1000) + 1000);
                //Hasta que no sea el primero de la FIFO, se queda esperando
                boolean continua = true;
                Thread.sleep(1500);
                String primeroColaEstacionamiento = this.obtenerPrimeroColaAreaEstacionamiento();
                if (primeroColaEstacionamiento != null) {
                    if (primeroColaEstacionamiento.equals(aThis.getIdFormateado())) {
                        continua = false;
                    }
                }
                //Espera a que una de las puertas de embarque esté libre
                contador = this.controlBloqueoPuertas(aThis, 1);

                //Embarcamos los pasajeros
                embarcarPasajeros(aThis, contador);

                //El avion deja libre la puerta de embarque
                log.writeLog("El avión " + aThis.getIdFormateado() + " cierra sus puertas de embarque y sale de la puerta de embarque " + contador + 1);
                siParar();
                switch (contador) {
                    case 0 ->
                        fieldGate1.setText("");
                    case 1 ->
                        fieldGate2.setText("");
                    case 2 ->
                        fieldGate3.setText("");
                    case 3 ->
                        fieldGate4.setText("");
                    case 4 ->
                        fieldGate5.setText("");
                    default -> {
                    }
                }
                contador_puertas = contador;
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.cerrarBloqueoPuertas(aThis, contador_puertas, caso);
            }
        } else if (caso == 2) {
            try {
                lockEstacionamiento.lock();
                areaEstacionamiento.add(aThis.getIdFormateado());
                avionesAreaEstacionamiento++;
                siParar();
                tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
                Thread.sleep((int) (Math.random() * 5000 + 1000)); //Comprobaciones
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                lockEstacionamiento.unlock();
            }
        }
    }

    public void embarcarPasajeros(Avion aThis, int contador) {
        siParar();
        int intentos = 0;
        while (intentos < 3) {
            int numeroPasajerosFaltanEmbarcar = aThis.getCapacidadMaxima() - aThis.getPasajerosDentro();
            if (numeroPasajerosFaltanEmbarcar <= this.getPersonasDentro()) {
                try {
                    aThis.setPasajerosDentro(aThis.getPasajerosDentro() + numeroPasajerosFaltanEmbarcar);
                    log.writeLog("En el avión " + aThis.getIdFormateado() + " han embarcado " + aThis.getPasajerosDentro() + " pasajeros.");
                    this.setPersonasDentro(this.getPersonasDentro() - numeroPasajerosFaltanEmbarcar);
                    actualizarPersonasDentro(this.getPersonasDentro());
                    siParar();
                    switch (contador) {
                        case 0 ->
                            fieldGate1.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " EMBARQUE ");
                        case 1 ->
                            fieldGate2.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " EMBARQUE ");
                        case 2 ->
                            fieldGate3.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " EMBARQUE ");
                        case 3 ->
                            fieldGate4.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " EMBARQUE ");
                        case 4 ->
                            fieldGate5.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " EMBARQUE ");
                    }
                    Thread.sleep((new Random().nextInt(3) * 1000) + 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            } else {
                try {
                    int numeroPersonasEmbarque = this.getPersonasDentro();
                    aThis.setPasajerosDentro(aThis.getPasajerosDentro() + numeroPersonasEmbarque);
                    log.writeLog("En el avión " + aThis.getIdFormateado() + " han embarcado " + aThis.getPasajerosDentro() + " pasajeros.");
                    this.setPersonasDentro(this.getPersonasDentro() - numeroPersonasEmbarque);
                    actualizarPersonasDentro(this.getPersonasDentro());
                    Thread.sleep((new Random().nextInt(5) * 1000) + 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            intentos++;
        }
    }

    public void AreaRodaje(Avion aThis, int caso) {
        siParar();
        if (caso == 1) {
            try {
                for (String a : areaRodaje) {
                    if (a == null) {
                        a = "";
                    }
                }
                log.writeLog(aThis.getIdFormateado() + " accedió al ÁREA DE RODAJE.");
                annadirAvionAreaRodaje(aThis);
                avionesAreaRodaje++;
                siParar();
                fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                Thread.sleep((new Random().nextInt(5) * 1000) + 1000); // Los pilotos realizan comprobaciones
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (caso == 2) {
            try {
                log.writeLog("El avión " + aThis.getIdFormateado() + " accedió al ÁREA DE RODAJE para dirigirse a la PUERTA DE EMBARQUE.");
                annadirAvionAreaRodaje(aThis);
                avionesAreaRodaje++;
                siParar();
                fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                Thread.sleep((new Random().nextInt(5) * 1000) + 1000);
                int contador = this.controlBloqueoPuertas(aThis, 2);
                this.cerrarBloqueoPuertas(aThis, contador, 2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void solicitarPista(Avion aThis) {
        siParar();
        int contador;
        boolean variable = true;
        while (variable) {
            contador = 0;
            for (Lock l : Pistas) {
                /*
                switch (contador) {
                    case 0 ->
                        pistaCerrada = pista1Cerrada;
                    case 1 ->
                        pistaCerrada = pista2Cerrada;
                    case 2 ->
                        pistaCerrada = pista3Cerrada;
                    case 3 ->
                        pistaCerrada = pista4Cerrada;
                    default -> {
                    }
                }
*/
                if (l.tryLock() /*&& !pistaCerrada*/) {
                    //Sale del Area de Rodaje
                    quitarAvionAreaRodaje(aThis);
                    avionesAreaRodaje--;
                    if (areaRodaje != null && !areaRodaje.isEmpty()) {
                        siParar();
                        fieldAreaRodaje.setText(String.join(", ", areaRodaje));
                    } else {
                        siParar();
                        fieldAreaRodaje.setText("");
                    }
                    //Acceder a la Pista
                    log.writeLog("El avion " + aThis.getIdFormateado() + " accede a una Pista para despegar");
                    siParar();
                    switch (contador) {
                        case 0 ->
                            fieldPista1.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESPEGUE ");
                        case 1 ->
                            fieldPista2.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESPEGUE ");
                        case 2 ->
                            fieldPista3.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESPEGUE ");
                        case 3 ->
                            fieldPista4.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " DESPEGUE ");
                        default -> {
                        }
                    }
                    despegar(aThis, contador);
                    variable = false;
                    break;
                } else {
                    contador++;
                }
            }
        }
    }

    public void despegar(Avion aThis, int contador) {
        siParar();
        try {
            // Realizar verificaciones antes del despegue
            log.writeLog("El avión " + aThis.getIdFormateado() + " está realizando verificaciones antes del despegue.");
            Thread.sleep((new Random().nextInt(3) * 1000) + 1000);
            log.writeLog("El avión " + aThis.getIdFormateado() + " despegó.");
            Thread.sleep((new Random().nextInt(5) * 1000) + 1000);
            siParar();
            switch (contador) {
                case 0 ->
                    fieldPista1.setText("");
                case 1 ->
                    fieldPista2.setText("");
                case 2 ->
                    fieldPista3.setText("");
                case 3 ->
                    fieldPista4.setText("");
                default -> {
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Libera el lock de la pista
            this.getPistas().get(contador).unlock();
        }
    }

    public void accederAerovia(Avion aThis) {
        siParar();
        try {
            aThis.getOrigen().entrarAerovia(aThis);//
            if (aThis.getOrigen().equals("Madrid")) {
                log.writeLog("El avión " + aThis.getIdFormateado() + " accedió a la AEROVÍA MADRID-BARCELONA");
            } else {
                log.writeLog("El avión " + aThis.getIdFormateado() + " accedió a la AEROVÍA BARCELONA-MADRID");
            }
            Thread.sleep((new Random().nextInt(16) * 1000) + 15000);
            aThis.getDestino().solicitarPistaAterrizaje(aThis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public synchronized void entrarAerovia(Avion aThis) {
        siParar();
        annadirAvionAerovia(aThis);
        fieldAerovia.setText(String.join(", ", aerovia));
    }

    public synchronized void salirAerovia(Avion aThis) {
        siParar();
        aThis.getOrigen().quitarAvionAerovia(aThis);
        aThis.getOrigen().fieldAerovia.setText(String.join(", ", aerovia));
    }

    public void solicitarPistaAterrizaje(Avion aThis) {
        siParar();
        int contador = 0;
        boolean variable = true;
        while (variable) {
            try {
                contador = 0;
                for (Lock l : Pistas) {
                    if (l.tryLock()) {
                        aThis.getOrigen().salirAerovia(aThis);//
                        log.writeLog("El avion " + aThis.getIdFormateado() + " accede a una Pista para aterrizar");
                        siParar();
                        switch (contador) {
                            case 0 ->
                                fieldPista1.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " ATERRIZAJE ");
                            case 1 ->
                                fieldPista2.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " ATERRIZAJE ");
                            case 2 ->
                                fieldPista3.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " ATERRIZAJE ");
                            case 3 ->
                                fieldPista4.setText(aThis.getIdFormateado() + "(" + aThis.getPasajerosDentro() + ")" + " ATERRIZAJE ");
                            default -> {
                            }
                        }
                        // Aterrizar
                        aterrizar(aThis, l, contador);
                        variable = false;
                        break;
                    } else {
                        contador++;
                    }
                }
                Thread.sleep((int) (Math.random() * 5000 + 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void aterrizar(Avion aThis, Lock l2, int contador) {
        siParar();
        try {
            log.writeLog("El avión " + aThis.getIdFormateado() + " aterrizó en una pista");
            Thread.sleep((new Random().nextInt(5) * 1000) + 1000);
            siParar();
            //Sale de la Pista
            switch (contador) {
                case 0 ->
                    fieldPista1.setText("");
                case 1 ->
                    fieldPista2.setText("");
                case 2 ->
                    fieldPista3.setText("");
                case 3 ->
                    fieldPista4.setText("");
                default -> {
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Libera el lock de la pista
            this.getPistas().get(contador).unlock();
        }
    }

    public void desembarcarPasajeros(Avion aThis, Lock l3, int contador) {
        siParar();
        try {
            // Desembarcar pasajeros
            log.writeLog("Han desembarcado " + aThis.getPasajerosDentro() + " pasajeros del avión " + aThis.getIdFormateado());
            this.setPersonasDentro(this.getPersonasDentro() + aThis.getPasajerosDentro());
            actualizarPersonasDentro(personasDentro);
            aThis.setPasajerosDentro(0);
            Thread.sleep((int) (Math.random() * 5000 + 1000));
            siParar();
            switch (contador) {
                case 0 ->
                    fieldGate6.setText("");
                case 1 ->
                    fieldGate2.setText("");
                case 2 ->
                    fieldGate3.setText("");
                case 3 ->
                    fieldGate4.setText("");
                case 4 ->
                    fieldGate5.setText("");
                default -> {
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inspeccion(Avion aThis, int i) {
        siParar();
        try {
            taller.acquire();
            areaEstacionamiento.remove(aThis.getIdFormateado());
            avionesAreaEstacionamiento--;
            avionesTaller++;
            if (areaEstacionamiento != null && !areaEstacionamiento.isEmpty()) {
                siParar();
                tFAreaEstacionamiento.setText(String.join(", ", areaEstacionamiento));
            } else {
                siParar();
                tFAreaEstacionamiento.setText("");
            }
            if (i == 1) {
                fieldTaller.setText(aThis.getIdFormateado());
                Thread.sleep((int) (Math.random() * 10000 + 5000));
                log.writeLog("El avión " + aThis.getIdFormateado() + " termina su inspeccion en profundidad y se va del Taller");
                pasarPuertaTaller(aThis);
                siParar();
                fieldTaller.setText("");
            } else {
                fieldTaller.setText(aThis.getIdFormateado());
                Thread.sleep((int) (Math.random() * 10000 + 5000));
                log.writeLog("El avión " + aThis.getIdFormateado() + " termina su inspeccion rápida y se va del Taller");
                pasarPuertaTaller(aThis);
                siParar();
                fieldTaller.setText("");
            }
            avionesTaller--;
            taller.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void pasarPuertaTaller(Avion aThis) {
        siParar();
        try {
            puertaTaller.lock();
            log.writeLog("El avión " + aThis.getIdFormateado() + " pasa por la puerta del Taller");
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            puertaTaller.unlock();
        }
    }

    ///GETTERS Y SETTERS
    public int getPersonasDentro() {
        return personasDentro;
    }

    public void setPersonasDentro(int personasDentro) {
        siParar();
        this.personasDentro = personasDentro;
        TFPersonasDentro.setText(String.format("%s", personasDentro));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<String> getAreaEstacionamiento() {
        return areaEstacionamiento;
    }

    public void setAreaEstacionamiento(LinkedList<String> areaEstacionamiento) {
        this.areaEstacionamiento = areaEstacionamiento;
    }

    public Lock getLockEstacionamiento() {
        return lockEstacionamiento;
    }

    public void setLockEstacionamiento(Lock lockEstacionamiento) {
        this.lockEstacionamiento = lockEstacionamiento;
    }

    public Condition getAlgunoOcupado() {
        return algunoOcupado;
    }

    public void setAlgunoOcupado(Condition algunoOcupado) {
        this.algunoOcupado = algunoOcupado;
    }

    public Semaphore getTaller() {
        return taller;
    }

    public void setTaller(Semaphore taller) {
        this.taller = taller;
    }

    public Lock getPuertaTaller() {
        return puertaTaller;
    }

    public void setPuertaTaller(Lock puertaTaller) {
        this.puertaTaller = puertaTaller;
    }

    public Lock getPuertaEmbarque() {
        return puertaEmbarque;
    }

    public void setPuertaEmbarque(Lock puertaEmbarque) {
        this.puertaEmbarque = puertaEmbarque;
    }

    public Lock getPuertaDesembarque() {
        return puertaDesembarque;
    }

    public void setPuertaDesembarque(Lock puertaDesembarque) {
        this.puertaDesembarque = puertaDesembarque;
    }

    public Lock getPuertaLibre1() {
        return puertaLibre1;
    }

    public void setPuertaLibre1(Lock puertaLibre1) {
        this.puertaLibre1 = puertaLibre1;
    }

    public Lock getPuertaLibre2() {
        return puertaLibre2;
    }

    public void setPuertaLibre2(Lock puertaLibre2) {
        this.puertaLibre2 = puertaLibre2;
    }

    public Lock getPuertaLibre3() {
        return puertaLibre3;
    }

    public void setPuertaLibre3(Lock puertaLibre3) {
        this.puertaLibre3 = puertaLibre3;
    }

    public Lock getPuertaLibre4() {
        return puertaLibre4;
    }

    public void setPuertaLibre4(Lock puertaLibre4) {
        this.puertaLibre4 = puertaLibre4;
    }

    public List<Lock> getPuertas() {
        return PuertasEmbarque;
    }

    public void setPuertas(List<Lock> Puertas) {
        this.PuertasEmbarque = Puertas;
    }

    public List<Lock> getPuertasDesembarque() {
        return PuertasDesembarque;
    }

    public void setPuertasDesembarque(List<Lock> PuertasDesembarque) {
        this.PuertasDesembarque = PuertasDesembarque;
    }

    public Lock getPista1() {
        return pista1;
    }

    public void setPista1(Lock pista1) {
        this.pista1 = pista1;
    }

    public Lock getPista2() {
        return pista2;
    }

    public void setPista2(Lock pista2) {
        this.pista2 = pista2;
    }

    public Lock getPista3() {
        return pista3;
    }

    public void setPista3(Lock pista3) {
        this.pista3 = pista3;
    }

    public Lock getPista4() {
        return pista4;
    }

    public void setPista4(Lock pista4) {
        this.pista4 = pista4;
    }

    public List<Lock> getPistas() {
        return Pistas;
    }

    public void setPistas(List<Lock> Pistas) {
        this.Pistas = Pistas;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Condition getParado() {
        return parado;
    }

    public void setParado(Condition parado) {
        this.parado = parado;
    }

    public void parar() {
        this.parar = true;
    }

    public boolean mirarSiParar() {
        return this.parar;
    }

    public synchronized void continuar() {
        parar = false;
        notifyAll();
    }

    public List<Lock> getPuertasEmbarque() {
        return PuertasEmbarque;
    }

    public List<String> getHangar() {
        return hangar;
    }

    public void setHangar(List<String> hangar) {
        this.hangar = hangar;
    }

    public void annadirAvionHangar(Avion avion) {
        hangar.add(avion.getIdFormateado());
    }

    public void quitarAvionHangar(Avion avion) {
        hangar.remove(avion.getIdFormateado());
    }

    public List<String> getAreaRodaje() {
        return areaRodaje;
    }

    public void setAreaRodaje(List<String> areaRodaje) {
        this.areaRodaje = areaRodaje;
    }

    public void annadirAvionAreaRodaje(Avion avion) {
        areaRodaje.add(avion.getIdFormateado() + "(" + avion.getPasajerosDentro() + ")");
    }

    public void quitarAvionAreaRodaje(Avion avion) {
        areaRodaje.remove(avion.getIdFormateado() + "(" + avion.getPasajerosDentro() + ")");
    }

    public List<String> getAerovia() {
        return aerovia;
    }

    public void setAerovia(List<String> aerovia) {
        this.aerovia = aerovia;
    }

    public void annadirAvionAerovia(Avion avion) {
        aerovia.add(avion.getIdFormateado() + "(" + avion.getPasajerosDentro() + ")");
    }

    public void quitarAvionAerovia(Avion avion) {
        aerovia.remove(avion.getIdFormateado() + "(" + avion.getPasajerosDentro() + ")");
    }

    public int getAvionesHangar() {
        return avionesHangar;
    }

    public void setAvionesHangar(int avionesHangar) {
        this.avionesHangar = avionesHangar;
    }

    public int getAvionesTaller() {
        return avionesTaller;
    }

    public void setAvionesTaller(int avionesTaller) {
        this.avionesTaller = avionesTaller;
    }

    public int getAvionesAreaRodaje() {
        return avionesAreaRodaje;
    }

    public void setAvionesAreaRodaje(int avionesAreaRodaje) {
        this.avionesAreaRodaje = avionesAreaRodaje;
    }

    public int getAvionesAreaEstacionamiento() {
        return avionesAreaEstacionamiento;
    }

    public void setAvionesAreaEstacionamiento(int avionesAreaEstacionamiento) {
        this.avionesAreaEstacionamiento = avionesAreaEstacionamiento;
    }

    public boolean isPista1Cerrada() {
        return pista1Cerrada;
    }

    public void setPista1Cerrada(boolean pista1Cerrada) {
        this.pista1Cerrada = pista1Cerrada;
    }

    public boolean isPista2Cerrada() {
        return pista2Cerrada;
    }

    public void setPista2Cerrada(boolean pista2Cerrada) {
        this.pista2Cerrada = pista2Cerrada;
    }

    public boolean isPista3Cerrada() {
        return pista3Cerrada;
    }

    public void setPista3Cerrada(boolean pista3Cerrada) {
        this.pista3Cerrada = pista3Cerrada;
    }

    public boolean isPista4Cerrada() {
        return pista4Cerrada;
    }

    public void setPista4Cerrada(boolean pista4Cerrada) {
        this.pista4Cerrada = pista4Cerrada;
    }

    public boolean isPistaCerrada() {
        return pistaCerrada;
    }

    public void setPistaCerrada(boolean pistaCerrada) {
        this.pistaCerrada = pistaCerrada;
    }
    
    
    
}
