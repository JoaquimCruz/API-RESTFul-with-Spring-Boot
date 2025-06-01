package br.com.joaquim.mapper.custom;

import br.com.joaquim.data.dto.v2.PersonDTOV2;
import br.com.joaquim.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

// Essa classe é um mapper customizado, que converte a entidade pessoa para o DTO e vice-versa.
// Para isso foi usado o dozer.
/*Essa classe dentro do pacote custom é para o versionamento V2, feito pela diferenciação da entidade usuário.
Assim, ocorreu o aumento de atributos da entidade usuário, sendo necessário esse versionamento. Então é necessario
 fazer a conversar de entidade para DTO, acrescentando o novo atributo, e vice versa. Não é usado o DOZER aqui.
 Em aplicações usuais é necessário fazer a modificação do mapeamento do banco de dados (Person.java) aumentando o atributo
 birthdate e colocando a notation @column nele. Por alguns usuários ainda usarem o V1, o atributo não poderá ser obrigatorio.
 Ele se tornará obrigatório apenas quando todos os usuários passarem para o segundo versionamento V2*/
@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person){
        PersonDTOV2 personDTO = new PersonDTOV2();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setAddress(person.getAddress());
        personDTO.setBirthDate(new Date());
        // O atributo birthdate não esta mapeado no bandco de dados.
        // Em uma aplicação real criariamos esse atributo lá, mapeariamos ele e o deixariamos como se
        // ele pudesse ser null, assim não quebraria nenhum cliente.
        // Caso os clientes todos já passasem para a versão 2, poderiamos setar essea atributo no banco de dados
        // como não pode ser null.
        personDTO.setGender(person.getGender());
        return personDTO;
    }

    public Person convertDTOToEntity(PersonDTOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAddress(person.getAddress());
        // O atributo birthdate não esta mapeado no bandco de dados.
        // Em uma aplicação real criariamos esse atributo lá, mapeariamos ele e o deixariamos como se
        // ele pudesse ser null, assim não quebraria nenhum cliente.
        // Caso os clientes todos já passasem para a versão 2, poderiamos setar essea atributo no banco de dados
        // como não pode ser null.
        entity.setGender(person.getGender());
        return entity;
    }
}
