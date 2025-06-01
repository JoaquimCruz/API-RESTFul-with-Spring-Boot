package br.com.joaquim.data.dto.v1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class BooksDTO extends RepresentationModel<BooksDTO> implements Serializable {

    private long id;
    private String author;
    private String title;
    private LocalDate launchDate;

    private Double price;

    public BooksDTO() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooksDTO booksDTO = (BooksDTO) o;
        return getId() == booksDTO.getId() && Objects.equals(getAuthor(), booksDTO.getAuthor()) && Objects.equals(getTitle(), booksDTO.getTitle()) && Objects.equals(getLaunchDate(), booksDTO.getLaunchDate()) && Objects.equals(getPrice(), booksDTO.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getTitle(), getLaunchDate(), getPrice());
    }



}
