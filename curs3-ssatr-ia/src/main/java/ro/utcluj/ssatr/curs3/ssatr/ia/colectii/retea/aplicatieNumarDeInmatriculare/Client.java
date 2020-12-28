/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea.aplicatieNumarDeInmatriculare;

/**
 *
 * @author Alex
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mihai.hulea
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");
         //...... 
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        
        fluxOut.println("AB-09-CRC");
        String response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("MM-17-BLA");
        response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("CT-66-OOO");
        response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("AB-09-CRC");
        response = fluxIn.readLine();
        System.out.println(response);
                 
        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);
        
        
        s.close();
    }
}
