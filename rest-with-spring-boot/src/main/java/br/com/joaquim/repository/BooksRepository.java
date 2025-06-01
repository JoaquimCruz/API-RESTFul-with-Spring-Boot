package br.com.joaquim.repository;

import br.com.joaquim.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BooksRepository extends JpaRepository<Books, Long> {

}
