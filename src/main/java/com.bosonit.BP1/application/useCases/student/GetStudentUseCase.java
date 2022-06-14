package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.student.GetStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetStudentUseCase implements GetStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<StudentOutputDTO> getStudentId(String id, String outputType) throws Exception {

        StudentOutputDTO studentOutputDTO;
        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("STUDENT NOT REGISTERED"));
        if (outputType.equals("full")){
            StudentFullOutputDTO studentFullOutputDTO = modelMapper.map(student, StudentFullOutputDTO.class);
            studentFullOutputDTO.setId_person(student.getPerson().getId());
            studentFullOutputDTO.setId_professor(student.getProfessor().getId_professor());
            studentFullOutputDTO.setPerson(modelMapper.map(student.getPerson(), PersonOutputDTO.class));

            return ResponseEntity.ok().body(studentFullOutputDTO);

        } else {
            studentOutputDTO = modelMapper.map(student, StudentOutputDTO.class);
            studentOutputDTO.setId_person(student.getPerson().getId());
            studentOutputDTO.setId_professor(student.getProfessor().getId_professor());

            return ResponseEntity.ok().body(studentOutputDTO);
        }
    }

    public List<StudentOutputDTO> getStudentAll() {

        List<StudentOutputDTO> listDTO = new ArrayList<>();
        List<Student> StudentList = studentRepository.findAll();
        StudentList.forEach(p -> {
            StudentOutputDTO studentOutputDTO = modelMapper.map(p, StudentOutputDTO.class);
            studentOutputDTO.setId_person(p.getPerson().getId());
            studentOutputDTO.setId_professor(p.getProfessor().getId_professor());
            listDTO.add(studentOutputDTO);
        });

        return listDTO;
    }

    public List<SubjectOutputDTO> getStudentSubjects(String id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("STUDENT NOT REGISTERED"));
        List<Subject> studentList = student.getSubjectList();
        List<SubjectOutputDTO> listDTO = new ArrayList<>();

        studentList.forEach(subject -> {
            SubjectOutputDTO subjectOutputDTO = modelMapper.map(subject, SubjectOutputDTO.class);
            listDTO.add(subjectOutputDTO);
        });

        return listDTO;

    }

}
