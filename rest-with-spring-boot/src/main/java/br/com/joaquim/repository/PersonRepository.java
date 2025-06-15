package br.com.joaquim.repository;

import br.com.joaquim.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// The JpaRepository interface provides CRUD operations for the Person entity.
// It extends the JpaRepository interface, which is part of Spring Data JPA.
// The first parameter is the entity type (Person), and the second parameter is the type of the entity's identifier (Long).
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id = :id")
    void disablePerson(@Param("id")Long id);
}
