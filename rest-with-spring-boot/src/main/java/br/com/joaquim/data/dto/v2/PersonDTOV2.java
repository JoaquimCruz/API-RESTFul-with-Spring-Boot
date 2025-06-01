package br.com.joaquim.data.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// Essa classe dtov2 implementa um versinamento com uma mudança de atributos em pessoa.
public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;
    private String surname;
    private Date birthDate;
    private String address;
    private String gender;

    public PersonDTOV2() {}

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getBirthDate(), that.getBirthDate()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getBirthDate(), getAddress(), getGender());
    }
}
