package com.bosonit.BP1.application.useCases.person;

import com.bosonit.BP1.application.ports.person.GetPersonPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonProfDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonStuDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonRepository personRepository;

//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    ProfessorRepository professorRepository;

    public ResponseEntity<PersonOutputDTO> getPersonId(Integer id, String outputType) throws Exception {

        PersonOutputDTO personOutputDTO;
        Person person = personRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("PERSON NOT FOUND"));

        if (outputType.equals("full")) {
            if (person.getStudent() != null) {
                PersonStuDTO personStuDTO = modelMapper.map(person, PersonStuDTO.class);
                return ResponseEntity.ok().body(personStuDTO);
            } else if (person.getProfessor() != null) {
                PersonProfDTO personProfDTO = modelMapper.map(person, PersonProfDTO.class);
                return ResponseEntity.ok().body(personProfDTO);
            } else throw new CustomErrorRequest404("NOT PERSON OR STUDENT DATA FOR THIS PERSON");
        }
        else return ResponseEntity.ok().body(modelMapper.map(person, PersonOutputDTO.class));
    }


    public List<PersonOutputDTO> getPersonName (String name, String outputType) {

        List<Person> personList = personRepository.findByName(name);
        List<PersonOutputDTO> listDTO = new ArrayList<>();

        if (outputType.equals("full")) {
        personList.forEach(person -> {

                if (person.getStudent() != null) {
                    PersonStuDTO personStuDTO = modelMapper.map(person, PersonStuDTO.class);
                    listDTO.add(personStuDTO);
                } else if (person.getProfessor() != null) {
                    PersonProfDTO personProfDTO = modelMapper.map(person, PersonProfDTO.class);
                    listDTO.add(personProfDTO);
                } else {
                    PersonOutputDTO personOutputDTO = modelMapper.map(person, PersonOutputDTO.class);
                    listDTO.add(personOutputDTO);
                }
            });
            return listDTO;

        } else {
            personList.forEach(person -> {

                PersonOutputDTO personOutputDTO = modelMapper.map(person, PersonOutputDTO.class);
                listDTO.add(personOutputDTO);

            });
            return listDTO;
        }
    }

    public List<PersonOutputDTO> getPersonAll(String outputType) {

        List<Person> personList = personRepository.findAll();
        List<PersonOutputDTO> listDTO = new ArrayList<>();

        if (outputType.equals("full")) {
            personList.forEach(person -> {

                if (person.getStudent() != null) {
                    PersonStuDTO personStuDTO = modelMapper.map(person, PersonStuDTO.class);
                    listDTO.add(personStuDTO);
                } else if (person.getProfessor() != null) {
                    PersonProfDTO personProfDTO = modelMapper.map(person, PersonProfDTO.class);
                    listDTO.add(personProfDTO);
                } else {
                    PersonOutputDTO personOutputDTO = modelMapper.map(person, PersonOutputDTO.class);
                    listDTO.add(personOutputDTO);
                }
            });
            return listDTO;

        } else {
            personList.forEach(person -> {

                PersonOutputDTO personOutputDTO = modelMapper.map(person, PersonOutputDTO.class);
                listDTO.add(personOutputDTO);

            });
            return listDTO;
        }
    }
}
