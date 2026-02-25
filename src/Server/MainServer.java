package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione!");
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: in attesa di richieste dei clienti"); //server in ascolto
            Socket clientSocket = server.accept();
            System.out.println("SERVER: il client si è connesso");
            //comunicazione

            //istanzio il reader e il writer
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), false);
            BufferedReader br = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
            String messaggio = br.readLine();

            //scrittura
            System.out.println("SERVER: il client " + clientSocket
                    + "ha scritto il messaggio " + messaggio);

            //ciclo while
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

            //chiusura
            clientSocket.close(); //chiusura data socket
            server.close();
        } catch (IOException e) {
            System.err.println("La porta non è disponibile," +
                    "errore nella creazione del connection socket");
        }

    }
}