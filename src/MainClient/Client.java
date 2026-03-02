package MainClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    String name;
    String colore;
    Socket socket;

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, String colore) {
        this.name = name;
        this.colore = colore;
    }

    public void connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
        } catch (IOException e) {
            System.err.println("Errore nella connessione con il server");
        }
    }

    public void scrivi(String mess) {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(mess);

        } catch (IOException e) {
            System.err.println("Errore nella scrittura");
        }
    }

    public void leggi() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            String risposta = br.readLine();
            System.out.println("CLIENT: messaggio ricevuto dal server: " + risposta);

        } catch (IOException e) {
            System.err.println("Errore nella lettura");
        }
    }

    public void chiudi() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Errore nella scrittura");
        }
    }
}
