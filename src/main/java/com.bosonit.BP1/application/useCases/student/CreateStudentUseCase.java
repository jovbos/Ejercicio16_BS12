package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.student.CreateStudentPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CreateStudentUseCase implements CreateStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfessorRepository professorRepository;

    public StudentOutputDTO addStudent(StudentInputDTO studentDTO) throws Exception {

        Student student = modelMapper.map(studentDTO, Student.class);

        if (student.getHours_per_week() == null || student.getBranch() == null)
            throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");

        Optional<Person> person = personRepository.findById(studentDTO.getId_person());
        Optional<Professor> professor = professorRepository.findById(studentDTO.getId_professor());
        Person checker = personRepository.findById(studentDTO.getId_person()).orElseThrow(() -> new CustomErrorRequest404("PERSONAL DATA NOT FOUND"));

        // Metodo alternativo de evitard duplicado sin la necesidad de crear una relacion bidireccional: {
        //
        //        List <Student> checkStudent = studentRepository.findByPersonId(studentDTO.getId_person());
        //        List <Professor> checkProfessor = professorRepository.findByPersonId(studentDTO.getId_person());
        //    }

        if (person.isEmpty())throw new CustomErrorRequest404("PERSONAL DATA NOT FOUND");
        if (professor.isEmpty())throw new CustomErrorRequest404("ASSIGNED PROFESSOR NOT FOUND");
        if (checker.getStudent() == null & checker.getProfessor() == null) {
            student.setPerson(person.get());
            student.setProfessor(professor.get());
            studentRepository.save(student);
            StudentOutputDTO studentOutputDTO = modelMapper.map(studentDTO, StudentOutputDTO.class);
            studentOutputDTO.setId_student(student.getId_student());

            return studentOutputDTO;
        } else throw new CustomErrorRequest404("PERSON ALREADY REGISTERED");
    }
}
