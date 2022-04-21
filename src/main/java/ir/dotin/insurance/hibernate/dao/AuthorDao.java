package ir.dotin.insurance.hibernate.dao;

import ir.dotin.insurance.hibernate.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
}
