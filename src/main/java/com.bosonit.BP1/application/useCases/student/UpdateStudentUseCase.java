package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.student.UpdateStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort  {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<StudentOutputDTO> updateStudent (String id, StudentInputDTO studentDTO) {

        if (studentRepository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
            else{
                Student student = modelMapper.map(studentDTO, Student.class);
                student.setId_student(id);

                if (student.getHours_per_week() == null || student.getBranch() == null)
                throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
                studentRepository.save(student);

                StudentOutputDTO studentOut = modelMapper.map(student, StudentOutputDTO.class);

            return ResponseEntity.ok().body(studentOut);
         }
    }

    public List<SubjectOutputDTO> addSubjectList (String id, List<String> idSubjects) throws Exception {

        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("STUDENT NOT FOUND"));
        List<Subject> subjectList = new ArrayList<>();

        idSubjects.forEach(subjectID -> {
            Subject subject = subjectRepository.findById(subjectID).orElseThrow(() -> new CustomErrorRequest404("WRONG SUBJECT ID IN: " + subjectID));
            subjectList.add(subject);

        });

        subjectList.forEach(subject -> {
            if (!student.getSubjectList().contains(subject)) {
                student.getSubjectList().add(subject);
                studentRepository.save(student);}
        });

        List<SubjectOutputDTO> subjectListOutputDTO = new ArrayList<>();
        subjectList.forEach(subject -> {
            SubjectOutputDTO subjectOutputDTO = modelMapper.map(subject, SubjectOutputDTO.class );
            subjectListOutputDTO.add(subjectOutputDTO);
        });

        return subjectListOutputDTO;
    }

    public List<SubjectOutputDTO> deleteSubjectList (String id, List<String> idSubjects)  {

        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomErrorRequest404("STUDENT NOT FOUND"));
        List<Subject> subjectList = new ArrayList<>();

        idSubjects.forEach(subjectID -> {
            Subject subject = subjectRepository.findById(subjectID).orElseThrow(() -> new CustomErrorRequest404("WRONG SUBJECT ID IN: " + subjectID));
            subjectList.add(subject);

        });

        subjectList.forEach(subject -> {
            if (student.getSubjectList().contains(subject)) {
                student.getSubjectList().remove(subject);
                studentRepository.save(student);
            }
        });

        List<SubjectOutputDTO> subjectListOutputDTO = new ArrayList<>();
        subjectList.forEach(subject -> {
            SubjectOutputDTO subjectOutputDTO = modelMapper.map(subject, SubjectOutputDTO.class );
            subjectListOutputDTO.add(subjectOutputDTO);
        });

        return subjectListOutputDTO;
    }

}
