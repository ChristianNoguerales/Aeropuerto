package Distribuida;

import Concurrida.InterfazServidor;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor extends Thread {

    private InterfazServidor gui;

    public Servidor(InterfazServidor gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            AeropuertoImpl obj = new AeropuertoImpl(gui); //Crea una instancia del objeto que implementa la interfaz, como objeto a registrar 
            Registry registry = LocateRegistry.createRegistry(1099); //Arranca rmiregistry local en el puerto 1099
            Naming.rebind("//localhost/ObjetoAeropuerto", obj);   //rebind sólo funciona sobre una url del equipo local 
            System.out.println("El ObjetoAeropuerto ha quedado registrado");
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
