/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class ServerManagement implements Runnable {
    private Socket socket;
    private int contador;
    public ServerManagement(Socket i, int c) {
        socket = i;
        contador = c;
    }
    
    public void run() {

        try {
            try {
                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                Scanner in = new Scanner(entrada);
                PrintWriter out = new PrintWriter(salida,true);
                out.println("Servidor connectat. Escriu BYE per sortir");
                boolean fin = true;
                while (fin && in.hasNextLine()){
                    String linia = in.nextLine();
                    out.println("ECHO: "+linia);
                    if(linia.trim().equals("BYE"))
                        fin = false;
                }
            } finally {
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
