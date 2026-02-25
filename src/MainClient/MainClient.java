package MainClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");

        try {

            //richiesta di connessione e connessione
            Socket socket = new Socket("localhost", 3000);
            System.out.println("CLIENT: il client si è connesso al server"); //3wayhandshake

            //istanzio il reader e il writer
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), false);
            BufferedReader br = new BufferedReader(new InputStreamReader((socket.getInputStream())));

            //inizio  comunicazione e scambio del primo messaggio
            pw.println("Ciao server!");
            pw.flush();
            System.out.println("CLIENT: il client ha inviato un messaggio");
            String messaggio = br.readLine();
            System.out.println("CLIENT: messaggio ricevuto: " + messaggio);

            //ciclo while che ripete la lettura e la scrittura finchè l'utente non scrive "esci"
            String mex = "";
            while (!mex.equals("esci")){
                //importo lo scanner per leggere il messaggio che ha scritto l'utente
                Scanner sc = new Scanner(System.in);
                System.out.print("Scrivi messaggio: ");
                mex = sc.nextLine();

                //con il writer mando il messaggio al SERVER
                pw.println(mex);
                pw.flush();

                //messaggio di risposta ricevuto dal SERVER
                String messaggio2 = br.readLine();
                System.out.println("CLIENT: il messaggio ricevuto dal server è: " +
                         messaggio2);
            }
            socket.close();

        } catch (IOException e) {
            System.err.println("Errore nella connessione con il server");
        }

    }
}