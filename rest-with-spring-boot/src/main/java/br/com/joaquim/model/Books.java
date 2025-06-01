package br.com.joaquim.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table (name = "Books")
public class Books implements Serializable {

    @Id
    private Long id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Author", nullable = false)
    private String author;

    @Column(name = "Launch_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate launch_date;

    @Column(name = "Price", nullable = false)
    private Double price;

    public Books() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id) && Objects.equals(title, books.title) && Objects.equals(author, books.author) && Objects.equals(launch_date, books.launch_date) && Objects.equals(price, books.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, launch_date, price);
    }


}
