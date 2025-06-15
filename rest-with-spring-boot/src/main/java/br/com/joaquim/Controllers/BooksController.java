package br.com.joaquim.Controllers;

import br.com.joaquim.Controllers.docs.BooksControllerDocs;
import br.com.joaquim.Services.BooksServices;
import br.com.joaquim.data.dto.v1.BooksDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books/v1")
@Tag(name = "books", description = "Endpoints for managing books")
public class BooksController implements BooksControllerDocs {

    @Autowired
    private BooksServices booksServices;

    @GetMapping("/{id}")
    @Override
    public BooksDTO FindById(@PathVariable("id") Long id){
        return booksServices.FindById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<BooksDTO> FindAll(){
        return booksServices.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BooksDTO create(@RequestBody BooksDTO book){
        return booksServices.create(book);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BooksDTO update(@RequestBody BooksDTO book){
        return booksServices.update(book);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> Delete(@PathVariable("id") Long id){
        booksServices.delete(id);
        return ResponseEntity.noContent().build(); // It will return a 204 No Content response
    }

}
