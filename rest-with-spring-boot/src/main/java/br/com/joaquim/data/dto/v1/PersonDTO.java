package br.com.joaquim.data.dto.v1;




import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

import java.util.Objects;


//@JsonPropertyOrder({"id", "name", "surname", "address", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private static final long serialVersionUID = 1L;
    // @JsonProperty("id_usuario")
    private Long id;

    private String name;
    // @JsonInclude(JsonInclude.Include.NON_NULL) esse comando é para mostrar a propriedade apenas se não for nula
    private String surname;
    // Para formato de data, usamos o @JsonFormat. Para o formato brasileiro ficaria como
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String address;

    //@JsonIgnore
    private String gender;

    public PersonDTO() {}

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
        if (!(o instanceof PersonDTO person)) return false;
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
