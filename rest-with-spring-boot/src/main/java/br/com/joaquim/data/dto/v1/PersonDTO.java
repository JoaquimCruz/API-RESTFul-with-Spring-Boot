package br.com.joaquim.data.dto.v1;




import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
//@JsonPropertyOrder({"id", "name", "surname", "address", "gender"})
@Relation(
        collectionRelation = "people",
        itemRelation = "person")
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

    private Boolean enabled;

    public PersonDTO() {
    }


}