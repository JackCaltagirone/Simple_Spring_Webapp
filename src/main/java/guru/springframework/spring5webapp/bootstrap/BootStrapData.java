package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepo;
import guru.springframework.spring5webapp.Repositories.BookRepo;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//tells spring framework that its a spring component
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //creates author
        Author eric = new Author("Eric", "Evans");
        //creates book
        Book ddd = new Book("Domain Driven Design", "123123");
        //adds author to the book adn the book to the author
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //need to save author and book
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2ee Development", "123456789");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepo.save(rod);
        bookRepo.save(noEjb);


        //outputting to console
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepo.count());
    }
}
