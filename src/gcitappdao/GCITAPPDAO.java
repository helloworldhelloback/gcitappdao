/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitappdao;

import dao.AuthorDAO;
import entity.Author;
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
        testAuthor(4);
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
                    authorObject.getAuthorId();
                }
                break;
            default:
            break;
        }        
    }    
}
