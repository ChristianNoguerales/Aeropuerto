package Distribuida;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente extends Thread {

    private final InterfazCliente gui;
    private AeropuertoRemote obj;
    private int vecesPista1Madrid, vecesPista2Madrid, vecesPista3Madrid, vecesPista4Madrid, vecesPista1Barcelona,
            vecesPista2Barcelona, vecesPista3Barcelona, vecesPista4Barcelona = 0;

    private int vLiberaPista1Madrid, vLiberaPista2Madrid, vLiberaPista3Madrid, vLiberaPista4Madrid, vLiberaPista1Barcelona,
            vLiberaPista2Barcelona, vLiberaPista3Barcelona, vLiberaPista4Barcelona = 0;

    public Cliente(InterfazCliente gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            obj = (AeropuertoRemote) Naming.lookup("//127.0.0.1/ObjetoAeropuerto"); //Localiza el objeto distribuido
            System.out.println("Cliente conectado");
            while (true) {

                gui.actualizar(obj.getNumPasajerosMadrid(), obj.getNumPasajerosBarcelona(), obj.getNumAvionesHangarMadrid(),
                        obj.getNumAvionesHangarBarcelona(), obj.getNumAvionesTallerMadrid(), obj.getNumAvionesTallerBarcelona(),
                        obj.getNumAvionesAreaEstacionamientoMadrid(), obj.getNumAvionesAreaEstacionamientoBarcelona(),
                        obj.getNumAvionesAreaRodajeMadrid(), obj.getNumAvionesAreaRodajeBarcelona(), obj.getAeroviaMadrid(),
                        obj.getAeroviaBarcelona());

                //BLOQUEAR LAS PISTAS
                if (gui.isBotonCerrarPista1Madrid()) {
                    vLiberaPista1Madrid = 0;
                    vecesPista1Madrid++;
                    if (vecesPista1Madrid == 1) {
                        obj.cerrarPista1Madrid();
                    }
                }
                if (gui.isBotonCerrarPista2Madrid()) {
                    vLiberaPista2Madrid = 0;
                    vecesPista2Madrid++;
                    if (vecesPista2Madrid == 1) {
                        obj.cerrarPista2Madrid();
                    }
                }
                if (gui.isBotonCerrarPista3Madrid()) {
                    vLiberaPista3Madrid = 0;
                    vecesPista3Madrid++;
                    if (vecesPista3Madrid == 1) {
                        obj.cerrarPista3Madrid();
                    }
                }
                if (gui.isBotonCerrarPista4Madrid()) {
                    vLiberaPista4Madrid = 0;
                    vecesPista4Madrid++;
                    if (vecesPista4Madrid == 1) {
                        obj.cerrarPista4Madrid();
                    }
                }

                if (gui.isBotonCerrarPista1Barcelona()) {
                    vLiberaPista1Barcelona = 0;
                    vecesPista1Barcelona++;
                    if (vecesPista1Barcelona == 1) {
                        obj.cerrarPista1Barcelona();
                    }
                }
                if (gui.isBotonCerrarPista2Barcelona()) {
                    vLiberaPista2Barcelona = 0;
                    vecesPista2Barcelona++;
                    if (vecesPista2Barcelona == 1) {
                        obj.cerrarPista2Barcelona();
                    }
                }
                if (gui.isBotonCerrarPista3Barcelona()) {
                    vLiberaPista3Barcelona = 0;
                    vecesPista3Barcelona++;
                    if (vecesPista3Barcelona == 1) {
                        obj.cerrarPista3Barcelona();

                    }
                }
                if (gui.isBotonCerrarPista4Barcelona()) {
                    vLiberaPista4Barcelona = 0;
                    vecesPista4Barcelona++;
                    if (vecesPista4Barcelona == 1) {
                        obj.cerrarPista4Barcelona();
                    }
                }
                //LIBERAR LAS PISTAS
                if (gui.isBotonLiberarPista1Madrid()) {
                    vecesPista1Madrid = 0;
                    vLiberaPista1Madrid++;
                    if (vLiberaPista1Madrid == 1) {
                        obj.liberarPista1Madrid();
                    }
                }

                if (gui.isBotonLiberarPista2Madrid()) {
                    vecesPista2Madrid = 0;
                    vLiberaPista2Madrid++;
                    if (vLiberaPista2Madrid == 1) {
                        obj.liberarPista2Madrid();
                    }
                }
                if (gui.isBotonLiberarPista3Madrid()) {
                    vecesPista3Madrid = 0;
                    vLiberaPista3Madrid++;
                    if (vLiberaPista3Madrid == 1) {
                        obj.liberarPista3Madrid();
                    }
                }
                if (gui.isBotonLiberarPista4Madrid()) {
                    vecesPista4Madrid = 0;
                    vLiberaPista4Madrid++;
                    if (vLiberaPista4Madrid == 1) {
                        obj.liberarPista4Madrid();
                    }
                }

                if (gui.isBotonLiberarPista1Barcelona()) {
                    vecesPista1Barcelona = 0;
                    vLiberaPista1Barcelona++;
                    if (vLiberaPista1Barcelona == 1) {
                        obj.liberarPista1Barcelona();
                    }
                }
                if (gui.isBotonLiberarPista2Barcelona()) {
                    vecesPista2Barcelona = 0;
                    vLiberaPista2Barcelona++;
                    if (vLiberaPista2Barcelona == 1) {
                        obj.liberarPista2Barcelona();
                    }
                }
                if (gui.isBotonLiberarPista3Barcelona()) {
                    vecesPista3Barcelona = 0;
                    vLiberaPista3Barcelona++;
                    if (vLiberaPista3Barcelona == 1) {
                        obj.liberarPista3Barcelona();
                    }
                }
                if (gui.isBotonLiberarPista4Barcelona()) {
                    vecesPista4Barcelona = 0;
                    vLiberaPista4Barcelona++;
                    if (vLiberaPista4Barcelona == 1) {
                        obj.liberarPista4Barcelona();
                    }
                }

            }

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Excepción : " + e.getMessage());
        }

    }

}
