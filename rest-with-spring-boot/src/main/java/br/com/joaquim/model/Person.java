package br.com.joaquim.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Person class representing a person entity with id, name, surname, and address.
 * Implements Serializable for object serialization.
 */

// The javax.persistence package is used for JPA annotations, but it is oracle domains.
// But jakarta.persistence is free, developed by the community
@Entity
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

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAddress());
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
