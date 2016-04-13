package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Author;

public class AuthorDAO extends BaseDAO{

    public void addAuthor(Author author){		
        try{
            save("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
        } catch(ClassNotFoundException ce){

        }catch(SQLException se){
        }
    }

    public void updateAuthor(Author author){		
        try{
            save("update tbl_author set authorName = ? where authorId = ?", new Object[] {author.getAuthorName(), author.getAuthorId()});
        } catch(ClassNotFoundException ce){

        }catch(SQLException se){
        }
    }

    public void deleteAuthor(Author author){		
        try{
            save("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorId()});
        } catch(ClassNotFoundException ce){

        }catch(SQLException se){
        }                
    }

    public List<Author> readAllAuthors() {
        try{
            return (List<Author>) readAll("select * from tbl_author", null);
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
        return null;
    }

    public List<Author> readAuthorsByName(String name){
        try{
            return (List<Author>) readAll("select * from tbl_author where authorName like ?", new Object[] {name});
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
        return null;
    }

    public Integer getCount(){		
        try{
            return getCount("select count(*) from tbl_author");
        }      catch(ClassNotFoundException ce){            
        }catch(SQLException se){
        }
        return null;
    }

    @Override
    public List<Author> extractData(ResultSet rs) {		
        try{
            List<Author> authors = new ArrayList<Author>();		
            while(rs.next()){
                    Author a = new Author();
                    a.setAuthorId(rs.getInt("authorId"));
                    a.setAuthorName(rs.getString("authorName"));			
                    authors.add(a);
            }
            return authors;
        }catch(SQLException se){
        }
        return null;            
    }

}
