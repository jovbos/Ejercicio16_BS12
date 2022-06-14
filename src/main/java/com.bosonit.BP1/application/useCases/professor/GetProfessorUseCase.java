package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.professor.GetProfessorPort;
import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.PersonRepository;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProfessorUseCase implements GetProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfessorRepository professorRepository;

    public ResponseEntity<ProfessorOutputDTO> getProfessorId(String id, String outputType) throws Exception {

        ProfessorOutputDTO professorOutputDTO;
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("PROFESSOR NOT REGISTERED"));
        if (outputType.equals("full")){
            ProfessorFullOutputDTO professorFullOutputDTO = modelMapper.map(professor, ProfessorFullOutputDTO.class);
            professorFullOutputDTO.setId_person(professor.getPerson().getId());
            professorFullOutputDTO.setPerson(modelMapper.map(professor.getPerson(), PersonOutputDTO.class));


            return ResponseEntity.ok().body(professorFullOutputDTO);

        } else {
            professorOutputDTO = modelMapper.map(professor, ProfessorOutputDTO.class);
            professorOutputDTO.setId_person(professor.getPerson().getId());

            return ResponseEntity.ok().body(professorOutputDTO);
        }
    }

    public List<ProfessorOutputDTO> getProfessorAll() {

        List<ProfessorOutputDTO> listDTO = new ArrayList<>();
        List<Professor> ProfessorList = professorRepository.findAll();
        ProfessorList.forEach(p -> {
            ProfessorOutputDTO professorOutputDTO = modelMapper.map(p, ProfessorOutputDTO.class);
            professorOutputDTO.setId_person(p.getPerson().getId());
            listDTO.add(professorOutputDTO);
        });

        return listDTO;
    }

    public List<StudentOutputDTO> getProfessorStudents(String id) {

        Professor professor = professorRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("PROFESSOR NOT REGISTERED"));
        List<Student> studentList = professor.getStudentList();
        List<StudentOutputDTO> listDTO = new ArrayList<>();

        studentList.forEach(student -> {
            StudentOutputDTO studentOutputDTO = modelMapper.map(student, StudentOutputDTO.class);
            studentOutputDTO.setId_person(student.getPerson().getId());
            studentOutputDTO.setId_professor(student.getProfessor().getId_professor());
            listDTO.add(studentOutputDTO);
        });

        return listDTO;
    }


}
