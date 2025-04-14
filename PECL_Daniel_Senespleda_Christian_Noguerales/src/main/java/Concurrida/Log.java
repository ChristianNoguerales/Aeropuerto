package Concurrida;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private static final String LOG_FILE_NAME = "evolucionAeropuerto.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private BufferedWriter writer;

    public Log() {
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo de log: " + e.getMessage());
        }
    }

    public synchronized void writeLog(String event) {
        String timeStamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        String logLine = timeStamp + " " + event;

        try {
            writer.write(logLine);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }

    public synchronized void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo de log: " + e.getMessage());
        }
    }
}
