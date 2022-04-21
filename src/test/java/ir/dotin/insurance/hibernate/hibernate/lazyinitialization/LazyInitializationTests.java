package ir.dotin.insurance.hibernate.hibernate.lazyinitialization;

import com.github.javafaker.Faker;
import ir.dotin.insurance.hibernate.dao.AuthorDao;
import ir.dotin.insurance.hibernate.model.Author;
import ir.dotin.insurance.hibernate.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LazyInitializationTests {

    private final Faker faker = new Faker(new Locale("fa"));
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AuthorDao authorDao;


    @Test
    void test() {
        final var author = new Author();
        author.setName(faker.name().fullName());
        final var math = new Book("Math 1", author);
        final var os = new Book("Operating System", author);
        final var ds = new Book("Data Structure", author);
        author.setBooks(Set.of(math, os, ds));
        authorDao.save(author);
    }

    @Test
    void testFetch() {
//        entityManager.getTransaction().begin();
        final Author fetchedAuthor = entityManager.createQuery("select a from Author a join fetch a.books where a.id = 25", Author.class).getSingleResult();
//        entityManager.getTransaction().commit();
//        entityManager.close();

        assertThat(fetchedAuthor.getName()).isEqualTo("رخسار عزیزی");
        assertThat(fetchedAuthor.getBooks()).hasSize(3);
    }
}
