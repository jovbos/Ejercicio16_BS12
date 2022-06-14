package com.bosonit.BP1.application.useCases.person;

import com.bosonit.BP1.application.ports.person.DeletePersonPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonRepository repository;

    public ResponseEntity<PersonOutputDTO> deletePerson(Integer id)  throws Exception {
    if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
    else {

        Person person = repository.findById(id).orElseThrow(() -> new Exception("Person not registered."));

        if (person.getStudent() == null & person.getProfessor() == null)
        repository.delete(person);
        else throw new Exception("YOU MUST DELETE STUDENT/PROFESSOR DATA FIRST");

        return ResponseEntity.ok().build();
        }
    }
}
