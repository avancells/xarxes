/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class Serversocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int contador = 0;
        try {
            ServerSocket server = new ServerSocket(8189);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client numero " + contador);
                Runnable r = new ServerManagement(socket, contador);
                Thread t = new Thread(r);
                t.start();
                contador++;
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

