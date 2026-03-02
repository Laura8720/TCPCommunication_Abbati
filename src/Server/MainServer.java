package Server;

import MainClient.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        String mex = "";
        Scanner sc = new Scanner(System.in);

        Server server = new Server(3000);
        System.out.println("SERVER: in attesa di connessione");
        server.attendi();
        System.out.println("SERVER: client connesso");


        while (!mex.equals("esci")) {
            server.leggi();
            System.out.println("Scrivi messaggio: ");
            mex = sc.nextLine();

            server.scrivi(mex);
        }

        server.chiudi();

    }
}
