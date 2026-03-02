package MainClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        String mex = "";
        Scanner sc = new Scanner(System.in);

        Client client = new Client("Laura");
        client.connetti("localhost", 3000);

        while (!mex.equals("esci")) {
            System.out.println("Scrivi messaggio: ");
            mex = sc.nextLine();

            client.scrivi(mex);
            client.leggi();
        }

        client.chiudi();

    }
}