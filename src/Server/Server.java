package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta) {
        this.porta = porta;
        try {
            this.serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            System.err.println("Errore nella creazione del socket");
        }
    }

    public void attendi() {
        try {
            this.clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Errore nella connessione con il server");
        }
    }

    public void scrivi(String mess) {
        try {
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            pw.println(mess);

        } catch (IOException e) {
            System.err.println("Errore nella scrittura");
        }

    }

    public void leggi() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
            String risposta = br.readLine();
            System.out.println("SERVER : messaggio ricevuto dal client: " + risposta);
        } catch (IOException e) {
            System.err.println("Errore nella lettura");
        }
    }

    public void chiudi() {
        try {
            clientSocket.close();
            serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Errore nella chiusura della connessione");
        }
    }
}
