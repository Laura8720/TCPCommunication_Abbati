package MainClient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("CLIENT: il client si è connesso al server"); //3wayhandshake
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.print("Ciao server!");
            pw.flush();
            System.out.println("CLIENT: il client ha inviato un messaggio");
        } catch (IOException e) {
            System.err.println("Errore nella connessione con il server");
        }

    }
}