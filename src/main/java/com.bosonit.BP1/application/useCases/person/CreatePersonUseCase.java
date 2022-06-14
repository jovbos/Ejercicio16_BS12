package com.bosonit.BP1.application.useCases.person;

import com.bosonit.BP1.application.ports.person.CreatePersonPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePersonUseCase implements CreatePersonPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonRepository repository;

    public PersonOutputDTO addPerson(PersonInputDTO personDTO){

        Person person = modelMapper.map(personDTO, Person.class);

        if (person.getUsuario() == null || person.getPassword() == null || person.getName() == null || person.getCompany_email() == null
        || person.getPersonal_email() == null || person.getCity() == null || person.getActive() == null || person.getCreated_date() == null
        || person.getUsuario().length() > 10) throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(person);

        return modelMapper.map(person, PersonOutputDTO.class);
    }
}
