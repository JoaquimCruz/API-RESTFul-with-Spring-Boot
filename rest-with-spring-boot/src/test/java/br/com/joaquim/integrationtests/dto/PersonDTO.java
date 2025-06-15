package br.com.joaquim.integrationtests.dto;




import java.io.Serializable;
import java.util.Objects;


//@JsonPropertyOrder({"id", "name", "surname", "address", "gender"})
public class PersonDTO implements Serializable {

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

    private Boolean enabled;

    public PersonDTO() {}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getName(), personDTO.getName()) && Objects.equals(getSurname(), personDTO.getSurname()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getEnabled(), personDTO.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAddress(), getGender(), getEnabled());
    }

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
