package br.com.joaquim.Controllers;


import br.com.joaquim.Controllers.docs.PeopleControllerDocs;
import br.com.joaquim.Services.PersonServices;
import br.com.joaquim.data.dto.v1.PersonDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Hateoas (Hypermedia as the Engine of Application State) é uma forma de construir APIs RESTful que permite que os clientes descubram e naveguem pelas funcionalidades da API através de links fornecidos nas respostas. Isso significa que, em vez de ter que conhecer todos os endpoints da API de antemão, os clientes podem seguir os links fornecidos nas respostas para acessar recursos relacionados. Isso torna a API mais flexível e fácil de usar, pois os clientes podem descobrir novos recursos sem precisar consultar a documentação da API.
// Permite que os clientes naveguem dinamicamente entre seus endpoints, tornando a API mais intuitiva e fácil de usar. Isso é especialmente útil em APIs grandes e complexas, onde pode ser difícil para os desenvolvedores conhecerem todos os endpoints disponíveis. Além disso, o HATEOAS pode ajudar a desacoplar o cliente do servidor, permitindo que o servidor altere sua estrutura interna sem afetar o cliente, desde que os links fornecidos permaneçam os mesmos.
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for managing people")
public class PeopleController implements PeopleControllerDocs {

    @Autowired
    private PersonServices service;


    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public PersonDTO FindById(@PathVariable("id") Long id){
        return service.FindById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<PersonDTO> FindAll(){
        return service.FindAll();
    }



    // Colocou para aceitar o Yaml
    // No postman tem que colocar nos headers o Accept: application/yaml e Content-Type: application/yaml.
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    /*
    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return service.createV2(person);
    }*/


    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }




    @PatchMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
    @Override
    public PersonDTO disablePerson(@PathVariable("id") Long id){
        return service.disablePerson(id);
    }


    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> Delete(@PathVariable("id") Long id){
        service.Delete(id);
        return ResponseEntity.noContent().build(); // It will return a 204 No Content response
    }
}
