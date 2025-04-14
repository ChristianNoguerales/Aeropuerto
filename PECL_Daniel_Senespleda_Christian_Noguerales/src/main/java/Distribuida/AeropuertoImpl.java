package Distribuida;

import Concurrida.InterfazServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AeropuertoImpl extends UnicastRemoteObject implements AeropuertoRemote {

    private InterfazServidor gui;

    public AeropuertoImpl(InterfazServidor gui) throws RemoteException {
        super();
        this.gui = gui;
    }

    @Override
    public int getNumPasajerosMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getPersonasDentro();
    }

    @Override
    public int getNumPasajerosBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getPersonasDentro();

    }

    @Override
    public int getNumAvionesHangarMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getAvionesHangar();
    }

    @Override
    public int getNumAvionesHangarBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getAvionesHangar();
    }

    @Override
    public int getNumAvionesTallerMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getAvionesTaller();
    }

    @Override
    public int getNumAvionesTallerBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getAvionesTaller();
    }

    @Override
    public int getNumAvionesAreaEstacionamientoMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getAvionesAreaEstacionamiento();
    }

    @Override
    public int getNumAvionesAreaEstacionamientoBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getAvionesAreaEstacionamiento();
    }

    @Override
    public int getNumAvionesAreaRodajeMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getAvionesAreaRodaje();
    }

    @Override
    public int getNumAvionesAreaRodajeBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getAvionesAreaRodaje();
    }

    @Override
    public List<String> getAeroviaMadrid() throws RemoteException {
        return gui.getAeropuertoMadrid().getAerovia();
    }

    @Override
    public List<String> getAeroviaBarcelona() throws RemoteException {
        return gui.getAeropuertoBarcelona().getAerovia();
    }

    ////////
    @Override
    public void cerrarPista1Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista1Cerrada(true);
    }

    @Override
    public void cerrarPista2Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista2Cerrada(true);
    }

    @Override
    public void cerrarPista3Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista3Cerrada(true);
    }

    @Override
    public void cerrarPista4Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista4Cerrada(true);
    }

    @Override
    public void cerrarPista1Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista1Cerrada(true);
    }

    @Override
    public void cerrarPista2Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista2Cerrada(true);
    }

    @Override
    public void cerrarPista3Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista3Cerrada(true);
    }

    @Override
    public void cerrarPista4Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista4Cerrada(true);
    }

    ///////////
    @Override
    public void liberarPista1Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista1Cerrada(false);
    }

    @Override
    public void liberarPista2Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista2Cerrada(false);
    }

    @Override
    public void liberarPista3Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista3Cerrada(false);
    }

    @Override
    public void liberarPista4Madrid() throws RemoteException {
        gui.getAeropuertoMadrid().setPista4Cerrada(false);
    }

    @Override
    public void liberarPista1Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista1Cerrada(false);
    }

    @Override
    public void liberarPista2Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista2Cerrada(false);
    }

    @Override
    public void liberarPista3Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista3Cerrada(false);
    }

    @Override
    public void liberarPista4Barcelona() throws RemoteException {
        gui.getAeropuertoBarcelona().setPista4Cerrada(false);
    }
}
