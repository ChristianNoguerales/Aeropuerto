package Concurrida;

import java.util.Random;

public class Sistema extends Thread{
    Aeropuerto madrid, barcelona;
    Log log = new Log();
    
    Sistema(Aeropuerto madrid, Aeropuerto barcelona) {
        this.madrid = madrid;
        this.barcelona = barcelona;
    }
    
    public void run(){
        for (int i = 0; i < 8000; i++) {//usar 10 para ver mas visual
            if (i < 4000) {//lo mismo con 5
                String prefijoID = "B-";
                long idAutobus = i + 1;
                if (idAutobus % 2 == 0) {
                    Autobus autobus = new Autobus(prefijoID, idAutobus, madrid);
                    autobus.start();
                } else {
                    Autobus autobus = new Autobus(prefijoID, idAutobus, barcelona);
                    autobus.start();
                }
            }
            String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int n = 0; n < 2; n++) {
                sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
            }
            String prefijoID = String.join("", sb) + "-";
            long idAvion = i + 1;                               
            int capacidad = (int) (Math.random() * 200 + 100);  
            if (idAvion % 2 == 0) {
                Avion avion = new Avion(madrid, barcelona, prefijoID, idAvion, capacidad, log);
                avion.start();
            } else {
                Avion avion = new Avion(barcelona, madrid, prefijoID, idAvion, capacidad, log);
                avion.start();
            }
            try {
                Thread.sleep((new Random().nextInt(3) * 1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
