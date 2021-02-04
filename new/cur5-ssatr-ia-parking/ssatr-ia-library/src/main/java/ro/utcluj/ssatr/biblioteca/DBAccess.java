/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

    private Connection conn;
    
    public DBAccess() throws ClassNotFoundException, SQLException {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection("jdbc:derby://localhost/biblioteca;create=false","APP","APP");
    }
   
    public void insertBook(BookEntity e) throws SQLException{
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO CARTE VALUES ('"+e.getTitle()+"','"+e.getAuthor()+"',"+e.getYear()+")");        
        s.close();
    }
    
    public BookEntity findByTitle(String title) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CARTE WHERE TITLU='"+title+"'");
        if(rs.next()){
            return new BookEntity(rs.getString("TITLU"), rs.getString("AUTOR"),rs.getInt("AN_APARITIE"));
        }else{
            return null;
        }           
    }
    
    public void deleteByTitle(String title) throws SQLException{
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM CARTE WHERE TITLU='"+title+"'");        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBAccess db = new DBAccess();

        BookEntity result = db.findByTitle("White Fang");
        System.out.println(result);
        if(result!=null){
            db.deleteByTitle(result.getTitle());
            System.out.println("Book deleted!");
        }else{
            System.out.println("Book not found");
        }
        
    }
    
}
