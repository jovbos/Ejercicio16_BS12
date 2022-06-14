package com.bosonit.BP1.application.useCases.person;

import com.bosonit.BP1.application.ports.person.UpdatePersonPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonRepository repository;

    public ResponseEntity<PersonOutputDTO> updatePerson (Integer id, PersonInputDTO personDTO) {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
            else{
                Person person = modelMapper.map(personDTO, Person.class);
                person.setId(id);

                if (person.getUsuario() == null || person.getPassword() == null || person.getName() == null || person.getCompany_email() == null
                || person.getPersonal_email() == null || person.getCity() == null || person.getActive() == null || person.getCreated_date() == null
                || person.getUsuario().length() > 10) throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
                repository.save(person);

                PersonOutputDTO personOut = modelMapper.map(person, PersonOutputDTO.class);

            return ResponseEntity.ok().body(personOut);
         }
    }
}
