package Server;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione!");
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: in attesa di richieste dei clienti");
            Socket clientSocket = server.accept();
            System.out.println("SERVER: il client si è connesso");
            clientSocket.close(); //chiusura data socket
            server.close();
        } catch (IOException e) {
            System.err.println("La porta non è disponibilr," +
                    "errore nella creazione del connection socket");
        }

    }
}