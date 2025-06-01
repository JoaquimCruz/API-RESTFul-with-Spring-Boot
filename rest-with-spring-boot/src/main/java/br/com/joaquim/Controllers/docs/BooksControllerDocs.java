package br.com.joaquim.Controllers.docs;

import br.com.joaquim.data.dto.v1.BooksDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// Essa classe foi criada para documentar os endpoints da API usando Swagger.
// Colocar essas informações no controller ia deixar o código muito poluído.
public interface BooksControllerDocs {

    @Operation(summary = "finds a book", description = "find a specific book by their id", tags = {"Books"},
            responses = {
                    @ApiResponse(description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BooksDTO.class))
                    ),

                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bady Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "No found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

            })
    BooksDTO FindById(@PathVariable("id") Long id);


    @Operation(summary = "find all books", description = "finds all books", tags = {"books"},
            responses = {
                    @ApiResponse(description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BooksDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bady Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "No found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

            })
    List<BooksDTO> FindAll();


    @Operation(summary = "Adds a new book", description = "adds a new book", tags = {"books"},
            responses = {
                    @ApiResponse(description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BooksDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bady Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

            })
    BooksDTO create(@RequestBody BooksDTO book);


    @Operation(summary = "Updates a book's information", description = "Updates a book", tags = {"books"},
            responses = {
                    @ApiResponse(description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BooksDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bady Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "No found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    BooksDTO update(@RequestBody BooksDTO book);



    @Operation(summary = "Deletes a book", description = "Deletes a specific book by their id", tags = {"books"},
            responses = {

                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bady Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "No found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

            })
    @DeleteMapping("/{id}")
    ResponseEntity<?> Delete(@PathVariable("id") Long id);
}
