package br.com.joaquim.Services;

import br.com.joaquim.Controllers.PeopleController;
import br.com.joaquim.data.dto.v1.PersonDTO;
import br.com.joaquim.data.dto.v2.PersonDTOV2;
import br.com.joaquim.exception.RequiredObjectIsNullException;
import br.com.joaquim.exception.ResourceNotFoundException;
import br.com.joaquim.mapper.ObjectMapper;
import br.com.joaquim.mapper.custom.PersonMapper;
import br.com.joaquim.model.Person;
import br.com.joaquim.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;


import java.util.List;


/*Essa parte de serviços teve uma mudança por conta da implementação do data transfer Objects (DTO), agora
temos que chamar o PersonMapper.java para converter a entidade em DTO para depois criar as pessoas.*/

@Service
public class PersonServices {


    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;


    public PersonDTO FindById(Long id){
        var entity= repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        var dto =  ObjectMapper.map(entity, PersonDTO.class);
        AddHateoasLinks(dto);
        return dto;
        // return the person of the id. It's converted to DTO
    }

    public List<PersonDTO> FindAll(){

        var people =  ObjectMapper.mapList(repository.findAll(), PersonDTO.class);
        people.forEach(p -> {
            try {
                AddHateoasLinks(p);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return people;

    }


    public PersonDTO create(PersonDTO person) {

        if(person == null) throw new RequiredObjectIsNullException();
        logger.info("Create person: " + person);
        var entity = ObjectMapper.map(person, Person.class);

        var dto = ObjectMapper.map(repository.save(entity), PersonDTO.class);
        AddHateoasLinks(dto);
        return dto;
        // Converts DTO person to a person entity and saves it in the database. The line above converts
        // the person entity to a DTO.
    }

    // Criação de um novo metodo createV2, que recebe um PersonDTOV2 e retorna um PersonDTOV2.
    // Parte do segundo versionamento feito.
    public PersonDTOV2 createV2(PersonDTOV2 person) {

        logger.info("Create personV2: " + person);
        var entity = converter.convertDTOToEntity(person);

        return converter.convertEntityToDTO(repository.save(entity));
        // Converts DTOV2 person to a person entity and saves it in the database. The line above converts
        // the person entity to a DTO.
    }

    public PersonDTO update (PersonDTO person){
        if(person == null) throw new RequiredObjectIsNullException();
        Person Entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        Entity.setName(person.getName());
        Entity.setSurname(person.getSurname());
        Entity.setAddress(person.getAddress());
        Entity.setGender(person.getGender());

        logger.info("Update person: " + person);

        var dto = ObjectMapper.map(repository.save(Entity), PersonDTO.class);
        AddHateoasLinks(dto);
        return dto;
    }

    public void Delete(Long id){
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);

        logger.info("Delete person");
    }


    private static void AddHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PeopleController.class).FindById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PeopleController.class).FindAll()).withRel("FindAll").withType("GET"));
        dto.add(linkTo(methodOn(PeopleController.class).create(dto)).withRel("Create").withType("POST"));
        dto.add(linkTo(methodOn(PeopleController.class).update(dto)).withRel("Update").withType("PUT"));
        dto.add(linkTo(methodOn(PeopleController.class).Delete(dto.getId())).withRel("Delete").withType("DELETE"));
    }

}
