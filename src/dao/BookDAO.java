/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tictoc
 */
public class BookDAO extends BaseDAO{
    
    public void addBook(Book book){		
        try{
            save("insert into tbl_book (title, pubId) values (?,?)", new Object[] {book.getTitle(), book.getPubId()});
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
            System.out.println("insert book:\n"+se);
        }
    }
	
    public void updateBook(Book book){
        try{
            save("update tbl_book set title = ? , pubId =? where bookId = ?", new Object[] {book.getTitle(), book.getPubId(), book.getBookId()});
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
    }

    public void deleteBook(Book book) {		 
        try{
            save("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
    }

    public List<Book> readAllBook() {
        try{
            return (List<Book>) readAll("select * from tbl_book", null);}
        catch(ClassNotFoundException ce){

        }catch(SQLException se){
        }
        return null;
    }

    public List<Book> readBooksByName(String title){

        try{
            return (List<Book>) readAll("select * from tbl_book where title like ?", new Object[] {title});
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
        return null;
    }

    public Integer getCount(){		
        try{
            return getCount("select count(*) from tbl_book");
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
        return null;
    }

    @Override
    public List<Book> extractData(ResultSet rs) {

        try{
            List<Book> books = new ArrayList<Book>();		
            while(rs.next()){
                    Book a = new Book();
                    a.setBookId(rs.getInt("bookId"));
                    a.setTitle(rs.getString("title"));
                    a.setPubId(rs.getInt("pubId"));
                    books.add(a);
            }
            return books;
        }catch(SQLException se){
        }
        return null;
    }

    
}
