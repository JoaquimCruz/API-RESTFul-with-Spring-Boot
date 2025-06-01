package br.com.joaquim.Services;

import br.com.joaquim.Controllers.BooksController;
import br.com.joaquim.data.dto.v1.BooksDTO;
import br.com.joaquim.exception.RequiredObjectIsNullException;
import br.com.joaquim.mapper.ObjectMapper;
import br.com.joaquim.model.Books;
import br.com.joaquim.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BooksServices {

    @Autowired
    BooksRepository booksRepository;


    public BooksDTO FindById(Long id){
        var entity = booksRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID"));
        var dto = ObjectMapper.map(entity, BooksDTO.class);
        AddHateoasLinks(dto);
        return dto;
    }

    public BooksDTO create(BooksDTO book){
        if (book == null) throw new RequiredObjectIsNullException();
        var entity = ObjectMapper.map(book, Books.class);
        var dto = ObjectMapper.map(booksRepository.save(entity), BooksDTO.class);
        AddHateoasLinks(dto);
        return dto;
    }

    public BooksDTO update(BooksDTO book) {
        if (book == null) throw new RequiredObjectIsNullException();
        Books entity = booksRepository.findById(book.getId()).orElseThrow(() -> new RuntimeException("No records found for this ID"));
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setLaunch_date(book.getLaunchDate());
        entity.setPrice(book.getPrice());

        var dto = ObjectMapper.map(booksRepository.save(entity), BooksDTO.class);
        AddHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id){
        Books entity = booksRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID"));
        booksRepository.delete(entity);
    }

    public List<BooksDTO> findAll() {
        var books = ObjectMapper.mapList(booksRepository.findAll(), BooksDTO.class);
        books.forEach(b -> {
            try {
                AddHateoasLinks(b);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return books;
    }

    private static void AddHateoasLinks(BooksDTO dto) {
        dto.add(linkTo(methodOn(BooksController.class).FindById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).FindAll()).withRel("FindAll").withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).create(dto)).withRel("Create").withType("POST"));
        dto.add(linkTo(methodOn(BooksController.class).update(dto)).withRel("Update").withType("PUT"));
        dto.add(linkTo(methodOn(BooksController.class).Delete(dto.getId())).withRel("Delete").withType("DELETE"));
    }
}
