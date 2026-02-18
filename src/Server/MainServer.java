package Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione!");
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: in attesa di richieste dei clienti"); //server in ascolto
            Socket clientSocket = server.accept();
            System.out.println("SERVER: il client si è connesso");
            //comunicazione

            //lettura
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String messaggio = br.readLine();
            System.out.println("SERVER: il client " + clientSocket
                    + "ha scritto il messaggio " + messaggio);
            //scrittura

            //chiusura
            clientSocket.close(); //chiusura data socket
            server.close();
        } catch (IOException e) {
            System.err.println("La porta non è disponibile," +
                    "errore nella creazione del connection socket");
        }

    }
}