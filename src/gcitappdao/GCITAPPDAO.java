/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitappdao;

import dao.AuthorDAO;
import dao.BookDAO;
import entity.Author;
import entity.Book;
import java.util.List;

/**
 *
 * @author tictoc
 */
public class GCITAPPDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testAuthor(4);
        testBook(1);
    }
    
    public static void testAuthor(int i){
        AuthorDAO author = new AuthorDAO();
        String authorName= "New Auth";
        int authorID = 9;

        switch (i){
            case 1: //add auhtor
                Author newAuthor = new Author();
                newAuthor.setAuthorName(authorName);
                author.addAuthor(newAuthor);
                System.out.println("Author "+authorName+" added successfully");
                break;
            case 2: //update author
                Author updateAuthor = new Author();  
                updateAuthor.setAuthorId(authorID);
                updateAuthor.setAuthorName(authorName);                 
                author.updateAuthor(updateAuthor);
                System.out.println("Author updated successfully");
                break;
            case 3: //delete author
                Author deleteAuthor = new Author();                 
                deleteAuthor.setAuthorId(authorID);
                author.deleteAuthor(deleteAuthor);
                System.out.println("Author deleted successfully");
                break;
            case 4: //select authors
                List <Author> authorsList =  author.readAllAuthors();
                for(Author authorObject : authorsList){
                    System.out.println(authorObject.getAuthorId()+" "+authorObject.getAuthorName());
                }
                break;
            default:
            break;
        }        
    }    
    public static void testBook(int i){
        BookDAO book = new BookDAO();
        String bookName= "Book For Test 2";
        int bookID = 8;
        int pubId=1;

        switch (i){
            case 1: //add book (pubId need because of foreign key constraint//delete/update casade)
                Book newBook = new Book();
                newBook.setTitle(bookName);
                //newBook.setPubId(pubId);
                book.addBook(newBook);
                System.out.println("Book \""+bookName+"\" added successfully");
                break;
            case 2: //update book
                Book updateBook = new Book();  
                updateBook.setBookId(bookID);
                updateBook.setTitle(bookName);                 
                book.updateBook(updateBook);
                System.out.println("Book updated successfully");
                break;
            case 3: //delete book
                Book deleteBook = new Book();                 
                deleteBook.setBookId(bookID);
                book.deleteBook(deleteBook);
                System.out.println("Book deleted successfully");
                break;
            case 4: //select book
                List <Book> booksList =  book.readAllBook();
                for(Book bookObject : booksList){
                    System.out.println(bookObject.getBookId()+" "+bookObject.getTitle()+" "+bookObject.getPubId());
                }
                break;
            default:
            break;
        }        
    }    
}
