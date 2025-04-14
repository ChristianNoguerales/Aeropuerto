package Distribuida;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AeropuertoRemote extends Remote {
    public int getNumPasajerosMadrid() throws RemoteException;
    public int getNumPasajerosBarcelona() throws RemoteException;
    public int getNumAvionesHangarMadrid() throws RemoteException;
    public int getNumAvionesHangarBarcelona() throws RemoteException;
    public int getNumAvionesTallerMadrid() throws RemoteException;
    public int getNumAvionesTallerBarcelona() throws RemoteException;
    public int getNumAvionesAreaEstacionamientoMadrid() throws RemoteException;
    public int getNumAvionesAreaEstacionamientoBarcelona() throws RemoteException;
    public int getNumAvionesAreaRodajeMadrid() throws RemoteException;
    public int getNumAvionesAreaRodajeBarcelona() throws RemoteException;
    public List<String> getAeroviaMadrid() throws RemoteException;
    public List<String> getAeroviaBarcelona() throws RemoteException; 
    public void cerrarPista1Madrid() throws RemoteException;
    public void cerrarPista2Madrid() throws RemoteException;
    public void cerrarPista3Madrid() throws RemoteException;
    public void cerrarPista4Madrid() throws RemoteException;
    public void cerrarPista1Barcelona() throws RemoteException;
    public void cerrarPista2Barcelona() throws RemoteException;
    public void cerrarPista3Barcelona() throws RemoteException;
    public void cerrarPista4Barcelona() throws RemoteException;
    public void liberarPista1Madrid() throws RemoteException;
    public void liberarPista2Madrid() throws RemoteException;
    public void liberarPista3Madrid() throws RemoteException;
    public void liberarPista4Madrid() throws RemoteException;
    public void liberarPista1Barcelona() throws RemoteException;
    public void liberarPista2Barcelona() throws RemoteException;
    public void liberarPista3Barcelona() throws RemoteException;
    public void liberarPista4Barcelona() throws RemoteException;
}
