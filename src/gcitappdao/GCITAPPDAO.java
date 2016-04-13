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
        AuthorDAO author = new AuthorDAO();
        List <Author> authorsList =  author.readAllAuthors();
        for(Author authorObject : authorsList){
            System.out.println(authorObject.getAuthorId()+" "+authorObject.getAuthorName());
            authorObject.getAuthorId();
        }
        //System.out.println(authorsList);
    }
    
}
