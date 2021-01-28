package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepo;
import guru.springframework.spring5webapp.Repositories.BookRepo;
import guru.springframework.spring5webapp.Repositories.PublisherRepo;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//tells spring framework that its a spring component
@Component
public class BootStrapData implements CommandLineRunner {

    //add all repos here to add them to the class
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    //constructor that makes sure the class can use the repos
    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //creates author
        Author eric = new Author("Eric", "Evans");
        //creates book
        Book ddd = new Book("Domain Driven Design", "123123");
        //creates Publisher
        Publisher publisher = new Publisher();
        publisher.setName("Howler");
        publisher.setCity("LA");
        publisher.setState("CA");

        publisherRepo.save(publisher);

        //adds author to the book and the book to the author
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //adds ddd to publisher and visa-versa
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        //need to save author and book
        authorRepo.save(eric);
        bookRepo.save(ddd);
        //saves publisher with book
        publisherRepo.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2ee Development", "123456789");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepo.save(rod);
        bookRepo.save(noEjb);
        publisherRepo.save(publisher);

        //outputting to console
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Publishers: " + publisherRepo.count());
        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
