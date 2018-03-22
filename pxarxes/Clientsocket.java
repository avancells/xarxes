/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class Clientsocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Scanner entradaDades = new Scanner(System.in);
            //podeu provar de conectar la IP 132.163.4.101
            //que correspon al National Institute of Standards
            //and Technology, en Boulder Colorado, i ofereix
            //la mesura d'un rellotge atòmic de Cesi
            System.out.println("Introdueix la IP del host");
            String IP_Address = entradaDades.next();
            //el port al que ens conectem és el 13
            System.out.println("Introdueix el port");
            int port = entradaDades.nextInt();
            Socket socket = new Socket(IP_Address, port);
            try{
                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                Scanner in = new Scanner(entrada);
                while(in.hasNextLine()){
                    String linia = in.nextLine();
                    System.out.println(linia);
                }
            //compte amb fer servir el Rellotge atomic
            //aqui perque no podem enviar dades, només
            //ens envia les dades i donarà una excepció
            // per evitar-ho comenteu les següents 3 linies
                PrintWriter out = new PrintWriter(salida,true);
                String dadesAEnviar = in.next();
                out.println(dadesAEnviar);
            }finally{
                socket.close();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
        
}


