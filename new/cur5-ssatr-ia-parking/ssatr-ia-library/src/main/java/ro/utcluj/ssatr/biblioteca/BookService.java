/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.biblioteca;

import java.sql.SQLException;

public class BookService {
    
    private DBAccess db;
    

    public BookService() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }
  
    public synchronized String handleTitle(String title,String author,int year) throws SQLException{
        BookEntity c = db.findByTitle(title);
        if(c==null){
            BookEntity x = new BookEntity(title,author,year);
            db.insertBook(x);
            return "Book title : "+x.getTitle()+ " Author: "+x.getAuthor()+" Year:"+ x.getYear();
        }else{
            db.deleteByTitle(title);
            return "Book deleted: "+c.getTitle();
        } 
    }
    
    
    public static void main(String[] args) throws Exception {
        BookService b = new BookService();
        int year=1994;
        System.out.println(b.handleTitle("White Fang","Jack London", year));
      
    }
    
}
