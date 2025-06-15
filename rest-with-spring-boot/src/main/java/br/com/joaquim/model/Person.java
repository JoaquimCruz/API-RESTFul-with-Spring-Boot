package br.com.joaquim.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Person class representing a person entity with id, name, surname, and address.
 * Implements Serializable for object serialization.
 */

// The javax.persistence package is used for JPA annotations, but it is oracle domains.
// But jakarta.persistence is free, developed by the community
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Like auto_increment in MySQL
    private Long id;
    @Column(name = "name", nullable = false, length = 80) // Define that the atribute cant be null
    private String name;
    @Column(name = "surname", nullable = false, length = 80) // Define that the atribute cant be null
    private String surname;
    @Column(nullable = false, length = 80) // Define that the atribute cant be null
    private String address;
    // Colocar o atributo birthdate como podendo ser nulo, até que todos os clientes possam passar para a versao V2
    @Column(nullable = false, length = 6) // Male or Female
    private String gender;

    @Column(nullable = false)
    private Boolean enabled;



    public Person() {}



}
