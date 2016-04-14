package gcitappdao;

import java.sql.SQLException;
import java.util.List;

import entity.Author;
import entity.Book;
import service.AdministratorService;

public class TestService {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AdministratorService service = new AdministratorService();
//		createAuthor(service);
		getAllAuthors(service);
		//getAllBooks(service);
		//createAuthorWithID(service);
	}

	private static void createAuthor(AdministratorService service) throws ClassNotFoundException, SQLException {
		Author a = new Author();

		a.setAuthorName("Testing author from service");
		service.createAuthor(a);
	}
	
	private static void createAuthorWithID(AdministratorService service) throws ClassNotFoundException, SQLException {
		Author a = new Author();

		a.setAuthorName("Testing author from service1");
		System.out.println("Printing new ID of Author "+service.createAuthorWithID(a));
	}

	private static void getAllAuthors(AdministratorService service) throws ClassNotFoundException, SQLException {
		List<Author> authors = service.getAllAuthors();

		for (Author a : authors) {
			System.out.println("Author Name: ");
			System.out.println(a.getAuthorName());
			if (a.getBooks() != null && a.getBooks().size() > 0) {
				System.out.println("Printing Book Titles for author");
				for (Book b : a.getBooks()) {
					System.out.println(b.getTitle());
				}
			}
			System.out.println("--------------------");
		}
	}

	private static void getAllBooks(AdministratorService service) throws ClassNotFoundException, SQLException {
		List<Book> books = service.getAllBooks();

		for (Book b : books) {
			System.out.println("Book Title " + b.getTitle());
			if (b.getAuthors() != null && b.getAuthors().size() > 0) {
				System.out.println("Printing authors for book:");

				for (Author a : b.getAuthors()) {
					System.out.println(a.getAuthorName());
				}
			}
		}

	}
}
