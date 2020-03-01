package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repoistories.AuthorRepository;
import guru.springframework.spring5webapp.repoistories.BookRepository;
import guru.springframework.spring5webapp.repoistories.PublisherRepoistory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
The purpose of this class is to create some authors and books, and save them into the repos.
This is done at start up of the spring context, since it extends CommandLineRunner
 */

// Spring will look for these types and automatically run them
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepoistory publisherRepoistory;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepoistory publisherRepoistory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepoistory = publisherRepoistory;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepoistory.save(publisher);

        System.out.println("Publisher Count: " + publisherRepoistory.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepoistory.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2342342434");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepoistory.save(publisher);

        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
