package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.professor.CreateProfessorPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CreateProfessorUseCase implements CreateProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository professorRepository;

//    @Autowired
//    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    public ProfessorOutputDTO addProfessor(ProfessorInputDTO professorDTO) throws Exception{

        Professor professor = modelMapper.map(professorDTO, Professor.class);

        if (professor.getBranch() == null) throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");

        Optional<Person> checkPerson = personRepository.findById(professorDTO.getId_person());
        Person checker = personRepository.findById(professorDTO.getId_person()).orElseThrow(() -> new CustomErrorRequest404("PERSONAL DATA NOT FOUND"));

        // Metodo alternativo de evitar duplicados sin la necesidad de crear una relacion bidireccional: {
        //
        //        List<Student> checkStudent = studentRepository.findByPersonId(professorDTO.getId_person());
        //        List <Professor> checkProfessor = professorRepository.findByPersonId(professorDTO.getId_person());
        //  }

        if (checkPerson.isEmpty())throw new CustomErrorRequest404("PERSONAL DATA NOT FOUND");
        if (checker.getProfessor() == null & checker.getStudent() == null) {
            professor.setPerson(checkPerson.get());
            professorRepository.save(professor);
            ProfessorOutputDTO professorOutputDTO = modelMapper.map(professorDTO, ProfessorOutputDTO.class);
            professorOutputDTO.setId_professor(professor.getId_professor());

            return professorOutputDTO;
        } else throw new CustomErrorRequest404("PERSON ALREADY REGISTERED");
    }
}
