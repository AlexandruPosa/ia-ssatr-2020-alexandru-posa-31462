/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


public class BookNetConnector {
    
    BookService pService;

    public BookNetConnector() throws ClassNotFoundException, SQLException {
        pService = new BookService();
    }
    
    public void startServer(){
        
        try{
        
        ServerSocket ss =new ServerSocket(4050);
        
        while(true){
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");
            //...... 
            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
            //......
            String line = "";
            //while(!line.equals("close connection")){
                String title = fluxIn.readLine();
                String author = fluxIn.readLine();
                int year = Integer.parseInt(fluxIn.readLine());
                String result = pService.handleTitle(title, author, year);
                fluxOut.println(result);
            //}

            s.close();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BookNetConnector netCon = new BookNetConnector();
        netCon.startServer();
    }
}
